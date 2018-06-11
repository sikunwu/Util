package com.chinadci.backendservice.common.security;

import com.chinadci.backendservice.common.dateEditor.MyDateEditor;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;


public abstract class AuthController {

    public String getCurrentUserId(){
        OIDCAuthenticationToken auth = (OIDCAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        return auth.getUserInfo().getSource().get("userid").getAsString();
    }

   /* public String getCurrentClient()
    {
      OIDCAuthenticationToken auth = (OIDCAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
      String token=auth.getIdToken().getParsedString();
      return token;
    }*/

}
