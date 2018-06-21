package com.xgb.java.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BookFacadeProxy implements InvocationHandler{
	private Object target;
	
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
				
//	    //取得代理对象  
//	    return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
//	            target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  		
	}

	@Override
	/**
	 * proxy 代理类的实例
	 * method 调用的方法
	 * args 调用方法的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("事物开始");  
		result = method.invoke(target, args);
		System.out.println("事物结束");  
		return result;
	}
	
	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacade book = (BookFacade) proxy.bind(new BookFacadeImpl());
		book.addBook();
	}


}
