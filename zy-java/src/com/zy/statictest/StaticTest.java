package com.zy.statictest;

public class StaticTest {
	static int value = 3;
	public static void main(String[] args) {
		StaticTest staticTest = new StaticTest();
		staticTest.getVal();
	}
	
	public int getVal() {
		System.out.println(this.value);
		return this.value;
	}

}
