package com.xgb.java.base.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 调用处理器实现类
 * 每次生成动态代理类对象时都需要指定一个实现了该接口的调用处理器对象
 *
 */
public class IvocationHandlerImpl implements InvocationHandler {
	
	/**
	 * 这个是我们需要真实代理的对象
	 */
	private Object subject;
	
	/**
	 * 构造方法，给我们要代理的真实对象初始化值
	 * @param subject
	 */
	public IvocationHandlerImpl(Object subject) {
		this.subject = subject;
	}

	/**
	 * 该方法负责集中处理动态代理类上的所有方法调用
	 * 调用处理器根据这三个参数进行预处理或分派到委托实例上反射执行
	 * 
	 * @param proxy 代理类实例
	 * @param method 被调用的方法对象
	 * @param args 调用参数
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//在代理真实对象前我们可以添加一些自己的操作
		System.out.println("调用之前......");
		System.out.println("method: " + method);
		
		//当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		Object returnValue = method.invoke(subject, args);
		System.out.println("returnValue: " + returnValue);
		//在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("在调用之后.....");
		return returnValue;
	}

}
