package com.xgb.java.base.designpattern.proxy.jdk;

/**
 * 实际对象
 * 2、需要代理的实际对象
 */
public class RealSubject implements Subject {

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

	@Override
	public String sayGoodBye() {
		return " good bye ";
	}

}
