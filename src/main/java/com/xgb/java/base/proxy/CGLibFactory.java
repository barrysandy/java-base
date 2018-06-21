package com.xgb.java.base.proxy;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


/**
 *  ����������Ĺ��� ����Ҫʵ��MethodInterceptor�ӿڡ�
 *  �����������������
 * ��1������Ŀ����ĳ�Ա��������������Ŀ�������Ϊ�����Ĺ����������ڽ���Ŀ�����
 * ��2�������������ɷ��������ڴ���������󡣷�����������ġ��������Ŀ��������� 
 * ��3������ص��ӿڷ�������Ŀ�������ǿ�����������
 * 
 * @author ��ؼ��
 * 
 */
public class CGLibFactory implements MethodInterceptor {
    // ����Ŀ����ĳ�Ա����
    private ISomeService target;

    public CGLibFactory() {
    }

    // ������Ŀ�������Ϊ�����Ĺ�����,���ڽ���Ŀ�����
    public CGLibFactory(ISomeService someService) {
        this.target = someService;
    }

    // �����������ɷ���,���ڴ����������
    public ISomeService myCGLibCreator() {
        Enhancer enhancer = new Enhancer();
        // Ϊ����������ø��࣬��ָ��Ŀ����
        enhancer.setSuperclass(ISomeService.class);
        /**
         * ���ûص��ӿڶ��� ע�⣬ֻ������setCallback()�����п���д��this��
         * ����ΪMethodIntecepter�ӿڼ̳���Callback�������ӽӿ�
         */
        enhancer.setCallback(this);
        return (ISomeService) enhancer.create();// create��������CGLib�������
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
            MethodProxy proxy) throws Throwable {
        if (method.toString().contains("eat")) {// �Է��Ͳ�����ʦ�����ˣ��Լ���
            return (String) method.invoke(target, args);// ���䣬����Ŀ����ķ���;
        }
        return "��ʦ���˾��Ӯ��";
    }

}