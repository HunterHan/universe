package com.laiwu.source.code.reflect;

import java.lang.reflect.Method;

public class InvokeReflect {
  public int sum(int a, int b) {
    return a + b;
  }

  public String returnString(String string) {
    return "hello " + string;
  }

  public static void main(String[] args) throws Exception {
    Class<?> classType = InvokeReflect.class;
    Object invokeTest = classType.newInstance();
    
    Method addMethod = classType.getMethod("sum", new Class[] { int.class, int.class });
    Object result = addMethod.invoke(invokeTest, new Object[] { 123, 2 });
    System.out.println(result);

    Method returnStringMethod = classType.getMethod("returnString", new Class[] { String.class });
    Object object = returnStringMethod.invoke(invokeTest, new Object[] { "hanhongtao" });
    System.out.println((String) object);

  }
}
