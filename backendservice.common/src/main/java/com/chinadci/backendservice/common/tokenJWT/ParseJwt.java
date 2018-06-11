package com.chinadci.backendservice.common.tokenJWT;

import com.chinadci.backendservice.model.Properties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


import javax.xml.bind.DatatypeConverter;

public class ParseJwt
{

  public static Claims parseJWT(String jwt,Properties properties) {

    //This line will throw an exception if it is not a signed JWS (as expected)
    Claims claims = Jwts.parser()
      .setSigningKey(DatatypeConverter.parseBase64Binary(properties.getJwt_secret()))
      .parseClaimsJws(jwt).getBody();
    return claims;
  }
}
