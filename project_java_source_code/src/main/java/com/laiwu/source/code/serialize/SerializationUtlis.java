package com.laiwu.source.code.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtlis {
  private static String FILE_NAME = "d:/Serialization.class";

  public static void write(Serializable a) {
    try {
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
      outputStream.writeObject(a);
      outputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Object read() {
    Object object = null;
    ObjectInputStream inputStream;
    try {
      inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
      object = inputStream.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return object;

  }
}
