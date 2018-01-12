package com.laiwu.algorithm.entryption.dh;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

public class DH {


  private static String ALGORITHM = "DH";

  private static final String source = "it is a secret.";

  public static void main(String[] args) throws Exception {

    // 1. 初始化发送方密钥
    KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
    generator.initialize(512);
    KeyPair senderKeyPair = generator.genKeyPair();

    byte[] sendPublicKeyEnc = senderKeyPair.getPublic().getEncoded();// 发送方公钥，发送给接收方

    // 2. 初始化接收方密钥
    KeyFactory receiverFactory = KeyFactory.getInstance(ALGORITHM);
    X509EncodedKeySpec spec = new X509EncodedKeySpec(sendPublicKeyEnc);
    PublicKey receiverPublicKey = receiverFactory.generatePublic(spec);

    DHParameterSpec dhParameterSpec = ((DHPublicKey) receiverPublicKey).getParams();
    KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
    receiverKeyPairGenerator.initialize(dhParameterSpec);
    KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
    PrivateKey receiverPrivatKey = receiverKeyPair.getPrivate();
    byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();

    // 3. 密钥构建
    KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance(ALGORITHM);
    receiverKeyAgreement.init(receiverPrivatKey);
    receiverKeyAgreement.doPhase(receiverPublicKey, true);
    SecretKey receiverDESKey = receiverKeyAgreement.generateSecret("DES");


    KeyFactory senderKeyFactory = KeyFactory.getInstance(ALGORITHM);
    spec = new X509EncodedKeySpec(receiverPublicKeyEnc);
    PublicKey senderPublicKey = senderKeyFactory.generatePublic(spec);
    KeyAgreement senderKeyAgreement = KeyAgreement.getInstance(ALGORITHM);
    senderKeyAgreement.init(senderKeyPair.getPrivate());
    senderKeyAgreement.doPhase(senderPublicKey, true);

    // 4. 发送方的本地密钥
    SecretKey senderDESKey = senderKeyAgreement.generateSecret("DES");

    if (Objects.equals(receiverDESKey, senderDESKey)) {
      System.out.println("双方密钥相同，密钥构建完成");
    }

    // 4. 加密发送

    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(Cipher.ENCRYPT_MODE, senderDESKey);
    byte[] bytes = cipher.doFinal(source.getBytes());
    System.out.println("JDK DH 加密: " + Base64.encodeBase64String(bytes));


    // 5. 解密接收
    cipher.init(Cipher.DECRYPT_MODE, receiverDESKey);
    byte[] target = cipher.doFinal(bytes);
    System.out.println("JDK DH 解密: " + new String(target));


  }


}
