package com.pcitc.test2;

import java.rmi.server.Operation;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 1 Lambda表达式的基础语法：java8引入了一个新的语法“->”，左侧是Lambda参数，右侧是Lambda体
 * 2 接口中只有一个抽象方法的就是函数式接口 @FunctionalInterface
 * 
 * @ClassName: LambdaTest1 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月12日 上午11:21:37
 */
public class LambdaTest1 {
	
	@Test
	public void test1() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World1");
			}
		};
		System.out.println("-----------------------------");
		
		//语法一：无参数
		Runnable r2 = () -> System.out.println("Hello World2");
		
		r1.run();
		r2.run();
		
	}
	
	//语法二：一个参数，括号可以省略
	@Test
	public void test2() {
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("文君");
	}
	
	//语法三：有两个或以上的参数,Lambda体中有多条语句，必须使用{}
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) ->{
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
	}
	
	public void test4() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
	}
	
	public void test5() {
		showMap(new HashMap<>());//不需要指明数据类型，通过上下午判断类型
	}
	
	public void showMap(Map<String, Object> map) {
	}
	
	@Test
	public void test6() {
		Integer operation = operation(10, (x) -> x * x);
		System.out.println(operation);
	}
	
	
	public Integer operation(Integer x, Myfunc mf){
		return mf.getValue(x);
	}
}
