package com.dubbo.demo.callback.consumer;

import com.dubbo.demo.callback.provider.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerClient {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:callback/dubbo-demo-consumer.xml");
    context.start();

    CallbackService callbackService = (CallbackService) context.getBean("callbackService");

    callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener() {

      public void changed(String msg) {
        System.out.println("callback1:" + msg);
      }

    });

    // context.close();

  }
}
