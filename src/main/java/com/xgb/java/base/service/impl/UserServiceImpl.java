package com.xgb.java.base.service.impl;

import com.xgb.java.base.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public void save(Object obj) {
		System.out.println("do save");
	}

	@Override
	public int count() {
		System.out.println("do count");
		return 0;
	}

	@Override
	public void pull() {
		System.out.println("do pull");
	}

}
