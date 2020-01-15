package com.xgb.java.art.binaryTree;

public interface Tree {
    //���ҽڵ�
    public Node find(int key);
    //�����½ڵ�
    public boolean insert(int data);
     
    //�������
    public void infixOrder(Node current);
    //ǰ�����
    public void preOrder(Node current);
    //�������
    public void postOrder(Node current);
     
    //�������ֵ
    public Node findMax();
    //������Сֵ
    public Node findMin();
     
    //ɾ���ڵ�
    public boolean delete(int key);
     
    //Other Method......
}