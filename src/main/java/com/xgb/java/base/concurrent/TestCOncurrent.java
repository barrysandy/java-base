package com.xgb.java.base.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCOncurrent {
	//volatile 关键字 (能使变量具有可见性和有序性)
	private static volatile int num = 1000;//内存屏障和内存可见性
	
	//同步代价太大
/*	private static synchronized void add() {
		num ++;
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger atomicIntegr = new AtomicInteger(num);
		for (int i = 0; i < 1000; i++) {
			new Thread() {
				public void run() {
//					add();
//					atomicIntegr.getAndIncrement();
					atomicIntegr.decrementAndGet();
				};
			}.start();
		}
		
		Thread.sleep(1000);
		System.out.println("num: " + atomicIntegr.get());
		
	}

}
