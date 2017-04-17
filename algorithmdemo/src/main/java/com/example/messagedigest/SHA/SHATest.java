package com.example.messagedigest.SHA;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author: sundong
 * created at 2017/4/17 16:24
 */

public class SHATest {
    private static final String src= "https://github.com/LewishStart";
    private static void jdkSHA1Test(){
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.update(src.getBytes());
            String sha1Digest = Hex.encodeHexString(sha1.digest());
            System.out.println("SHA1:"+sha1Digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static void jdkSHA224Test(){
        try {
            MessageDigest sha224 = MessageDigest.getInstance("SHA-224");
            sha224.update(src.getBytes());
            String sha1Digest = Hex.encodeHexString(sha224.digest());
            System.out.println("SHA224:"+sha1Digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static void jdkSHA256Test(){
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(src.getBytes());
            String sha1Digest = Hex.encodeHexString(sha256.digest());
            System.out.println("SHA256:"+sha1Digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static void jdkSHA384Test(){
        try {
            MessageDigest sha384 = MessageDigest.getInstance("SHA-384");
            sha384.update(src.getBytes());
            String sha1Digest = Hex.encodeHexString(sha384.digest());
            System.out.println("SHA384:"+sha1Digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static void jdkSHA512Test(){
        try {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            sha512.update(src.getBytes());
            String sha1Digest = Hex.encodeHexString(sha512.digest());
            System.out.println("SHA512:"+sha1Digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        jdkSHA1Test();
        jdkSHA224Test();
        jdkSHA256Test();
        jdkSHA384Test();
        jdkSHA512Test();
    }
}
