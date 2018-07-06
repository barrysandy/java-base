package com.xgb.java.base.designpattern.observe;
public class Test {
    
    public static void main(String[] args) {
    	WeChatServer server = new WeChatServer();
        
        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");
        
        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP������������õ����ԣ�");
        
        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA������������õ����ԣ�");
        
    }
}