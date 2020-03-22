package com.pcitc.test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
/**
 * Stream API是数据渠道， 用于操作数据源（集合，数组等）所生成的元素的序列，“集合将的是数据，流讲的是计算”
 * 注意：
 * 1、stream 自己不会存储元素
 * 2、Stream 不会改变源对象，相反，它会返回一个持有结果的新Stream。
 * 3、Stream 操作是延迟执行的。这意味着，他们会等到需要结果的时候才会执行
 * 
 * Stream 操作的三个步骤:
 * 1、创建Stream
 * 
 * 2、中间操作
 * 
 * 3、终止操作
 * 
 * @ClassName: TestStreamAPI 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月12日 下午9:35:28
 */
public class TestStreamAPI {
	
	
	//创建Stream
	@Test
	public void test1() {
		
		//1、通过Collection
		List<Integer> lists = new ArrayList<Integer>();
		Stream<Integer> stream = lists.stream();
		
		//2、通过Arrays中的静态方法
		Stream<String> stream2 = Arrays.stream(new String[10]);
		
		//3、通过Stream类中的静态方法of()
		Stream<String> stream3 = Stream.of(new String("wenj"));
		
		
		//4、创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
		stream4.limit(5).forEach(System.out::println);//终止操作
		
		
		Stream<Double> stream5 = Stream.generate(() -> Math.random());
		stream5.limit(5).forEach(System.out::println);
	}
}
