package com.chinadci.backendservice.common.transpond;

import com.chinadci.backendservice.model.GrantFieldinfo;
import com.chinadci.backendservice.model.IdentifyListResult;
import com.chinadci.backendservice.model.IdentifyResult;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TranspondUtil {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //@Cacheable(key = "#key",value = "transpond")
    public byte[] gettranspondJson(URLConnection urlConnection, HttpServletResponse response, String key, String fieldtype, List<GrantFieldinfo> fieldsInfoList) throws IOException {
        //Object object = redisTemplate.opsForValue().get(key);
        Object object = null;
        if (object != null) {
            byte[] bytes = (byte[]) object;
            return bytes;
        } else {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            // char[] buff=new char[1024];
            byte[] bytes = new byte[512];
            int len = -1;
            InputStream inputStream = urlConnection.getInputStream();

            if(fieldtype != null && fieldtype.length() > 0 && fieldsInfoList != null && fieldsInfoList.size() > 0) {
                String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                Gson gson = new Gson();
                IdentifyResult model = gson.fromJson(result, IdentifyResult.class);
                List<IdentifyListResult> resultmap = new ArrayList<>();
                for (IdentifyListResult item : model.results) {
                    Map<String, String> map = item.attributes;
                    Iterator<String> iter = map.keySet().iterator();
                    while (iter.hasNext()) {
                        String keymap = iter.next();
                        for (GrantFieldinfo f : fieldsInfoList) {
                            if(fieldtype.equals("name")) {
                                if (f.name.equals(keymap)) {
                                    iter.remove();
                                }
                            }else {
                                if (f.alias.equals(keymap)) {
                                    iter.remove();
                                }
                            }
                        }
                    }

                    item.attributes = map;
                    resultmap.add(item);
                }

                model.results = resultmap;

                result = gson.toJson(model);
                inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
            }

            while ((len = inputStream.read(bytes)) != -1) {
                //out.write(bytes, 0, len);
                outStream.write(bytes, 0, len);
                //out.flush();
                outStream.flush();
            }

            inputStream.close();
            //out.close();
            outStream.close();
            redisTemplate.opsForValue().set(key, outStream.toByteArray());
            return outStream.toByteArray();
        }
    }
}
