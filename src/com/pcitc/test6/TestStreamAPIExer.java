package com.pcitc.test6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestStreamAPIExer {
	
	
	@Test
	public void test1() {
		Integer[] nums = new Integer[] {1,2,3,4,5};
		Stream<Integer> map = Arrays.stream(nums).map(x -> x * x);
		List<Integer> collect = map.collect(Collectors.toList());
		System.out.println(collect);
		
	}
}
