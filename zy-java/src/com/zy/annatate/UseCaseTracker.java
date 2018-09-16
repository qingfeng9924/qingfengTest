package com.zy.annatate;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UseCaseTracker {
	public static void tracker(List<Integer> ids, Class<?> clazz) {
		int size = ids.size();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			Usecase uc = method.getDeclaredAnnotation(Usecase.class);
			if(ids.contains(uc.id())) {
				System.out.println("catch: " +uc.id() + uc.description());
			}
		}
	}
	
	public static void main(String[] args) {
		List ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		tracker(ids, AnatateTest.class);
	}
}
