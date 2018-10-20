package com.dubbo.demo.base.provider;

public class DemoServerImpl implements DemoServer {
  @Override
  public Integer sum(Integer numA, Integer numB) {

    System.out.println("numA = " + numA + ", numB = " + numB);

    return numA + numB;
  }
}
