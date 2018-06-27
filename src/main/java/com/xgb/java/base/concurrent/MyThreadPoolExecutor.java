package com.xgb.java.base.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 2000, TimeUnit.MILLISECONDS, 
				new ArrayBlockingQueue<Runnable>(10)); 
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 2000, TimeUnit.MILLISECONDS
				, new ArrayBlockingQueue<Runnable>(5));
		
		//Executors.newCachedThreadPool() ����һ������أ������������СΪInteger.MAX_VALUE
		ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		//Executors.newSingleThreadExecutor(); ����һ������Ϊ1�Ļ����
		ExecutorService executor3 = Executors.newSingleThreadExecutor();
		
		//Executors.newFixedThreadPool(int); �����̶���С�Ļ����
		ThreadPoolExecutor executor4 = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
		
		ThreadPoolExecutor executor5 = (ThreadPoolExecutor) Executors.newScheduledThreadPool(10);
		
		for(int i=0; i<15;i++) {
			MyTask myTask = new MyTask(i);
			executor5.execute(myTask);
			System.out.println("�̳߳��е��߳���Ŀ��" + executor5.getPoolSize() + "�������еȴ�ִ�е�������Ŀ��" + 
					executor5.getQueue().size() + "���Ѿ�ִ����ϵ�����������" + executor5.getCompletedTaskCount());
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
			executor5.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}


class MyTask implements Runnable{
	private int taskNum; 

	public MyTask(int taskNum) {
		this.taskNum = taskNum;
	}


	@Override
	public void run() {
		System.out.println("����ִ��task " + taskNum);
		try {
			//������TimeUnit.sleep() ���� Thread.sleep();
			TimeUnit.MILLISECONDS.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "ִ�����");
	}
	
}