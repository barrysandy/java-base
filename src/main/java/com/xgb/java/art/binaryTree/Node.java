package com.xgb.java.art.binaryTree;

/**
* ��˵��
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��12��23�� ����9:59:54
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