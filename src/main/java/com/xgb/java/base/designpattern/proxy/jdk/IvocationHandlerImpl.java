package com.xgb.java.base.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * ���ô�����ʵ����
 * ÿ�����ɶ�̬���������ʱ����Ҫָ��һ��ʵ���˸ýӿڵĵ��ô���������
 *
 */
public class IvocationHandlerImpl implements InvocationHandler {
	
	/**
	 * �����������Ҫ��ʵ����Ķ���
	 */
	private Object subject;
	
	/**
	 * ���췽����������Ҫ�������ʵ�����ʼ��ֵ
	 * @param subject
	 */
	public IvocationHandlerImpl(Object subject) {
		this.subject = subject;
	}

	/**
	 * �÷��������д���̬�������ϵ����з�������
	 * ���ô�����������������������Ԥ�������ɵ�ί��ʵ���Ϸ���ִ��
	 * 
	 * @param proxy ������ʵ��
	 * @param method �����õķ�������
	 * @param args ���ò���
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//�ڴ�����ʵ����ǰ���ǿ������һЩ�Լ��Ĳ���
		System.out.println("����֮ǰ......");
		System.out.println("method: " + method);
		
		//��������������ʵ����ķ���ʱ������Զ�����ת��������������handler�����invoke���������е���
		Object returnValue = method.invoke(subject, args);
		System.out.println("returnValue: " + returnValue);
		//�ڴ�����ʵ���������Ҳ�������һЩ�Լ��Ĳ���
		System.out.println("�ڵ���֮��.....");
		return returnValue;
	}

}
