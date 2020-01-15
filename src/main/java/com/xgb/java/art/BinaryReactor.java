package com.xgb.java.art;

import java.util.Arrays;

public class BinaryReactor {

    /**
     * �ϸ�����
     * �����ӽڵ㣩
     * @param array
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length - 1; //���һ��Ҷ�ӽڵ�
        int parentIndex = (childIndex - 1) / 2;//���һ����Ҷ�ӽڵ�ĸ��ڵ�
        int temp = array[childIndex]; //��ʱ��������Ҷ�ӽڵ�
        //�����һ��Ҷ�ӽڵ����0 �������һҶ�ӽڵ�������һ����Ҷ�ӵĸ��ڵ�
        //�ͽ��нл�������ֱ�ӽ��и�ֵ����
        while (childIndex > 0 && temp > array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;   //����һ��Ҷ�ӽڵ�ָ�򸸽ڵ�
            parentIndex = (parentIndex -1) / 2; //��Ҷ�ӽڵ�ĸ��ڵ�ָ������һ�㸸�ڵ�
        }
        array[childIndex] = temp;
    }



    /**
     * �³�����
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array,int parentIndex,int length){
        //temp ���游�ڵ�ֵ���������ĸ�ֵ
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while(childIndex < length){
            //������Һ��ӣ����Һ��Ӵ������ӵ�ֵ����λ���Һ���
            if(childIndex + 1 < length && array[childIndex + 1] > array[childIndex]){
                childIndex ++;
            }
            //������ڵ�����κ�һ�����ӵ�ֵ��ֱ������
            if(temp >= array[childIndex]){
                break;
            }
            //��������������ֱ�ӵ���ֵ����
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * ���������
     * @param array
     */
    private static  void buildHeap(int[] array){
        for (int i = (array.length -2) / 2;i>=0;i--){
            downAdjust(array,i,array.length);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}