package com.dubbo.demo.callback.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderServer {

  public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        new String[]{"callback/dubbo-demo-provider.xml"});
    context.start();

    System.out.println("Started...");

    // press any key to exit
    System.in.read();
  }

}
