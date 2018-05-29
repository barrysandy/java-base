package com.xgb.java.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class NioServer {
	
	/**
	 * 服务端通道
	 */
	private ServerSocketChannel server;
	/**
	 * 服务端serversoket端口号
	 */
	private int port = 8080;
	
	
	/**
	 * 多路复用注册器，注册SelectKey等事件
	 */
	private Selector selector;
	
	/**
	 * 接受和发送的缓冲区Buffer
	 */
	private ByteBuffer recBuffer = ByteBuffer.allocate(1024);
	
	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	
	/**
	 * 连接编号
	 */
	private static int clientNo = 1105;
	
	/**
	 * 缓存机制
	 */
	Map<SelectionKey,String> sessionMsg = new HashMap<SelectionKey,String>();
	
	
	public NioServer(int port) throws IOException {
		this.port = port;
		server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress(this.port));
		server.configureBlocking(false);//设置为非阻塞通讯
		selector = Selector.open();
		server.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("NIO 消息服务器初始化完毕，可以随时接受客户端连接，监听端口为:" + this.port);
	}
	
	@SuppressWarnings("unused")
	private void listener() throws IOException {
		while(true) {
			int count = selector.select(3000);
			if(count == 0) {
				continue;
			}
			final Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iteratorKeys = keys.iterator();
			while(iteratorKeys.hasNext()) {
				process(iteratorKeys.next());
			}
		}
	}
	
	/**
	 * 处理每一个SelectKey，包含通道Channel信息和Selector信息
	 * @param key
	 * @throws IOException 
	 */
	private void process(SelectionKey key){
		SocketChannel client = null;
		try {
			if(key.isValid() && key.isAcceptable()) {//key 是有效的并且key是可以接受的
				client = server.accept();
				clientNo++;
				client.configureBlocking(false);
				client.register(selector, SelectionKey.OP_READ);//设置标准位为可读
			}else if(key.isValid() && key.isReadable()) {
				//服务端从SocketChannel中读取客户端发送过来的数据
				recBuffer.clear();
				client = (SocketChannel) key.channel();
				int len = client.read(recBuffer);
				if(len > 0) {
					String msg = new String(recBuffer.array(), 0, len);
					sessionMsg.put(key, msg);
					System.out.println("当前线程Id：" + Thread.currentThread().getId() + " 处理来自客户端的编号为：" + clientNo + " 信息为：" + msg);
					client.register(selector, SelectionKey.OP_WRITE);
				}
			}else if(key.isValid() && key.isWritable()) {
				client = (SocketChannel) key.channel();
				sendBuffer.clear();
				sendBuffer.put((sessionMsg.get(key) + " 服务器完成了你的请求").getBytes());
				sendBuffer.flip();
				client.write(sendBuffer);
				System.out.println("当前线程Id：" + Thread.currentThread().getId() + " 对客户端写信息的编号为：" + clientNo);
				client.register(selector, SelectionKey.OP_READ);
			}
		} catch (Exception e) {
			//防止客户端非法下线
			key.cancel();
			try {
				client.socket().close();
				client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		try {
			new NioServer(8080).listener();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
