package com.pcitc.test3;
/**
 * JAVA8四大核心内置函数式接口：
 * 	
 * 1、Consumer<T> 消费型接口
 * 		void accept(T t);
 * 2、Spplier<T> 供给型接口
 * 		T get()
 * 3、Function<T,R> 函数型接口
 * 		R apply(T t)
 * 4、Predication<T,R> 断言型接口
 * 		boolean test(T t)
 * 
 * @ClassName: LambdaTest3 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月12日 下午2:08:01
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class LambdaTest3 {
	
	//4、断言型接口
	@Test
	public void test4() {
		List<String> asList = Arrays.asList("avxd","da","dewsas","12a","9jsnsk");
		List<String> filterStr = filterStr(asList, x -> x.length() > 3);
		for (String string : filterStr) {
			System.out.println(string);
		}
	}
	
	public List<String> filterStr(List<String> lists, Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		for (String string : lists) {
			if (pre.test(string)) {
				strList.add(string);
			}
		}
		return strList;
	}
	
	//3、函数型接口
	@Test
	public void test3() {
		String strHandler = strHandler("chenwenjun", (x) -> x.toUpperCase());
		System.out.println(strHandler);
	}
	
	public String strHandler(String str,Function<String, String> fc) {
		return fc.apply(str);
	}
	
	//2、供给型接口
	@Test
	public void test2() {
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer i : numList) {
			System.out.println(i);
		}
	}
	
	public List<Integer> getNumList(int num , Supplier<Integer> sp){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			Integer n = sp.get();
			list.add(n);
		}
		return list;
	}
	
	//1、消费型接口Consumer
	@Test
	public void test1() {
		happy(1000D, (m) -> System.out.println("保健消费" + m));
	}
	
	public void happy(Double money, Consumer<Double> con) {
		con.accept(money);
	}
}
