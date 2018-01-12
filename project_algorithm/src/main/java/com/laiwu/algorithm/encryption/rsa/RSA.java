package com.laiwu.algorithm.encryption.rsa;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSA {

  private static final String ALGORITHM = "RSA";
  private static String source = "it is a secret.";
  private static KeyFactory keyFactory = null;
  private static Cipher cipher = null;

  static {
    try {
      keyFactory = KeyFactory.getInstance(ALGORITHM);
      cipher = Cipher.getInstance(ALGORITHM);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static KeyPair generateKeyPair() {
    KeyPairGenerator generator = null;
    KeyPair keyPair = null;
    try {
      generator = KeyPairGenerator.getInstance(ALGORITHM);
      SecureRandom random = new SecureRandom();
      // 设置密钥长度，64的整数倍，512 - 65536
      generator.initialize(512, random);
      keyPair = generator.generateKeyPair();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return keyPair;
  }

  private static PrivateKey getRSAPrivateKey(RSAPrivateKey privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
    byte[] keyBytes = privateKey.getEncoded();
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
    return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
  }

  private static PublicKey getRSAPublicKey(RSAPublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
    byte[] keyBytes = publicKey.getEncoded();
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes); // 某种规范
    return keyFactory.generatePublic(x509EncodedKeySpec);
  }

  private static byte[] encryption(Key rsaKey, String source) throws Exception {
    cipher.init(Cipher.ENCRYPT_MODE, rsaKey);
    byte[] result = cipher.doFinal(source.getBytes());
    System.out.println("加密后: " + Base64.encodeBase64String(result));
    return result;
  }


  private static byte[] decryption(Key rsaKey, byte[] encryptionBytes) throws Exception {
    cipher.init(Cipher.DECRYPT_MODE, rsaKey);
    byte[] target = cipher.doFinal(encryptionBytes);
    String decrptStr = new String(target);
    System.out.println("解密后: " + decrptStr);
    return target;
  }

  public static void rsa() throws Exception {

    //初始化密钥
    KeyPair keyPair = generateKeyPair();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    // 密钥初始化完成，输出密钥
    System.out.println("Public key: " + Base64.encodeBase64String(publicKey.getEncoded()));
    System.out.println("Private key: " + Base64.encodeBase64String(privateKey.getEncoded()));

    // 私钥加密，公钥解密
    // 1. 私钥加密
    PrivateKey rsaPrivateKey = getRSAPrivateKey(privateKey);
    byte[] encryptionBytes = encryption(rsaPrivateKey, source);
    // 2. 公钥解密
    PublicKey rsaPublicKey = getRSAPublicKey(publicKey);
    byte[] decryption = decryption(rsaPublicKey, encryptionBytes);

    // 公钥加密，私钥解密
    // 1. 公钥加密
    byte[] encryptionBytes2 = encryption(rsaPublicKey, source);
    // 2. 私钥解密
    byte[] decryption2 = decryption(rsaPrivateKey, encryptionBytes2);

  }

  public static void main(String[] arg) throws Exception {

    RSA.rsa();

  }
}
