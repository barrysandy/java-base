package com.xgb.java.base.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * ���۲��ߣ�Ҳ����΢�Ź��ںŷ���
 * ʵ����Observeable�ӿڣ���Observeable�ӿڵ��������������˾���ʵ��
 * @author xgb
 *
 */
public class WeChatServer implements Observerable {
	
	//ע�⵽���List���ϵķ��Ͳ���ΪObserver�ӿڣ����ԭ������ӿڱ�̶���������ʵ�ֱ��
	private List<Observer> list;
	private String message;
	
	public WeChatServer() {
		list = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		list.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		if(!list.isEmpty()) {
			list.remove(o);
		}
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < list.size(); i++) {
			Observer o = list.get(i);
			o.update(message);
		}
	}
	
	public void setInfomation(String s) {
        this.message = s;
        System.out.println("΢�ŷ��������Ϣ�� " + s);
        //��Ϣ���£�֪ͨ���й۲���
        notifyObserver();
    }

}
