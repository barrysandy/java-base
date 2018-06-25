package com.xgb.java.base.interfaceTest;

public class Test{
    
    private int count = 0;
    
    public void testAdd(){
        count ++;
        testAdd();
    }
    public void test(){
        try{
        testAdd();
         }catch(Throwable e){
             System.out.println(e);
             System.out.println("’ª…Ó∂»:"+count);
         }
    }
    public static void main(String [] args){
        new Test().test();
    }    
}