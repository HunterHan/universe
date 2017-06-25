package com.laiwu.source.code.java.virtual.machine.t2;

public class HandlePromotion {
	private static final int _1MB = 1024 * 1024;
	public static void process(){
		byte[] allocation1;
		byte[] allocation2;
		byte[] allocation3;
		byte[] allocation4;
		byte[] allocation5;
		byte[] allocation6;
		byte[] allocation7;
		
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation1 = null;
		allocation4 = new byte[2 * _1MB];
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * _1MB];
	}
}
