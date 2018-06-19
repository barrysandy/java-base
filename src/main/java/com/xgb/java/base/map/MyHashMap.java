package com.xgb.java.base.map;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap��ʵ��ԭ��
 * 1�����ڹ�ϣ������+����+�����������������JDK1.8
 * 2��Ĭ�ϼ�������Ϊ0.75��Ĭ�������С��16��1 << 4��
 * 3���Ѷ���洢����ϣ���У���δ洢��
 *	��key����ͨ��hash()��������hashֵ��Ȼ�������hashֵ�����鳤��ȡ������Ĭ��16�����������Ը�key�Ķ����������е�λ��index��
 *	�����λ���ж������ʱ��������ṹ�洢��JDK1.8�󣬵������ȴ���8ʱ������ת��Ϊ������ṹ�洢��
 *	��������Ŀ����Ϊ��ȡֵ���죬�洢������Խ�����ܱ���Խ���ԡ���
 * 4������ԭ������������������˸������ӣ����Ǳ�ʾ��������Ҫ���ݣ�������ݣ�
 *	�����㷨�ǣ���ǰ����������<<1�����Ӧ��2��������һ�������ݴ������࣬��Ӱ�����ܣ�ÿ�����ݱ�ʾ��ϣ������ɢ�У����¼���ÿ������Ĵ洢λ�ã���
 *	�����ڿ����о���Ҫ������������������������⡣
 * 5���̲߳���ȫ���ʺ��ڵ��߳���ʹ�á�
 */
public class MyHashMap implements MyMap{
	
	public static void main(String[] args) throws Exception {
		//Map<String,String> map = new HashMap<String,String>();
		StringBuffer sb = new StringBuffer();
		RandomAccessFile file = new RandomAccessFile("G:\\a.txt", "rw");
		FileChannel channel = file.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(channel.read(buffer) != -1) {
			int read = channel.read(buffer);
			System.out.println("read: " + read);
			buffer.flip();
			while(buffer.hasRemaining()) {
				sb.append((char)buffer.get());
			}
			buffer.clear();
			read = channel.read(buffer);
		}
		file.close();
		
		System.out.println(sb.toString());
	}
}
