package com.zy.equls;

public class EquilsTest {
	public static void main(String[] args) {
		Test test1 = new Test("Tom",22);
		Test test3 = new Test("Tom",22);
		Test test2 = test1;
		//System.out.println(test1.equals(test3));
		//System.out.println(test1 == test3);
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1.equals(s2));
	}
}

class Test{
	private String name;
	private int age;
	
	public Test(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
}
