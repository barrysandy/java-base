package com.xgb.java.base.designpattern.observe;

/**
 * �۲���
 * ʵ����update����
 * @author xgb
 *
 */
public class User implements Observer {

	private String name;
	private String message;
	public User(String name) {
		this.name = name ;
	}
	
	
	
	@Override
	public void update(String message) {
		this.message = message;
		read();
	}

	public void read() {
		System.out.println(name + " �յ�������Ϣ�� " + message);
	}
}