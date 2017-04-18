package com.example.symmetric_cryptography.DES;

import org.apache.commons.codec.binary.Hex;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * author: sundong
 * created at 2017/4/17 20:17
 */

public class DESTest {
    private static final String src= "https://github.com/LewishStart";
    private static void jdk3DESTest(){
        try {
            // 生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            // 必须长度是：112或168
//			keyGenerator.init(168);
            keyGenerator.init(168);
            // 产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获取密钥
            byte[] bytesKey = secretKey.getEncoded();

            // KEY转换
            DESedeKeySpec desKeySpec = new DESedeKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            // 加密
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk 3des encrypt:" + Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk 3des decrypt:" + new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        jdk3DESTest();
    }
}
