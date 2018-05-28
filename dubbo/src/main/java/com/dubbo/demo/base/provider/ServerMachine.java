package com.dubbo.demo.base.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ServerMachine {

  public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        new String[]{"base/dubbo-demo-provider.xml"});
    context.start();

    System.out.println("Started...");

    // press any key to exit
    System.in.read();
  }
}
