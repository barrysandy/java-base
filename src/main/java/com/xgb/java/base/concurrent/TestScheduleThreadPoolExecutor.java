package com.xgb.java.base.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * ������һ���������ӿڣ��кܶ���߳�ȥ���û�ȡ���ݣ����ڹ涨ÿ��������� 10 ���߳�ͬʱ�����������������
 * ScheduledThreadPoolExecutor ���ö�ʱ�����е��ȡ�
 */
public class TestScheduleThreadPoolExecutor {
	
	public static void main(String[] args) {
		//����һ��ScheduleThreadPoolExecutor���󣬲�������������Ϊ10
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		
		for (int i = 0; i < 20; i++) {
			Say say = new Say(i);
			//ÿ��1��ִ���쳣
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
//		System.out.println("----���ÿ�ʼ----" + num);
		say();
//		try {
//			TimeUnit.MILLISECONDS.sleep(1000);
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("----���ý���----" + num);
	}
	
}