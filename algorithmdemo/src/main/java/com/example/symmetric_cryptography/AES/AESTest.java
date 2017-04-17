package com.example.symmetric_cryptography.AES;

import org.apache.commons.codec.binary.Hex;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * author: sundong
 * created at 2017/4/17 21:23
 */

public class AESTest {
    private static final String src= "https://github.com/LewishStart";
    private static final String ENCRYPT_KEY = "1111111111111111";
    private static void jdkAESTest1(){
        try
        {
            // 生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            // 产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获取密钥
            byte[] keyBytes = secretKey.getEncoded();

            System.out.println("length:"+new String(keyBytes).length());
            // KEY转换
            Key key = new SecretKeySpec(keyBytes, "AES");

            // 加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt:" + Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println("jdk aes decrypt:" + new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String AESEncrypt(String content,String password){
        String result = "";
        try {
            // KEY转换
            Key key = new SecretKeySpec(password.getBytes(), "AES");
            // 加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            result = Hex.encodeHexString(cipher.doFinal(content.getBytes("utf-8")));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
//    private static String AESDecrypt(String content,String password){
//        String result = "";
//        try {
//            //  KEY转换
//            Key key = new SecretKeySpec(password.getBytes(), "AES");
//            //解密
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
//            result = Hex.encodeHexString(bytes);
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            return result;
//        }
//    }

    public static void main(String[] args){
        jdkAESTest1();
    }
}
