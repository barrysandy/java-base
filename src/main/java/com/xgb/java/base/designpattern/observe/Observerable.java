package com.xgb.java.base.designpattern.observe;


/**
 * ���󱻹۲��߽ӿ�
 * ��������ӡ�ɾ����֪ͨ�۲��ߵķ���
 * @author xgb
 *
 */
public interface Observerable {

	public void registerObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver();
}
