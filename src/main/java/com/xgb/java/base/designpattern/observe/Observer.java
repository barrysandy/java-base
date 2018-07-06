package com.xgb.java.base.designpattern.observe;

/**
 * 抽象观察者
 * 定义一个update的方法，当被观察者调用notifyObserves()方法时，观察者的update()方法会被回调
 * @author xgb
 *
 */
public interface Observer {

	public void update(String message);
}
