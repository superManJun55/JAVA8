package com.pcitc.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;
/**
 * Lambda表达式是一个匿名函数，可以理解为一段可以传递的代码（即代码可以向数据一样传递）
 * @ClassName: Lambda01 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月12日 上午10:03:31
 */
public class Lambda01 {
	
	//匿名内部类
	@Test
	public void test1() {
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(01, 02);
			}
		};
		//引用
		TreeSet<Integer> ts = new TreeSet<>(com);
	}
	
	//Lambda表达式
	@Test
	public void test2() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<>(com);
	}
	
	List<Employee> emps = Arrays.asList(
			new Employee("张三", 20, 9999.99),
			new Employee("李四", 22, 6699.66),
			new Employee("王五", 21, 5555.55),
			new Employee("赵六", 29, 4444.59),
			new Employee("田七", 27, 6666.79)
	);
	
	
	//匿名内部类
	@Test
	public void test3() {
		List<Employee> filterEmployee = filterEmployee(emps, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getAge() >= 22;
			}
		});
		
		for (Employee employee : filterEmployee) {
			System.out.println(employee);
		}
	}
	
	//Lambda表达式
	@Test
	public void test4() {
		List<Employee> filterEmployee = filterEmployee(emps, (e) -> e.getSalary() >= 6666);
		filterEmployee.forEach(System.out::println);
	}
	
	//更加简介的方式
	@Test
	public void test5() {
		emps.stream().filter((e) -> e.getAge() >= 22).forEach(System.out::println);
		System.out.println("----------------------");
		emps.parallelStream().map(Employee::getName).forEach(System.out::println);
	}
	
	public List<Employee> filterEmployee(List<Employee> lists, MyPredicate<Employee> mp){
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : lists) {
			if (mp.test(employee)) emps.add(employee);
		}
		return emps;
		
	}
	
	
}
