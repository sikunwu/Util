package com.chinadci.backendservice.common.encryption;


import java.util.Base64;

public class Base64Util
{
  /**
   * 对给定的字符串进行base64加密操作
   */
  public static String encodeData(byte[] password) {
    try {
      if (password==null||password.length==0) {
        return null;
      }
      return Base64.getEncoder().encodeToString(password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
