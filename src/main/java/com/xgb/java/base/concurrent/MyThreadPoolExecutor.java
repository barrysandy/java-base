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
		
		//Executors.newCachedThreadPool() 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
		ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		//Executors.newSingleThreadExecutor(); 创建一个容量为1的缓冲池
		ExecutorService executor3 = Executors.newSingleThreadExecutor();
		
		//Executors.newFixedThreadPool(int); 创建固定大小的缓冲池
		ThreadPoolExecutor executor4 = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
		
		ThreadPoolExecutor executor5 = (ThreadPoolExecutor) Executors.newScheduledThreadPool(10);
		
		for(int i=0; i<15;i++) {
			MyTask myTask = new MyTask(i);
			executor5.execute(myTask);
			System.out.println("线程池中的线程数目：" + executor5.getPoolSize() + "，队列中等待执行的任务数目：" + 
					executor5.getQueue().size() + "，已经执行完毕的任务数量：" + executor5.getCompletedTaskCount());
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
		System.out.println("正在执行task " + taskNum);
		try {
			//尽量用TimeUnit.sleep() 代替 Thread.sleep();
			TimeUnit.MILLISECONDS.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}
	
}