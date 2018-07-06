package com.xgb.java.base.service;

import com.xgb.java.base.annotation.SMSRetry;

public interface SMSToSend {

	@SMSRetry(times = 5)
	void sendMsg(String msg);
}
