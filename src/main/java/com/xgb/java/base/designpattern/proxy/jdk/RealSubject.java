package com.xgb.java.base.designpattern.proxy.jdk;

/**
 * ʵ�ʶ���
 * 2����Ҫ�����ʵ�ʶ���
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
