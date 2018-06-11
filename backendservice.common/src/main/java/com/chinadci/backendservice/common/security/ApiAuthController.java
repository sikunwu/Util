package com.chinadci.backendservice.common.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class ApiAuthController {
    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new myCustomDateEditor());
    }*/
    public String getCurrentClient()
    {
      OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
      String clientId = auth.getOAuth2Request().getClientId();
      return clientId;
    }
}
