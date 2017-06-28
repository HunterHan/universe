package com.laiwu.source.code.java.lang;

public class MyThreadDeadLock implements Runnable {
	/**
	 * 当两个线程以相反的顺序持有两把锁时，就有可能产生死锁现象
	 */
	public int flag;
	public static Object o1 = new Object();
	public static Object o2 = new Object();

	public static void main(String[] args) {
		MyThreadDeadLock td1 = new MyThreadDeadLock();
		MyThreadDeadLock td2 = new MyThreadDeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		System.out.println("flag:" + flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");
				}
			}

		} else if (flag == 0) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}

		}

	}
}
