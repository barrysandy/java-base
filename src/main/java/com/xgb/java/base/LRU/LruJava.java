package com.xgb.java.base.LRU;

import java.util.UUID;


public class LruJava {

	public static void main(String[] args) {
		GuidToInt64();
		
	}

	/// <summary>
	/// ����GUID��ȡΨһ��������
	/// </summary>
	public static long GuidToInt64(){
	    byte[] bytes = getUUID().getBytes();
	    System.out.println(bytes);
	    return 0;
	}
	
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(uuid);
		return uuid;
	}
	
	
	
}
