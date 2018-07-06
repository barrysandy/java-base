package com.xgb.java.base.designpattern.proxy.jdk.dyn;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		ProxyImpl handler = new ProxyImpl(new BooksImpl());
		Books booksProxy = (Books)Proxy.newProxyInstance(BooksImpl.class.getClassLoader(), BooksImpl.class.getInterfaces(), handler);
		
		booksProxy.addBooks("JAVA");
		booksProxy.addBooks("PHP");
		booksProxy.addBooks("Redis");
		booksProxy.addBooks("Zookeeper");
		booksProxy.addBooks("Dubbo");
		
	}

}
