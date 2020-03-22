package com.pcitc.time2;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestLocalDateTime {
	
	//1、LocalDate  2、LocalTime 3、LocalDateTime
	
	@Test
	public void test1() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		LocalDateTime plusDays = now.plusDays(3);
		System.out.println(plusDays);
		
		LocalDateTime minusHours = now.minusHours(2);
		System.out.println(minusHours);
		
		System.out.println(now.getYear());
		System.out.println(now.getMonth());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getDayOfWeek());
		
	}
	
	@Test
	public void test2() {
		Instant now = Instant.now();//默认是UTF时间
		System.out.println(now);
		
		OffsetDateTime atOffset = now.atOffset(ZoneOffset.ofHours(8));//东八区时间
		System.out.println(atOffset);
		
		
		System.out.println(now.toEpochMilli());
		
		Instant ofEpochMilli = Instant.ofEpochMilli(60);
		System.out.println(ofEpochMilli);
	}
	
	//时间间隔
	@Test
	public void test3() {
		
		Instant start = Instant.now();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Instant end  = Instant.now();
		
		Duration between = Duration.between(start, end);
		System.out.println(between.toMillis());
	}
	
	@Test
	public void test4() {
		LocalDate start = LocalDate.of(2018, 12, 12);
		LocalDate end = LocalDate.now();
		Period period = Period.between(start, end);
		System.out.println(period);
	}
	
	//TemporalAdjuster,时间矫正器
	@Test
	public void test5() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime withDayOfMonth = ldt.withDayOfMonth(10);
		System.out.println(withDayOfMonth);
		
		LocalDateTime with = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(with);
	}
	
	@Test
	public void test6() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();
		String format = ldt.format(dtf);
		System.out.println(format);
		
		
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String format2 = ldt.format(ofPattern);
		System.out.println(format2);
		
	}
	
	@Test
	public void test7() {
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		availableZoneIds.forEach(System.out::println);
	}
	
}
