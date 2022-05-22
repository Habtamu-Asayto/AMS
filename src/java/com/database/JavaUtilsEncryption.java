
package com.database;

import java.security.MessageDigest;
public class JavaUtilsEncryption {
  public static String generateSaltedHash(String password, String saltPhrase) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
 
      if (saltPhrase != null) {
        md.update(saltPhrase.getBytes());
        byte[] salt = md.digest();
 
        md.reset();
        md.update(password.getBytes());
        md.update(salt);
      } else
      {
        md.update(password.getBytes());
      }
      byte[] raw = md.digest();
      return convertByteToHex(raw);
    } catch (Exception e) {
      return e.toString();
    }
  }
 
  private static String convertByteToHex(byte[] byteData) {
    StringBuilder sb = new StringBuilder();
    // System.out.println("byteData.length " + byteData.length);
    for (int i = 0; i < byteData.length; i++) {
      sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
          .substring(1));
    }
    return sb.toString();
  }
 
}