package com.pcitc.test6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.pcitc.test1.Employee;
import com.pcitc.test1.Employee.Status;

/**
 * 终止操作：
 * 1、查找与匹配
 * 2、归约
 * 3、收集
 * 
 * @ClassName: TestStream5 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月13日 上午11:18:05
 */
public class TestStream5 {
	
	List<Employee> emps = Arrays.asList(
			new Employee("李四", 20, 6699.66,Status.FREE),
			new Employee("王五", 21, 5555.55,Status.BUSY),
			new Employee("赵六", 29, 4444.59,Status.VOCATION),
			new Employee("田七", 27, 6666.79,Status.WORK),
			new Employee("张三", 30, 9999.99,Status.WORK),
			new Employee("李四", 21, 9999.99,Status.FREE)
	);
	
	//allMatch
	@Test
	public void test1() {
		boolean allMatch = emps.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println("allMatch=" + allMatch);
		
		boolean anyMatch = emps.stream().anyMatch(e -> e.getStatus().equals(Status.FREE));
		System.out.println("anyMatch=" + anyMatch);
		
		boolean noneMatch = emps.stream().noneMatch(e->e.getStatus().equals(Status.WORK));
		System.out.println("noneMatch=" + noneMatch);
		
		
		Optional<Employee> findFirst = emps.stream()
											.sorted((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
											.findFirst();
		System.out.println(findFirst.get());
		
		Optional<Employee> findAny = emps.stream().filter(e-> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(findAny.get());
		
	}
	
	@Test
	public void test2() {
		long count = emps.stream().count();
		System.out.println(count);
		
		Optional<Employee> max = emps.stream().max((e1,e2) -> Double.compare(e1.getAge(), e2.getAge()));
		System.out.println(max.get());
		
		Optional<Employee> min = emps.stream().min((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(min.get());
		
	}
	
	//归约
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer reduce = list.stream().reduce(0, (x,y) -> x+y);
		System.out.println(reduce);
		
		Optional<Double> reduce2 = emps.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(reduce2.get());
		
	}
	//收集
	@Test
	public void test4() {
		List<String> collect = emps.stream().map(Employee::getName).collect(Collectors.toList());
		collect.forEach(System.out::println);
		System.out.println("----------------------------------------");
		Set<String> collect2 = emps.stream().map(Employee::getName).collect(Collectors.toSet());
		collect2.forEach(System.out::println);
		System.out.println("----------------------------------------");
		HashSet<String> collect3 = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		collect3.forEach(System.out::println);
	}
	
	
	@Test
	public void test5() {
		//总数
		Long collect = emps.stream().collect(Collectors.counting());
		System.out.println(collect);
		//平均值
		Double collect2 = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(collect2);
		//求和
		Double collect3 = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.err.println(collect3);
		
		//最大值
		Optional<Employee> collect4 = emps.stream().collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getAge(), e2.getAge())));
		System.out.println(collect4.get());
		//最小值
		Optional<Employee> collect5 = emps.stream().collect(Collectors.minBy((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(collect5.get());
		
		Optional<Double> collect6 = emps.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compareTo));
		System.out.println(collect6.get());
		
	}
	
	@Test
	public void test6() {
		Map<Status, List<Employee>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(collect);
	}
	
}
