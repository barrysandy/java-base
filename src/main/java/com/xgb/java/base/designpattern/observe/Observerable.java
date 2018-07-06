package com.xgb.java.base.designpattern.observe;


/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者的方法
 * @author xgb
 *
 */
public interface Observerable {

	public void registerObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver();
}
