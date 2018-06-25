package com.xgb.java.base.mytomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * ���������
 * <p>Title: �������URI</p>
 * <p>Description: </p>
 *
 * @author xiaowu
 * @version 1.0.0
 * @date 2018/6/25 14:44
 */
public class Request {
	
	//���������URI
	private String uri;
	
	//����һ�������ַ�
	private String pString;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Request(InputStream is) throws IOException {
		//������ÿ�ζ���������Ϣ����buff
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
			//�õ�������Դ·��
//			uri = msg.substring(msg.indexOf("/"), msg.indexOf("HTTP/1.1")-1);
			uri = msg.substring(start, end);
			if(msg.endsWith("POST")) {
				int paramStart = msg.lastIndexOf("\n");
				pString = msg.substring(paramStart+1);
				System.out.println("----Request pString��" + pString + "----");
			}
			System.out.println("----Request uri��" + uri + "----");
		}else {
			System.out.println("bad Requset!!");
		}
	}
}
