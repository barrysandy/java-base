package com.xgb.java.base.designpattern.proxy.jdk;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		IvocationHandlerImpl handler = new IvocationHandlerImpl(new RealSubject());
		Subject subject = (Subject)Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
		subject.sayHello("jack");
		subject.sayGoodBye();
	}
}
