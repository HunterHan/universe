package com.laiwu.source.code.java.lang.thread;

import java.util.concurrent.TimeUnit;


/**
 * 如果ThreadLocal存储的是不变性（immutable）的对象，如String，对于主线程设置的值子线程可以通过get函数获取，但子线程调用set函数设置新值后，对主线程没有影响，对其它子线程也没有影响，只对自己可见，（请参考代码例子中的stringItl变量）；
 * 如果主线程还没有获取(get)或者设置(set)过ThreadLocal变量，而子线程先获取(get)或者设置(set)了ThreadLocal变量，那么这个份值只属于那个子线程，对主线程和其它子线程都不可见，（请参考代码例子中的stringIt2变量）.
 * <p>
 * <p>
 * <p>
 * 如果ThreadLocal存储的是可变性（mutable）的对象，如StringBuffer，对于主线程设置的值子线程可以通过get函数获取，但子线程调用set函数设置新值后，对主线程没有影响，对其它子线程也没有影响，只对自己可见，但如果子线程先get获取再修改对象的属性，那么这个修改对主线程和其它子线程是可见的，即他们还是共享一个引用（请参考代码例子中的stringBufferItl变量）；
 * 如果主线程还没有获取(get)或者设置(set)过ThreadLocal变量，而子线程先获取(get)或者设置(set)了ThreadLocal变量，那么这份值只属于那个子线程，对主线程和其它子线程都不可见，（请参考代码例子中的stringBufferItl2变量）.
 * <p>
 * <p>
 * <p>
 * 所以子线程只能通过修改可变性（Mutable）对象对主线程才是可见的，即才能将修改传递给主线程，但这不是一种好的实践，不建议使用，为了保护线程的安全性，一般建议只传递不可变（Immuable）对象，即没有状态的对象。
 */

public class ThreadLocalTest {

  private static ThreadLocal<String> stringItl = new InheritableThreadLocal<String>() {
    protected String initialValue() {
      System.out.println(Thread.currentThread().getName() + " initialize stringItl variable.");
      return "String init";
    }
  };

  private static ThreadLocal<String> stringItl2 = new InheritableThreadLocal<String>() {
    protected String initialValue() {
      System.out.println(Thread.currentThread().getName() + " initialize stringItl2 variable.");
      return "String2 init";
    }
  };

  private static ThreadLocal<StringBuffer> stringBufferItl = new InheritableThreadLocal<StringBuffer>() {
    protected StringBuffer initialValue() {
      System.out.println(Thread.currentThread().getName() + " initialize stringBufferItl variable.");
      return new StringBuffer("StringBuffer init");
    }
  };

  private static ThreadLocal<StringBuffer> stringBufferItl2 = new InheritableThreadLocal<StringBuffer>() {
    protected StringBuffer initialValue() {
      System.out.println(Thread.currentThread().getName() + " initialize stringBufferItl2 variable.");
      return new StringBuffer("StringBuffer2 init");
    }
  };

  public static void main(String[] args) throws InterruptedException {
    stringItl.set("Parent");
    stringBufferItl.set(new StringBuffer("ParentBuffer"));

    System.out.println(Thread.currentThread().getName() + " first get stringItl : " + stringItl.get());
    System.out.println(Thread.currentThread().getName() + " first get stringBufferItl : " + stringBufferItl.get().toString());

    for (int i = 0; i < 2; i++) {
      new Thread() {
        public void run() {
          System.out.println(Thread.currentThread().getName() + " first get stringItl : " + stringItl.get());
          stringItl.set(Thread.currentThread().getName() + "Child");
          System.out.println(Thread.currentThread().getName() + " get after set stringItl : " + stringItl.get());

          System.out.println(Thread.currentThread().getName() + " first get stringItl2 : " + stringItl2.get());
          stringItl2.set(Thread.currentThread().getName() + "Child");
          System.out.println(Thread.currentThread().getName() + " get after set stringItl2 : " + stringItl2.get());

          System.out.println(Thread.currentThread().getName() + " first get stringBufferItl : " + stringBufferItl.get().toString());
          stringBufferItl.get().append(Thread.currentThread().getName());
          System.out.println(Thread.currentThread().getName() + " get after set stringBufferItl : " + stringBufferItl.get().toString());

          System.out.println(Thread.currentThread().getName() + " first get stringBufferIt2 : " + stringBufferItl2.get().toString());
          stringBufferItl2.get().append(Thread.currentThread().getName());
          System.out.println(Thread.currentThread().getName() + " get after set stringBufferItl2 : " + stringBufferItl2.get().toString());
        }

      }.start();
    }

    for (int i = 0; i < 2; i++) {
      new Thread() {
        public void run() {
          System.out.println(Thread.currentThread().getName() + " first get stringItl : " + stringItl.get());
          stringItl.set(Thread.currentThread().getName() + "Child");
          System.out.println(Thread.currentThread().getName() + " get after set stringItl : " + stringItl.get());

          System.out.println(Thread.currentThread().getName() + " first get stringItl2 : " + stringItl2.get());
          stringItl2.set(Thread.currentThread().getName() + "Child");
          System.out.println(Thread.currentThread().getName() + " get after set stringItl2 : " + stringItl2.get());

          System.out.println(Thread.currentThread().getName() + " first get stringBufferItl : " + stringBufferItl.get().toString());
          stringBufferItl.set(new StringBuffer(Thread.currentThread().getName() + "Buffer"));
          System.out.println(Thread.currentThread().getName() + " get after set stringBufferItl : " + stringBufferItl.get().toString());

          System.out.println(Thread.currentThread().getName() + " first get stringBufferIt2 : " + stringBufferItl2.get().toString());
          stringBufferItl2.get().append(Thread.currentThread().getName());
          System.out.println(Thread.currentThread().getName() + " get after set stringBufferItl2 : " + stringBufferItl2.get().toString());
        }

      }.start();
    }

    TimeUnit.SECONDS.sleep(2);//let children threads run first
    System.out.println(Thread.currentThread().getName() + " second get stringItl : " + stringItl.get());
    System.out.println(Thread.currentThread().getName() + " first get stringItl2 : " + stringItl2.get());
    System.out.println(Thread.currentThread().getName() + " second get stringBufferItl : " + stringBufferItl.get().toString());
    System.out.println(Thread.currentThread().getName() + " first get stringBufferItl2 : " + stringBufferItl2.get().toString());
  }
}
