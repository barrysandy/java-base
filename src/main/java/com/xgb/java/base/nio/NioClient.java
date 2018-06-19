package com.xgb.java.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class NioClient {
	
	/**
	 * �ͻ��˶�ͨ��
	 */
	private static SocketChannel client;
	
	
	/**
	 * ���ܺͷ��͵Ļ�����Buffer
	 */
	private static ByteBuffer recBuffer = ByteBuffer.allocate(1024);
	
	private static ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	

	public static void main(String[] args) {
		try {
			String str = "hello server;";
			
			//ʵ��������
			SocketAddress remote = new InetSocketAddress("127.0.0.1", 8080) ;
			client = SocketChannel.open(remote);
			System.out.println(client + "���ӷ����");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
