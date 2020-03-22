package com.pcitc.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestAnnotation {
	
	@Test
	public void test() throws Exception{
		
		Class<TestAnnotation> clazz = TestAnnotation.class;
		Method method = clazz.getMethod("show");
		
		MyAnnotation[] mas = method.getAnnotationsByType(MyAnnotation.class);
		for (MyAnnotation myAnnotation : mas) {
			System.out.println(myAnnotation.value());
		}
		
	}
	
	@MyAnnotation("hello")
	@MyAnnotation("world")
	public void show() {
		
	}
}
