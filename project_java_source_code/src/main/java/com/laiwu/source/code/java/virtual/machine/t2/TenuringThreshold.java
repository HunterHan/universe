package com.laiwu.source.code.java.virtual.machine.t2;

public class TenuringThreshold {
	private static final int _1MB = 1024 * 1024;
	
	public static void process(){
		byte[] allocation1;
		byte[] allocation2;
		byte[] allocation3;
		
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[_1MB * 4];
		allocation3 = new byte[_1MB * 4];
		allocation3 = null;
		allocation3 = new byte[_1MB * 4];
		
	}
}
