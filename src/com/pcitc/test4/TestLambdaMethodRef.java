package com.pcitc.test4;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.pcitc.test1.Employee;

/**
 * 一：方法引用：若Lambda体中的内容有方法已经实现了，我没就可以使用“方法引用”，方法引用就是Lambda表达式的一种表现形式
 * 
 * 主要有三种语法格式：
 * 1、对象::实例方法名
 * 2、类::静态方法名
 * 3、类::实例方法名
 * 
 * 二：构造器引用
 * 		ClassName::new
 * 
 * 三：数组引用：
 * 		type[]::new
 * @ClassName: TestLambda4 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月12日 下午4:25:06
 */
public class TestLambdaMethodRef {
	
	//数组引用：
	@Test
	public void test6() {
		
		Function<Integer, String[]> func = x -> new String[x];
		String[] strs = func.apply(10);
		System.out.println(strs.length);
		
		Function<Integer, String[]> func2 = String[]::new;
		String[] strs2 = func2.apply(12);
		System.out.println(strs2.length);
		
	}
	
	//构造器引用
	@Test
	public void test5() {
		Supplier<Employee> sup = () -> new Employee();
		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
		
		
		Function<String, Employee> func = (x) -> new Employee(x);
		Employee emp = func.apply("zhangsan");
		System.out.println(emp);
		
		Function<String, Employee> func2 = Employee::new;
		Employee emp2 = func2.apply("wenjun");
		System.out.println(emp2);
		
	}
	
	
	//类::实例方法名
	@Test
	public  void test4() {
		BiPredicate<String, String> bp = (x,y) -> x.equals(y);
		
		BiPredicate<String, String> bp2 = String::equals;
	}
	
	
	//类::静态方法名
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		
		Comparator<Integer> com2 = Integer::compare;
	}
	
	
	//对象::实例方法名
	@Test
	public void test1() {
		Consumer<String> con = System.out::println;
		con.accept("wenjun");
	}
	
	@Test
	public void test2() {
		Employee employee = new Employee("chenwenjun", 29, 10000D);
		Supplier<String> sup = () -> employee.getName();
		System.out.println(sup.get());
		
		Supplier<Integer> sup2 = employee::getAge;
		System.out.println(sup2.get());
	}
	
}
