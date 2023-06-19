
package com.xingquan.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    /*** 验签开始 ****/

    public static boolean rsa256verify(String data, String rsaPubkey, String signature) {

        try {
            return verify(data.getBytes("UTF-8"), Base64.getDecoder().decode(rsaPubkey.getBytes("UTF-8")),
                    Base64.getDecoder().decode(signature.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verify(byte[] databyte, byte[] rsapubkeybyte, byte[] signaturebyte) {
        String algorithm = "SHA256withRSA";

        String key = "RSA";

        try {

            Signature signature = Signature.getInstance(algorithm);

            PublicKey pubkey = (PublicKey) KeyFactory.getInstance(key)
                    .generatePublic(new X509EncodedKeySpec(rsapubkeybyte));

            signature.initVerify(pubkey);

            signature.update(databyte);
            return signature.verify(signaturebyte);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    /*** 验签结束 ****/

    /*** 加签开始 ****/

    public static String rsa256sign(String data, String rsaPrivatekey) {

        try {
            byte[] signaturebyte = sign(data.getBytes("UTF-8"), Base64.getDecoder().decode(rsaPrivatekey.getBytes("UTF-8")));

            return new String(Base64.getEncoder().encode(signaturebyte), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] sign(byte[] databyte, byte[] rsaprivatekeybyte) {
        String algorithm = "SHA256withRSA";
        String key = "RSA";

        try {

            PrivateKey privatekey = KeyFactory.getInstance(key)
                    .generatePrivate(new PKCS8EncodedKeySpec(rsaprivatekeybyte));

            Signature signature = Signature.getInstance(algorithm);

            signature.initSign(privatekey);

            signature.update(databyte);

            byte[] signbyte = signature.sign();

            return signbyte;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("f");
        }

        return null;
    }

    /*** 加签结束 ****/

    /*** 解密开始 ****/
    public static String decrypt(String data, String aeskey) {

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(2, new SecretKeySpec(aeskey.getBytes("UTF-8"), "AES"));

            byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(data.getBytes("UTF-8")));

            return new String(decryptBytes, "UTF-8");

        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;

    }

    /*** 解密结束 ****/
    /*** 加密开始 ****/

    public static String encrypt(String data, String aeskey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] dataByte = data.getBytes("UTF-8");

            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(aeskey.getBytes("UTF-8"), "AES"));

            byte[] encryptBytes = cipher.doFinal(dataByte);

            return new String(Base64.getDecoder().decode(encryptBytes), "UTF-8");

        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    /*** 加签结束 ****/

}
