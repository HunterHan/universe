package com.laiwu.algorithm.encryption.rsa;

public class RsaKeyPair {

  private String publicKey = "";
  private String privateKey = "";

  public RsaKeyPair(String publicKey, String privateKey) {
    super();
    this.publicKey = publicKey;
    this.privateKey = privateKey;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  @Override
  public String toString() {
    return "RsaKeyPair{" +
            "publicKey='" + publicKey + '\'' +
            ", privateKey='" + privateKey + '\'' +
            '}';
  }
}
