package com.xgb.java.base.mytomcat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 响应封装类：就是写信息给请求者
 * <p>Title: 请求响应封装类</p>
 * <p>Description: </p>
 *
 * @author xiaowu
 * @version 1.0.0
 * @date 2018/6/25 14:44
 */
public class Response {
	private OutputStream os = null;
	
	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	public Response(OutputStream os) throws IOException {
		this.os = os;
	}
	
	/**
	 * 响应动态请求输出
	 * 参数：content
	 * @throws IOException 
	 * 
	 */
	public void writeConten(String content) throws IOException {
		os.write(content.getBytes());
		os.flush();
		os.close();
	}
	
	/**
	 * 响应静态输出请求
	 * 参数：path
	 * @throws IOException 
	 */
	public void writeHtmlFile(String path) throws IOException {
		String htmlConteString = FileUtils.getFileContent(path);
		writeConten(htmlConteString);
	}
	
	/**
	 * 写文件
	 * @param path
	 * @throws Exception
	 */
	public void writeFile(String path) throws Exception {
		//读取文件
		FileInputStream fis = new FileInputStream(path);
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff)) != -1) {
			os.write(buff, 0, len);
		}
		fis.close();
		os.flush();
		os.close();
	}
	
	
}
