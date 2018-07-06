package com.xgb.java.base.designpattern.proxy.jdk;

/**
 * 需要动态代理的接口
 * 1、需要动态代理的接口：
 */
public interface Subject {
	
	/**
	 * 你好
	 * @param name
	 * @return
	 */
	public String sayHello(String name);
	
	/**
	 * 再见
	 * @return
	 */
	public String sayGoodBye();
	
}
