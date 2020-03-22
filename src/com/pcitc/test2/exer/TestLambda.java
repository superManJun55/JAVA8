package com.pcitc.test2.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.pcitc.test1.Employee;

public class TestLambda {
	
	List<Employee> emps = Arrays.asList(
			new Employee("李四", 22, 6699.66),
			new Employee("张三", 22, 9999.99),
			new Employee("王五", 21, 5555.55),
			new Employee("赵六", 29, 4444.59),
			new Employee("田七", 20, 6666.79)
	);
	
	@Test
	public void test1() {
		Collections.sort(emps,(e1,e2) ->{
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		
	}
	
	
	@Test
	public void test2() {
		
		String trimStr = strHandler("\t\t\t 我是军爷  ", (s) -> s.trim());
		System.out.println(trimStr);
		String upperStr = strHandler("abcdefg", (s) -> s.toUpperCase());
		System.out.println(upperStr);
	}
	
	@Test
	public void test3() {
		Long op = op(100L, 200L, (l1,l2) -> l1 + l2);
		System.out.println("两个long相加 = " + op);
		op = op(100L,200L,(l1,l2) -> l1 * l2);
		System.out.println("两个long相乘 = " + op);
	}
	
	
	//字符串处理
	public String strHandler(String str,MyFunction mf) {
		return mf.getStr(str);
	}
	
	//两个long类型的数据处理
	public Long op(Long l1,Long l2, MyFunction2<Long, Long> mf) {
		Long value = mf.getValue(l1, l2);
		return value;
	}
}
