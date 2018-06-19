package com.xgb.java.base.single;

public class Single {

	//����ģʽ
	private static Single instance;
	
	private Single() { }
	
	public static synchronized Single getInstance() {
		StringBuffer sb = new StringBuffer();
		StringBuilder sbd = new StringBuilder();
		
		if(instance == null) {
			instance = new Single();
		}
		return instance;
	}
	
}
