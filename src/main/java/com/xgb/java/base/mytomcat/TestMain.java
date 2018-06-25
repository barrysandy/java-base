package com.xgb.java.base.mytomcat;

import java.util.HashMap;
import java.util.Map;

public class TestMain {
	
	private static Map<String,String> map = new HashMap<String,String>();
	
	public static void main(String[] args) {
		String uri = "name=kaka&pass=123&sex=nan";
		String[] params = uri.split("&");
		for(String s : params) {
			String[] temp = s.split("=");
			map.put(temp[0], temp[1]);
			System.out.println("key:" + temp[0] + " value:" + temp[1]);
		}
		
		System.out.println("Map ¼¯ºÏ£º" + map.size());
	}
}
