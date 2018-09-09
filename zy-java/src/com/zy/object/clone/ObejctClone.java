package com.zy.object.clone;

public class ObejctClone {
	public static void main(String[] args) {
		Student student1 = new Student("Tom", 22);
		System.out.println(student1);
		Student student2 = student1.getCloneStu();
		System.out.println(student2);
		
	}
}

class Student implements Cloneable{
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Student stu = null;
		try {
			stu = (Student) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stu;
	}
	
	public Student getCloneStu() {
		try {
			return (Student) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}