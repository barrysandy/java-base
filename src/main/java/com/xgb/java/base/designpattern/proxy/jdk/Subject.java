package com.xgb.java.base.designpattern.proxy.jdk;

/**
 * ��Ҫ��̬����Ľӿ�
 * 1����Ҫ��̬����Ľӿڣ�
 */
public interface Subject {
	
	/**
	 * ���
	 * @param name
	 * @return
	 */
	public String sayHello(String name);
	
	/**
	 * �ټ�
	 * @return
	 */
	public String sayGoodBye();
	
}
