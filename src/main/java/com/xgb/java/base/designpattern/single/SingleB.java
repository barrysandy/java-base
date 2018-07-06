package com.xgb.java.base.designpattern.single;

public class SingleB {

	//����ģʽ
	private static SingleB instance = new SingleB();
	
	private SingleB() { }
	
	public static SingleB getInstance() {
		return instance;
	}
	
}
