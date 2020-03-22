package com.pcitc.test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.pcitc.test1.Employee;

/**
 * Stream 中间操作
 * 
 * @ClassName: TestStreamAPI2 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月12日 下午10:01:19
 */
public class TestStreamAPI2 {
	
	List<Employee> emps = Arrays.asList(
			new Employee("李四", 20, 6699.66),
			new Employee("王五", 21, 5555.55),
			new Employee("赵六", 29, 4444.59),
			new Employee("田七", 27, 6666.79),
			new Employee("张三", 20, 9999.99),
			new Employee("李四", 21, 9999.99)
	);
	
	@Test
	public void test1() {
		
		Stream<Employee> stream = emps.stream().filter(e -> {
			System.out.println("TestStreamAPI2.test1()");
			return e.getAge() > 22;
		});
		stream.forEach(System.out::println);//”惰性求值“,只有调用时，才会遍历
	}
	
	
	@Test
	public void test2() {
		emps.stream().filter(e -> {
			System.out.println("断言");
			return e.getSalary() > 5555;
		}).limit(2).forEach(System.out::println);;
	}
	
	@Test
	public void test3() {
		emps.stream().filter(e -> e.getSalary() > 5555)
					 .skip(2)//跳过前两个，取后面的值，若流中不足n个，返回空流，与limit互补
					 .distinct()//筛选，通过流所产生的元素的hashcode和equals去重重复元素
					 .forEach(System.out::println);
	}
	
	
	//Map
	@Test
	public void test4() {
		emps.stream().map(Employee::getName).forEach(System.out::println);
		System.out.println("-------------------------------");
		List<String> lists = Arrays.asList("aa", "bb", "cc");
		lists.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	
	//FlatMap
	@Test
	public void test5() {
		
		List<String> lists = Arrays.asList("aa", "bb", "cc");
		Stream<Stream<Character>> stream = lists.stream().map(TestStreamAPI2::filterCharater);
		stream.forEach(sm ->{
			sm.forEach(System.out::println);
		});
		System.out.println("-----------------------------");
		//将子流整合为一个整流
		Stream<Character> flatMap = lists.stream().flatMap(TestStreamAPI2::filterCharater);
		flatMap.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharater(String str){
		List<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}
	
	//排序：
	//sorted() 自然排序
	//sorted(Comaparator com)定制排序
	@Test
	public void test6() {
		List<String> lists = Arrays.asList("dd", "aa", "bb", "cc");
		lists.stream().sorted().forEach(System.out::println);
		System.out.println("------------------------------");
		
		emps.stream().sorted((e1,e2) ->{
			if (e1.getAge().equals(e2.getAge())) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		}).forEach(System.out::println);
	}
	
}
