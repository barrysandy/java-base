package com.xgb.java.art.binaryTree;

/**
* 类说明
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年12月23日 上午9:59:54
*/
public class Node {

	int data;
	Node leftChild;
	Node rightChild;
	boolean isDelete;
	
	public Node(int data){
		this.data = data;
	}
	
	public void display(){
		System.out.println("data: " + data);
	}
}