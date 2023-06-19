//package com.xingquan.utils;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//
///**
// * MD5工具类
// *
// * @author happyqing
// * @since 2016.2.28
// */
//public class MD5Util {
//
//   // private static final Log log = LogFactory.getLog(MD5Util.class);
//
//    /**
//     * 字符串的MD5
//     *
//     * @param plainText
//     * @return
//     */
//    public static String encode(String plainText) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(plainText.getBytes("utf-8"));
//            byte[] bytes = md.digest();
//
//            int i;
//
//            StringBuffer buf = new StringBuffer();
//            for (int offset = 0; offset < bytes.length; offset++) {
//                i = bytes[offset];
//                if (i < 0) {
//                    i += 256;
//                }
//                if (i < 16) {
//                    buf.append("0");
//                }
//                buf.append(Integer.toHexString(i));
//            }
//            return buf.toString();
//            // System.out.println("result: " + buf.toString());// 32位的加密
//            // System.out.println("result: " + buf.toString().substring(8,24));// 16位的加密
//
//        } catch (Exception e) {
//            log.error(e);
//        }
//        return "";
//    }
//
//    /**
//     * 文件的MD5
//     *
//     * @param filePath
//     * @return
//     */
//    public static String getfilemd5(String filePath) {
//        String value = null;
//        FileInputStream in = null;
//        try {
//            File file = new File(filePath);
//            in = new FileInputStream(file);
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            byte[] buffer = new byte[8192];
//            int c;
//            while ((c = in.read(buffer)) != -1) {
//                md5.update(buffer, 0, c);
//            }
//            BigInteger bi = new BigInteger(1, md5.digest());
//            value = bi.toString(16).toUpperCase();
//        } catch (Exception e) {
//            log.error(e);
//        } finally {
//            if (null != in) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    log.error(e);
//                }
//            }
//        }
//        return value;
//    }
//
//    // 生成MD5
//    public static String getMD5(String message) throws Exception {
//        String md5 = "";
//        MessageDigest md = MessageDigest.getInstance("MD5"); // 创建一个md5算法对象
//        byte[] messageByte = message.getBytes("UTF-8");
//        byte[] md5Byte = md.digest(messageByte); // 获得MD5字节数组,16*8=128位
//        md5 = bytesToHex(md5Byte); // 转换为16进制字符串
//        return md5;
//    }
//
//    // 二进制转十六进制
//    private static String bytesToHex(byte[] bytes) throws Exception {
//        StringBuffer hexStr = new StringBuffer();
//        int num;
//        for (int i = 0; i < bytes.length; i++) {
//            num = bytes[i];
//            if (num < 0) {
//                num += 256;
//            }
//            if (num < 16) {
//                hexStr.append("0");
//            }
//            hexStr.append(Integer.toHexString(num));
//        }
//        return hexStr.toString().toUpperCase();
//    }
//}
