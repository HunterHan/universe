package com.laiwu.algorithm.producerconsumer.LinkedBlockingQueue;

/**
 * 
 * BlockingQueue阻塞队列方法
 *         BlockingQueue是JDK5.0的新增内容，它是一个已经在内部实现了同步的队列，实现方式采用的是我们第2种await() /
 *         signal()方法。它可以在生成对象时指定容量大小。它用于阻塞操作的是put()和take()方法。
 *         put()方法：类似于我们上面的生产者线程，容量达到最大时，自动阻塞。
 *         take()方法：类似于我们上面的消费者线程，容量为0时，自动阻塞。
 * 
 *         对于public void produce(int num);和public void consume(int num);
 *         方法业务逻辑上的实现跟前面两个例子不太一样，没关系，这个例子只是为了说明BlockingQueue阻塞队列的使用。
 *         有时使用BlockingQueue可能会出现put()和System.out.println()输出不匹配的情况，
 *         这是由于它们之间没有同步造成的 。当缓冲区已满，生产者在put()操作时，put()内部调用了await()方法，
 *         放弃了线程的执行，然后消费者线程执行，调用take()方法，take()内部调用了signal()方法，通知生产者线程可以执行
 *         ，致使在消费者的println()还没运行的情况下生产者的println()先被执行，所以有了输出不匹配的情况。
 *         对于BlockingQueue大家可以放心使用，这可不是它的问题，只是在它和别的对象之间的同步有问题。
 */
public class Market {
  public static void main(String[] args) {
    // 仓库对象
    Storage storage = new Storage();

    // 生产者对象
    Producer p1 = new Producer(storage);
    Producer p2 = new Producer(storage);
    Producer p3 = new Producer(storage);
    Producer p4 = new Producer(storage);
    Producer p5 = new Producer(storage);
    Producer p6 = new Producer(storage);
    Producer p7 = new Producer(storage);

    // 消费者对象
    Consumer c1 = new Consumer(storage);
    Consumer c2 = new Consumer(storage);
    Consumer c3 = new Consumer(storage);

    // 设置生产者产品生产数量
    p1.setNum(10);
    p2.setNum(10);
    p3.setNum(10);
    p4.setNum(10);
    p5.setNum(10);
    p6.setNum(10);
    p7.setNum(80);

    // 设置消费者产品消费数量
    c1.setNum(50);
    c2.setNum(20);
    c3.setNum(30);

    // 线程开始执行
    c1.start();
    c2.start();
    c3.start();
    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
    p6.start();
    p7.start();
  }
}
