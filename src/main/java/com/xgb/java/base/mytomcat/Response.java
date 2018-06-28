package com.xgb.java.base.mytomcat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ��Ӧ��װ�ࣺ����д��Ϣ��������
 * <p>Title: ������Ӧ��װ��</p>
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
	 * ��Ӧ��̬�������
	 * ������content
	 * @throws IOException 
	 * 
	 */
	public void writeConten(String content) throws IOException {
		os.write(content.getBytes());
		os.flush();
		os.close();
	}
	
	/**
	 * ��Ӧ��̬�������
	 * ������path
	 * @throws IOException 
	 */
	public void writeHtmlFile(String path) throws IOException {
		String htmlConteString = FileUtils.getFileContent(path);
		writeConten(htmlConteString);
	}
	
	/**
	 * д�ļ�
	 * @param path
	 * @throws Exception
	 */
	public void writeFile(String path) throws Exception {
		//��ȡ�ļ�
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
