package com.qfedu.ljb.common.test;



import com.qfedu.ljb.common.util.EncryptionUtil;

import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/13 11:16
 */
public class AES_Test {
/*    public static void main(String[] args) {
//        String key=EncryptionUtil.createAESKEY();
//        System.out.println(key);
//        String pass="123456";
//        String mw=EncryptionUtil.AESEnc(key,pass);
//        System.out.println("密文："+mw);
//        System.out.println("解密："+EncryptionUtil.AESDec(key,mw));
       Map<String,String> map= EncryptionUtil.createRSAKey();
       String pass="123456";
        System.out.println(map);
       String mw=EncryptionUtil.RSAEnc(map.get(EncryptionUtil.PRIVATEKEY),pass);
        System.out.println("密文："+mw);
        System.out.println("明文："+EncryptionUtil.RSADec(map.get(EncryptionUtil.PUBLICKEY),mw));
    }*/
public static void main(String[] args) {
    //获取秘钥对
    Map<String, String> map = EncryptionUtil.createRSAKey();
    String pass = "123456";
    System.out.println(map);
    //私钥加密
    String mw = EncryptionUtil.RSAEnc(map.get(EncryptionUtil.PRIVATEKEY), pass);
    System.out.println(mw);
    //公钥解密
    String pass2 = EncryptionUtil.RSADec(map.get(EncryptionUtil.PUBLICKEY), mw);
    System.out.println(pass2);



}





}
