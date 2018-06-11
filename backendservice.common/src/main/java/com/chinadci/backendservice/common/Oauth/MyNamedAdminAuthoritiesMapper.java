package com.chinadci.backendservice.common.Oauth;

import com.chinadci.backendservice.data.mappers.UserinfoMapper;
import com.chinadci.backendservice.data.model.Userinfo;
import com.chinadci.backendservice.data.model.UserinfoExample;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import org.mitre.openid.connect.client.NamedAdminAuthoritiesMapper;
import org.mitre.openid.connect.client.OIDCAuthoritiesMapper;
import org.mitre.openid.connect.client.SubjectIssuerGrantedAuthority;
import org.mitre.openid.connect.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

public class MyNamedAdminAuthoritiesMapper implements OIDCAuthoritiesMapper
{
  private static Logger logger = LoggerFactory.getLogger(NamedAdminAuthoritiesMapper.class);
  private static final SimpleGrantedAuthority ROLE_ADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
  private static final SimpleGrantedAuthority ROLE_USER = new SimpleGrantedAuthority("ROLE_USER");
  private Set<SubjectIssuerGrantedAuthority> admins = new HashSet();

  public void setOauth_admin(List<Userinfo> oauth_admin) {
    this.oauth_admin = oauth_admin;
  }

  private List<com.chinadci.backendservice.data.model.Userinfo> oauth_admin=new ArrayList();
  UserinfoMapper userinfoMapper;


  public MyNamedAdminAuthoritiesMapper() {
  }

  public Collection<? extends GrantedAuthority> mapAuthorities(JWT idToken, UserInfo userInfo) {
    HashSet out = new HashSet();

    try {
      pre_admin(userinfoMapper);
      List<String> list=new ArrayList<>();
      for (Userinfo u:oauth_admin)
      {
        list.add(u.getUserid());
      }

      JWTClaimsSet claims = idToken.getJWTClaimsSet();
      SubjectIssuerGrantedAuthority authority = new SubjectIssuerGrantedAuthority(claims.getSubject(), claims.getIssuer());
      out.add(authority);
      if (list.contains(claims.getSubject()))
      {
        out.add(ROLE_ADMIN);
      }
      /*SubjectIssuerGrantedAuthority authority = new SubjectIssuerGrantedAuthority(claims.getSubject(), claims.getIssuer());
      out.add(authority);
      if (this.admins.contains(authority)) {
        out.add(ROLE_ADMIN);
      }*/

      out.add(ROLE_USER);
    } catch (ParseException var6) {
      logger.error("Unable to parse ID Token inside of authorities mapper (huh?)");
    }

    return out;
  }

  public Set<SubjectIssuerGrantedAuthority> getAdmins() {
    return this.admins;
  }

  public void setAdmins(Set<SubjectIssuerGrantedAuthority> admins) {
    this.admins = admins;
  }


  public void setUserinfoMapper(UserinfoMapper userinfoMapper) {
    this.userinfoMapper = userinfoMapper;
  }

  boolean adminInited = false;

  public void pre_admin(UserinfoMapper userinfoMapper)
  {
    if(!adminInited) {
      List<BigDecimal> list = new ArrayList<>();
      list.add(BigDecimal.valueOf(-1));
      list.add(BigDecimal.valueOf(-2));
      UserinfoExample ue = new UserinfoExample();
      ue.or().andUsertypeIn(list);
      oauth_admin = userinfoMapper.selectByExample(ue);
      adminInited = true;
    }
  }
}
