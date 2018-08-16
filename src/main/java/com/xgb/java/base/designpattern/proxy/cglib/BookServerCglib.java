package com.xgb.java.base.designpattern.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class BookServerCglib implements MethodInterceptor {

	private Object target;
	
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());;
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("Method call Begin!!!");
		proxy.invokeSuper(object, args);
		System.out.println("Method call After!!!");
		return null;
	}

}
