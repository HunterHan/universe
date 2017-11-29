package com.laiwu.source.code.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class SequenceInputStreamDemo {

  public static void main(String[] args) throws IOException {
    FileInputStream fis1 = new FileInputStream("files\\seq1.txt");
    FileInputStream fis2 = new FileInputStream("files\\seq2.txt");
    FileInputStream fis3 = new FileInputStream("files\\seq3.txt");
    ArrayList<FileInputStream> c = new ArrayList<FileInputStream>();
    c.add(fis1);
    c.add(fis2);
    c.add(fis3);
    Enumeration<FileInputStream> e = Collections.enumeration(c);
    SequenceInputStream sis = new SequenceInputStream(e);

    //创建输出流---要把前三个文件的内容读出来并且合并到seq4.txt;
    FileOutputStream fos = new FileOutputStream("files\\seq4.txt");
    int len = 0;
    byte buf[] = new byte[10];
    while ((len = sis.read(buf)) != -1) {
      fos.write(buf, 0, len);
    }
    fos.close();
    sis.close();

  }

}
