package com.xgb.java.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class NioClient {
	
	/**
	 * 客户端端通道
	 */
	private static SocketChannel client;
	
	
	/**
	 * 接受和发送的缓冲区Buffer
	 */
	private static ByteBuffer recBuffer = ByteBuffer.allocate(1024);
	
	private static ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	

	public static void main(String[] args) {
		try {
			String str = "hello server;";
			
			//实例化连接
			SocketAddress remote = new InetSocketAddress("127.0.0.1", 8080) ;
			client = SocketChannel.open(remote);
			System.out.println(client + "连接服务端");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
