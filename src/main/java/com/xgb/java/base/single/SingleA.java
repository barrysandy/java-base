package com.xgb.java.base.single;

public class SingleA {

	//±¥ººÄ£Ê½
	private static SingleA instance = null;
	
	private SingleA() { }
	
	public static SingleA getInstance() {
		if(instance == null) {
			instance = new SingleA();
		}
		return instance;
	}
	
}
