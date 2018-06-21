package com.xgb.java.base.single;

public class SingleC {

	//双重锁校验 --线程安全
	private static SingleC instance;
	
	private SingleC() { }
	
	public static synchronized SingleC getInstance() {
		if( instance == null) {
			synchronized(SingleC.class) {
				if(instance == null) {
					instance = new SingleC();
				}
			}
		}
		return instance;
	}
	
}
