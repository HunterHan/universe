package com.laiwu.source.code.java.virtual.machine.t2;

public class PretenureSizeThreshold {
	
	private static final int _1MB = 1024 * 1024;
	
	public static void process(){
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}
}
