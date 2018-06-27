package com.xgb.java.base.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPrint {

	public static void main(String[] args) {
		
		Collections.synchronizedList(new ArrayList<String>());
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		for (int i = 1; i <= 3; i++) {
//			System.out.println("index£º" + i);
//			Print print = new Print(i);
//			executorService.execute(print);
//		}
//		executorService.shutdown();
		
//		for (int i = 0; i < 3; i++) {
//			Print print = new Print(i);
//			new Thread(print).start();
//		}
		
		    final String str = "abc";
			executorService.execute(new Runnable() {
			@Override
			public void run() {
			System.out.println("1"+str);
			}
			});executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("2"+str);
			}
			});executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("3"+str);
			}
			}); 
			executorService.shutdown();
	}
}

class Print implements Runnable{
	final String str = "abc";
	private int num;
	
	public Print(int num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		System.out.print("Ë³Ðò£º" + num + " Öµ£º" +  str + "\n");
	}
	
}