package com.pcitc.test6;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

import org.junit.Test;

/**
 * 并行流，串行流
 * 
 * Fork/Join框架：
 * 
 * 
 * @ClassName: TestStreamAPI7 
 * @Description: TODO 
 * @author : chen_wenjun
 * @QQ:353376358
 * @date 2020年2月13日 下午1:59:43
 */
public class TestStreamAPI7 {
	
	
	@Test
	public void test1() {
		Instant start = Instant.now();
		LongStream.range(0, 100000000000L)
				  .parallel()
				  .reduce(0,Long::sum);
		
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis());
	}
	
}
