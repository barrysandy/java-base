package com.xgb.java.base.proxy;
public class ISomeServiceImp implements ISomeService {

    @Override
    public String Litigate() {
        return "自己打官司，输了";
    }

    @Override
    public String eat() {
        return "自己吃饭";
    }

}