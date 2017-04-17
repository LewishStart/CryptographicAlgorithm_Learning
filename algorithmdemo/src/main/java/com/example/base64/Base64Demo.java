package com.example.base64;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * author: sundong
 * created at 2017/4/17 16:01
 */


public class Base64Demo {
    private static final String src= "https://github.com/LewishStart";
    private static void jdkBase64Test(){
        String strEncode = "";
        String strDecode = "";
        BASE64Encoder base64Encoder = new BASE64Encoder();
        strEncode = base64Encoder.encode(src.getBytes());

        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] bytes = base64Decoder.decodeBuffer(strEncode);
            strDecode = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------JDK BASE64 Algorithm Test------");
        System.out.println("Src:"+src);
        System.out.println("Encode:"+strEncode);
        System.out.println("Decode:"+strDecode);
        System.out.println("-------------------------------");
    }

    private static void CommonsCodesBase64Test(){
        String strEncode = new String(Base64.encodeBase64(src.getBytes()));
        String strDecode = new String(Base64.decodeBase64(strEncode));

        System.out.println("------Commons Codec BASE64 Algorithm Test------");
        System.out.println("Src:"+src);
        System.out.println("Encode:"+strEncode);
        System.out.println("Decode:"+strDecode);
        System.out.println("-------------------------------");
    }
    public static  void main(String[] args){
        jdkBase64Test();
        CommonsCodesBase64Test();
    }
}
