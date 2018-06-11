package com.chinadci.backendservice.common.ehcacheUtil;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class EhcahceManager
{
  private Resource cacheManagerPath;

  public Resource getCacheManagerPath() {
    return cacheManagerPath;
  }

  public void setCacheManagerPath(Resource cacheManagerPath) {
    this.cacheManagerPath = cacheManagerPath;
  }

  public CacheManager getCacheManager() throws IOException {
    CacheManager cacheManager=CacheManager.create(getCacheManagerPath().getInputStream());
    return cacheManager;
  }

  public void set(String key,Object obj,String cacheName) throws IOException {
    CacheManager cacheManager=CacheManager.create(getCacheManagerPath().getInputStream());
    Cache cache=cacheManager.getCache(cacheName);
    Element element=new Element(key,obj);
    cache.put(element);
  }
  public Object get(String key,String cacheName) throws IOException {
    CacheManager cacheManager=CacheManager.create(getCacheManagerPath().getInputStream());
    Cache cache=cacheManager.getCache(cacheName);
    Element value=cache.get(key);
    if (value!=null)
    {
      Object object=value.getObjectValue();
      return object;
    }else
    {
      return null;
    }
  }
  public void remove(String key,String cacheName) throws IOException {
    CacheManager cacheManager=CacheManager.create(getCacheManagerPath().getInputStream());
    Cache cache=cacheManager.getCache(cacheName);
    cache.remove(key);
  }
  public void removeAll(String cacheName) throws IOException {
    CacheManager cacheManager=CacheManager.create(getCacheManagerPath().getInputStream());
    Cache cache=cacheManager.getCache(cacheName);
    cache.removeAll();
  }
}
