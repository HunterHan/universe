package com.laiwu.source.code.java.lang;

import org.junit.Test;

/**
 * 创建线程的3种方式:
 * 
 * 1、继承Thread类
 * 
 * 2、实现Runnable接口
 * 
 * 3、实现Callable接口
 * 
 * 2/3 的优势:线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
 * 多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，
 * 从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
 * 
 * 注意:多线程下载是指带宽满足前提下同时获取资源
 * @author CogniBoy
 *
 */
public class MyThread {

  @Test
  public void getCurrentThread() {
    String threadName = Thread.currentThread().getName();
    System.out.println("线程名称:" + threadName);
  }

  @Test
  public void threadRun() {
    new Thread(new Runnable() {

      @Override
      public void run() {
        System.out.println("runnable run");
      }
    }) {
      @Override
      public void run() {
        System.out.println("thread run");
      }
    }.start();

  }
}
