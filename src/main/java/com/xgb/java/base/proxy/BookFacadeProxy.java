package com.xgb.java.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BookFacadeProxy implements InvocationHandler{
	private Object target;
	
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
				
//	    //ȡ�ô������  
//	    return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
//	            target.getClass().getInterfaces(), this);   //Ҫ�󶨽ӿ�(����һ��ȱ�ݣ�cglib�ֲ�����һȱ��)  		
	}

	@Override
	/**
	 * proxy �������ʵ��
	 * method ���õķ���
	 * args ���÷����Ĳ���
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("���￪ʼ");  
		result = method.invoke(target, args);
		System.out.println("�������");  
		return result;
	}
	
	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacade book = (BookFacade) proxy.bind(new BookFacadeImpl());
		book.addBook();
	}


}
