package com.xgb.java.base.map;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap的实现原理
 * 1、基于哈希表（数组+链表+二叉树（红黑树））JDK1.8
 * 2、默认加载因子为0.75，默认数组大小是16（1 << 4）
 * 3、把对象存储到哈希表中，如何存储？
 *	把key对象通过hash()方法技术hash值，然后用这个hash值对数组长度取余数（默认16），来决定对该key的对象在数组中的位置index，
 *	当这个位置有多个对象时，以链表结构存储，JDK1.8后，当链表长度大于8时，链表将转换为红黑树结构存储。
 *	（这样的目的是为了取值更快，存储数据量越大，性能表现越明显。）
 * 4、扩容原理：当数组的容量超过了负载因子，你们表示该数组需要扩容，如何扩容？
 *	扩充算法是：当前数组容量的<<1（相对应乘2），扩大一倍，扩容次数过多，会影响性能，每次扩容表示哈希表重新散列（重新计算每个对象的存储位置），
 *	我们在开发中尽量要减少扩充次数带来的性能问题。
 * 5、线程不安全，适合在单线程中使用。
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
