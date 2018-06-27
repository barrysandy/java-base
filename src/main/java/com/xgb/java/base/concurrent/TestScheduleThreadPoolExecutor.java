package com.xgb.java.base.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 假如有一个第三方接口，有很多个线程去调用获取数据，现在规定每秒钟最多有 10 个线程同时调用它，如何做到。
 * ScheduledThreadPoolExecutor 设置定时，进行调度。
 */
public class TestScheduleThreadPoolExecutor {
	
	public static void main(String[] args) {
		//构造一个ScheduleThreadPoolExecutor对象，并设置它的容量为10
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		
		for (int i = 0; i < 20; i++) {
			Say say = new Say(i);
			//每隔1秒执行异常
			executor.schedule(say, 1, TimeUnit.SECONDS);
		}
		executor.shutdown();
		
	}
}


interface ISay{
	void say();
}
class Say implements ISay,Runnable{
	private int num;
	
	public Say(int num) {
		this.num = num;
	}

	@Override
	public void say() {
		System.out.println("---- say ------" + num);
	}

	@Override
	public void run() {
//		System.out.println("----调用开始----" + num);
		say();
//		try {
//			TimeUnit.MILLISECONDS.sleep(1000);
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("----调用结束----" + num);
	}
	
}