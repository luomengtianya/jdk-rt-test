package com.xingquan.secret;

import com.xingquan.utils.RSAUtil;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 生成密钥对
 *
 * @author pan jianghong
 * @version 1.0.0
 * @createdate 2023/5/23 14:50
 * @description 生成密钥对
 */
public class Keygen {


    public void keygen() {
        //生成密钥对
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            System.out.println(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
            System.out.println(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public void sign() {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVdicDx0DdDBjt9zMUvHJmF7Jdm7BmU5x59LAgR4uZU5Gs8xomi/b1TBRMxYkmgz+6wmQeCxHLKoutQKTKrxMWrCp8PWu0JWtNp0N1ToUCFoZ8CsodTVZqMpfd1HED57MdTlzTXFR3em2BQ/f6p9bRjJi+4g8GK8d0fiSiU1yuoQIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJV2JwPHQN0MGO33MxS8cmYXsl2bsGZTnHn0sCBHi5lTkazzGiaL9vVMFEzFiSaDP7rCZB4LEcsqi61ApMqvExasKnw9a7Qla02nQ3VOhQIWhnwKyh1NVmoyl93UcQPnsx1OXNNcVHd6bYFD9/qn1tGMmL7iDwYrx3R+JKJTXK6hAgMBAAECgYAClXlVMmOnrqbbrlNev2dG5o/52FAzZKym2xkUZcg/DVfOYqGIGxFY6kjLjvqxBMHcS7IJZu2W0pR5mU2AB4jP65tCtKQJ9ucO8lopMtKwIc6jOcKC5OiOlhQh1AomfG8Bnd0nL1/thwb9UofWeknyURtIQwbWNYdDBWGLSuYoAQJBAPNJ8xSV3EiJZY6EFhINndqk6+s2glDGWK6KWnVjR2kdGxo19xq/MPvebQdrSZ0dSFTgqZhjvizg731fgy6AouECQQCdRT0JfHTpFBnwR0TNxu+ITcj4/6/nrG0bgIrJ7qmb2RqisVsewvBrAq+SX7nTRXzHSYLNmdR0D755hmGy4UPBAkEA1YJhlQBL2VDTUrZy1BclIJw5+yvUQ+U+MLd02a5uHj6P6XnQyaVe7LvwPWGXsg3fy7V6wSVP4fzp0MKA0s/LoQJADUXZp+JMD5u1sLSjFubSMmO2MWWK1/eSYb7Qd8hfohqJh++F7CuxlKZuYOEZUr5LkJogou93oa/ueF0iA7HFQQJBAIjW80ROhnkwWbZRGb8YwDmZz/ozxCdZpVq7CxJ0TL6v1TTNzLWAHHsBWKp6JkJBKy7MOj2DX1eqmncp9vN6wSQ=";

        String data = "adfasdfasdfasfasdfasdfasdfasdfadsfadsf";

        String sign = RSAUtil.rsa256sign(data, privateKey);

        System.out.println(sign);

        System.out.println(RSAUtil.rsa256verify(data, publicKey, sign));


    }

    public static void main(String[] args) {
       Keygen keygen = new Keygen();
       keygen.sign();
    }

}
