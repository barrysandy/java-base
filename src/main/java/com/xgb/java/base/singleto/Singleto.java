package com.xgb.java.base.singleto;

public class Singleto {

	private static Singleto instance = null;
	
	private Singleto() {}
	
	private static Singleto getInstance() {
		instance = new Singleto();
		return instance;
	}
	
	
	private static Singleto instance2 = new Singleto();
	
	private static Singleto getInstance2() {
		if(instance2 == null) {
			instance2 = new Singleto();
		}
		return instance2;
	}
	
	
	private volatile static Singleto instance3 ;
	
	private static Singleto getInstacne3() {
		if(instance3 == null) {
			synchronized (Singleto.class) {
				if(instance3 == null) {
					instance3 = new Singleto();
				}
			}
		}
		return instance3;
	}
	
}
