package com.xgb.java.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 默认的重试次数
 * <p>Title: SMSRetry</p>
 * <p>Description: 消息默认重试次数</p>
 *
 * @author xgb
 * @version 1.0.0
 * @date 2018/6/29 10:47
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SMSRetry {

	int times() default 1;
}
