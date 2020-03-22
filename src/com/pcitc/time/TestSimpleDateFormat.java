package com.pcitc.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSimpleDateFormat {
	
	
	public static void main(String[] args) throws Exception {
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
//				return sdf.parse("20200213");
				return DateFormatThreadLocal.convertDate("20200213");
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<Date>> result = new ArrayList<Future<Date>>();
		
		for (int i = 0; i < 10; i++) {
			Future<Date> submit = pool.submit(task);
			result.add(submit);
		}
		
		for (Future<Date> future : result) {
			System.err.println(future.get());
		}
		
		pool.shutdown();*/
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("20200213", dtf);
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<LocalDate>> result = new ArrayList<Future<LocalDate>>();
		
		for (int i = 0; i < 10; i++) {
			Future<LocalDate> submit = pool.submit(task);
			result.add(submit);
		}
		
		for (Future<LocalDate> future : result) {
			System.err.println(future.get());
		}
		
		pool.shutdown();
		
	}

}
