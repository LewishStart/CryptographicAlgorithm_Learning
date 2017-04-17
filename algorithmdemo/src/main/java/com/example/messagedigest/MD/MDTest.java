package com.example.messagedigest.MD;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author: sundong
 * created at 2017/4/17 16:23
 */

public class MDTest {
    private static final String src= "https://github.com/LewishStart";
    private static void jdkMD2Test(){
        try {
            MessageDigest md2 = MessageDigest.getInstance("MD2");
            String md2Digest = Hex.encodeHexString(md2.digest(src.getBytes()));
            System.out.println("jdkMD2:"+md2Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static void jdkMD5Test(){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String md5Digest = Hex.encodeHexString(md5.digest(src.getBytes()));
            System.out.println("jdkMD5:"+md5Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        jdkMD2Test();
        jdkMD5Test();
    }
}
