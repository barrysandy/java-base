package com.xgb.java.base.proxy;

public class MyTest {
	
    public static void main(String[] args) {
        //��money������
        ISomeService zhangsan = new ISomeServiceImp();
        //��˿����
        ISomeService lisi = new ISomeServiceImp();
        //�������˴��˾
        ISomeService someService = new CGLibFactory(zhangsan).myCGLibCreator();
        System.out.println("zhangsan"+someService.Litigate()+"-----"+someService.eat());
        //��Ƶ������Լ����˾���Լ��Է�
        System.out.println("lisi"+lisi.Litigate()+"-----"+lisi.eat());
    }
}