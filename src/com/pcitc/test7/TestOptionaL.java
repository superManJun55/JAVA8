package com.pcitc.test7;

import static org.hamcrest.CoreMatchers.not;

import java.util.Optional;

import org.junit.Test;

import com.pcitc.test1.Employee;

/**
 * 
 * @ClassName: TestOptionaL 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月13日 下午4:47:54
 */
public class TestOptionaL {
	
	
	
	@Test
	public void test4() {
		Optional<Employee> op = Optional.ofNullable(new Employee("wenjun"));
		Optional<String> name = op.map((e) -> e.getName());
		System.out.println(name.get());
		System.out.println("-------------------------------");
		Optional<String> str = op.flatMap((e) -> Optional.ofNullable(e.getName()));
		System.out.println(str.get());
	
	}
	
//	orElseGet(Supplier s) 如果调用的对象包含值，则直接返回，否则创建该值，并返回
	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable(null);
		Employee emp = op.orElseGet(() -> new Employee("wenjun"));
		System.out.println(emp);
		
	}
	
	
	@Test
	public void test2() {
//		Optional<Employee> op = Optional.empty();
//		System.out.println(op.get());
		
		Optional<Employee> op2 = Optional.ofNullable(null);
		if (op2.isPresent()) {//判断是否包含值
			System.out.println(op2.get());
		}else {
			Employee emp = op2.orElse(new Employee("zhangsan1"));
			System.out.println(emp);
			
		}
	}
	
	@Test
	public void test() {
		
		Optional<Employee> op = Optional.of(new Employee("zhangsan"));
		System.out.println(op.get());
		
		Optional<Employee> op2 = Optional.of(null);
		System.out.println(op2.get());
	}
}
