package com.zy.innerclass;

import java.lang.ref.WeakReference;

public class InnserClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutClass.InnerClass innerClass = new OutClass().new InnerClass();
		WeakReference<OutClass> outer = new WeakReference<OutClass>(new OutClass());
	}
	

}

class OutClass {
	class InnerClass {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public OutClass jisuan() {
		class Sum extends OutClass{
			
		}
		return new Sum();
	}
}
