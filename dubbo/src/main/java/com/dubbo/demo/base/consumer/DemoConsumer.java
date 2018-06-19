package com.dubbo.demo.base.consumer;

import com.dubbo.demo.base.provider.DemoServer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoConsumer {

  public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        new String[]{"base/dubbo-demo-consumer.xml"});
    context.start();
    // obtain proxy object for remote invocation
    DemoServer demoService = (DemoServer) context.getBean("demoService222");
    // execute remote invocation
    Integer numA = 1;
    Integer numB = 1;
    Integer result = demoService.sum(numA, numB);
    // show the result
    System.out.println(numA + " + " + numA + " = " + result);
    context.close();
  }

  @Test
  public void test(){
    String str1 = "abc";
    String str2 = "def";
    String str3 = str1 + str2;
    System.out.println(str3 == "abcdef");
  }
}
