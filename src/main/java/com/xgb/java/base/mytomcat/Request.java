package com.xgb.java.base.mytomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * 请求解析类
 * <p>Title: 请求解析URI</p>
 * <p>Description: </p>
 *
 * @author xiaowu
 * @version 1.0.0
 * @date 2018/6/25 14:44
 */
public class Request {
	
	//解析请求的URI
	private String uri;
	
	//定义一个参数字符
	private String pString;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Request(InputStream is) throws IOException {
		//输入流每次读出来的信息放入buff
		byte[] buff = new byte[1024];
		int len = is.read(buff);
		if(len > 0) {
			String msg = new String(buff,0,len);
			int start = msg.indexOf("GET") + 4;
			if(msg.indexOf("POST") != -1) {
				start = msg.indexOf("POST") + 5;
			}
			int end = msg.indexOf("HTTP/1.1") -1;
			
			
			System.out.println("----" + msg + "----");
			//拿到请求资源路径
//			uri = msg.substring(msg.indexOf("/"), msg.indexOf("HTTP/1.1")-1);
			uri = msg.substring(start, end);
			if(msg.endsWith("POST")) {
				int paramStart = msg.lastIndexOf("\n");
				pString = msg.substring(paramStart+1);
				System.out.println("----Request pString：" + pString + "----");
			}
			System.out.println("----Request uri：" + uri + "----");
		}else {
			System.out.println("bad Requset!!");
		}
	}
}
