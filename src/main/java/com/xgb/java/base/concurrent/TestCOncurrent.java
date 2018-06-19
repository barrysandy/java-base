package com.xgb.java.base.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCOncurrent {
	//volatile �ؼ��� (��ʹ�������пɼ��Ժ�������)
	private static volatile int num = 1000;//�ڴ����Ϻ��ڴ�ɼ���
	
	//ͬ������̫��
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
