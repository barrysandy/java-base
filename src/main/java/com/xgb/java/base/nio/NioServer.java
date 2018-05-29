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
	 * �����ͨ��
	 */
	private ServerSocketChannel server;
	/**
	 * �����serversoket�˿ں�
	 */
	private int port = 8080;
	
	
	/**
	 * ��·����ע������ע��SelectKey���¼�
	 */
	private Selector selector;
	
	/**
	 * ���ܺͷ��͵Ļ�����Buffer
	 */
	private ByteBuffer recBuffer = ByteBuffer.allocate(1024);
	
	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	
	/**
	 * ���ӱ��
	 */
	private static int clientNo = 1105;
	
	/**
	 * �������
	 */
	Map<SelectionKey,String> sessionMsg = new HashMap<SelectionKey,String>();
	
	
	public NioServer(int port) throws IOException {
		this.port = port;
		server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress(this.port));
		server.configureBlocking(false);//����Ϊ������ͨѶ
		selector = Selector.open();
		server.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("NIO ��Ϣ��������ʼ����ϣ�������ʱ���ܿͻ������ӣ������˿�Ϊ:" + this.port);
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
	 * ����ÿһ��SelectKey������ͨ��Channel��Ϣ��Selector��Ϣ
	 * @param key
	 * @throws IOException 
	 */
	private void process(SelectionKey key){
		SocketChannel client = null;
		try {
			if(key.isValid() && key.isAcceptable()) {//key ����Ч�Ĳ���key�ǿ��Խ��ܵ�
				client = server.accept();
				clientNo++;
				client.configureBlocking(false);
				client.register(selector, SelectionKey.OP_READ);//���ñ�׼λΪ�ɶ�
			}else if(key.isValid() && key.isReadable()) {
				//����˴�SocketChannel�ж�ȡ�ͻ��˷��͹���������
				recBuffer.clear();
				client = (SocketChannel) key.channel();
				int len = client.read(recBuffer);
				if(len > 0) {
					String msg = new String(recBuffer.array(), 0, len);
					sessionMsg.put(key, msg);
					System.out.println("��ǰ�߳�Id��" + Thread.currentThread().getId() + " �������Կͻ��˵ı��Ϊ��" + clientNo + " ��ϢΪ��" + msg);
					client.register(selector, SelectionKey.OP_WRITE);
				}
			}else if(key.isValid() && key.isWritable()) {
				client = (SocketChannel) key.channel();
				sendBuffer.clear();
				sendBuffer.put((sessionMsg.get(key) + " ������������������").getBytes());
				sendBuffer.flip();
				client.write(sendBuffer);
				System.out.println("��ǰ�߳�Id��" + Thread.currentThread().getId() + " �Կͻ���д��Ϣ�ı��Ϊ��" + clientNo);
				client.register(selector, SelectionKey.OP_READ);
			}
		} catch (Exception e) {
			//��ֹ�ͻ��˷Ƿ�����
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
