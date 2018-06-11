package com.chinadci.backendservice.common.encryption;

import java.security.MessageDigest;

public class MD5Util
{
  //生成MD5
  public static byte[] getMD5(String message) {
    String md5 = "";
    byte[] md5Byte=null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象
      byte[] messageByte = message.getBytes("UTF-16LE");
      md.update(messageByte);
      md5Byte = md.digest();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return md5Byte;
  }
}
