package com.example.messagedigest.MAC;

import org.apache.commons.codec.binary.Hex;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/**
 * author: sundong
 * created at 2017/4/17 16:24
 */

public class MacTest {
    private static final String src= "https://github.com/LewishStart";
    private static void jdkMacTest(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");//初始化KeyGenerator
            SecretKey secretKey = keyGenerator.generateKey();//产生密钥
//            byte[] key = secretKey.getEncoded();
//            System.out.println("GeneratorKey:"+Hex.encodeHexString(key));
//
//
//            SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");//还原密钥
//            System.out.println("RestoreSecretKey:"+Hex.encodeHexString(restoreSecretKey.getEncoded()));

            Mac mac = Mac.getInstance(secretKey.getAlgorithm());//实例化MAC
            mac.init(secretKey);//初始化MAC
            String macMD5Digest = Hex.encodeHexString(mac.doFinal(src.getBytes()));
            System.out.println("jdk HmacMD5:"+macMD5Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        jdkMacTest();
    }
}
