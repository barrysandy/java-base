package com.xgb.java.base.designpattern.proxy.jdk.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyImpl implements InvocationHandler {
	
	private Object object;
	
	public ProxyImpl(Object object) {
		this.object = object ;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print("书籍准备入库....");
		for (int i = 0; i < args.length; i++) {
			System.out.print(" 书名: " + args[i]);
		}
		
		
		Object returnValue = method.invoke(object, args);
		System.out.println("书籍入库成功....." + returnValue );
		System.out.println("\n");
		return returnValue;
	}

}
