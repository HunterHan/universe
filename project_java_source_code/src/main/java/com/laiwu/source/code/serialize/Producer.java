package com.laiwu.source.code.serialize;

public class Producer {
	public static void main(String[] args) {
		Person person = new Person("beijing", 25);
		SerializationUtlis.write(person);
		System.out.println("对象序列化成功！");
	}
}
