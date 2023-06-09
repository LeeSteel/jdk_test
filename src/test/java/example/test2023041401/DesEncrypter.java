package example.test2023041401;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/4/14 23:23
 * @Copyright: Copyright (c) 2019
 */

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

    public class DesEncrypter {

        public static final String CD_KEY = "<<mishu2016@@!!>>";
        Cipher ecipher;
        Cipher dcipher;

        // 8-byte Salt

//	byte[] salt = {
//
//	(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
//
//	(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
//
//	};

        byte[] salt = {

                (byte) 0xA9, (byte) 0x9A, (byte) 0xCC, (byte) 0x32,

                (byte) 0x56, (byte) 0x35, (byte) 0xED, (byte) 0x03

        };

        // Iteration count

        int iterationCount = 30;

        public DesEncrypter(String passPhrase) {

            try {

                // Create the key

                KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt,
                        iterationCount);

                SecretKey key = SecretKeyFactory.getInstance(

                        "PBEWithMD5AndDES").generateSecret(keySpec);

                ecipher = Cipher.getInstance(key.getAlgorithm());

                dcipher = Cipher.getInstance(key.getAlgorithm());

                // Prepare the parameter to the ciphers

                AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
                        iterationCount);

                // Create the ciphers

                ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

                dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

            } catch (java.security.InvalidAlgorithmParameterException e) {

            } catch (java.security.spec.InvalidKeySpecException e) {

            } catch (javax.crypto.NoSuchPaddingException e) {

            } catch (java.security.NoSuchAlgorithmException e) {

            } catch (java.security.InvalidKeyException e) {

            }

        }

        @SuppressWarnings("hiding")
        public String encrypt(String str) {

            try {

                // Encode the string into bytes using utf-8

                byte[] utf8 = str.getBytes("UTF8");

                // Encrypt

                byte[] enc = ecipher.doFinal(utf8);

                // Encode bytes to base64 to get a string

                return new sun.misc.BASE64Encoder().encode(enc);

            } catch (javax.crypto.BadPaddingException e) {
                return null;
            } catch (IllegalBlockSizeException e) {
                return null;
            } catch (UnsupportedEncodingException e) {
                return null;
            } catch (java.io.IOException e) {
                return null;
            }
        }

        public String decrypt(String str) {

            try {

                // Decode base64 to get bytes

                byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

                // Decrypt

                byte[] utf8 = dcipher.doFinal(dec);

                // Decode using utf-8

                return new String(utf8, "UTF8");

            } catch (javax.crypto.BadPaddingException e) {
                return null;
            } catch (IllegalBlockSizeException e) {
                return null;
            } catch (UnsupportedEncodingException e) {
                return null;
            } catch (java.io.IOException e) {
                return null;
            }


        }

        /**
         * 判断字符串是否含有中文
         */
        public static boolean isChineseCharacter(String chineseStr) {
            char[] charArray = chineseStr.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if ((charArray[i] >= 0x4e00) && (charArray[i] <= 0x9fbb)) {
                    //Java判断一个字符串是否有中文是利用Unicode编码来判断，
                    //  因为中文的编码区间为：0x4e00--0x9fbb
                    return true;
                }
            }
            return false;
        }

        /**
         * 密码加密
         *
         * @param pwd
         * @return
         */
        public static String pwdEncrypt(Object pwd) {
            DesEncrypter des = new DesEncrypter(DesEncrypter.CD_KEY);
            return des.encrypt((String) pwd);
        }

        /**
         * 密码解密
         *
         * @param pwd
         * @return
         */
        public static String pwdDecrypt(Object pwd) {
            DesEncrypter des = new DesEncrypter(DesEncrypter.CD_KEY);
            return des.decrypt((String)pwd);
        }

        public static void main(String[] args) {
            System.out.println(pwdEncrypt("WAL015"));
            System.out.println(pwdEncrypt("123456"));
        }

}
