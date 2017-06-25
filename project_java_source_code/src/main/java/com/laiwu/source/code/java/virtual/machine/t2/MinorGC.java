package com.laiwu.source.code.java.virtual.machine.t2;

public class MinorGC {
	private static final int _1MB = 1024 * 1024;
	
	public static void process() {
		byte[] allocation1;
		byte[] allocation2;
		byte[] allocation3;
		byte[] allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}
}
