package com.xgb.java.base.designpattern.single;

public class SingleB {

	//¶öººÄ£Ê½
	private static SingleB instance = new SingleB();
	
	private SingleB() { }
	
	public static SingleB getInstance() {
		return instance;
	}
	
}
