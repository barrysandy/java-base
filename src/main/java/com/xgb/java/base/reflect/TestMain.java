package com.xgb.java.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> c;
		c = Class.forName("com.xgb.java.base.reflect.Persion");
		/*
         * �ṩ�й����ӿڵĵ����ֶ���Ϣ���Լ������Ķ�̬����Ȩ��
         */
        Field[] flds=c.getDeclaredFields();
        for(Field fild:flds){
            System.out.println(fild);
        }
        System.out.println("------------------------");
        Persion p = new Persion();
        c = p.getClass();
        c = Persion.class;
	}
}
