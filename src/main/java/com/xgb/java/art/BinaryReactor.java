package com.xgb.java.art;

import java.util.Arrays;

public class BinaryReactor {

    /**
     * 上浮操作
     * （增加节点）
     * @param array
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length - 1; //最后一个叶子节点
        int parentIndex = (childIndex - 1) / 2;//最后一个非叶子节点的父节点
        int temp = array[childIndex]; //临时保存最后的叶子节点
        //当最后一个叶子节点大于0 并且最后一叶子节点大于最后一个非叶子的父节点
        //就进行叫换，数组直接进行赋值即可
        while (childIndex > 0 && temp > array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;   //最后的一个叶子节点指向父节点
            parentIndex = (parentIndex -1) / 2; //非叶子节点的父节点指向向上一层父节点
        }
        array[childIndex] = temp;
    }



    /**
     * 下沉操作
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array,int parentIndex,int length){
        //temp 保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while(childIndex < length){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if(childIndex + 1 < length && array[childIndex + 1] > array[childIndex]){
                childIndex ++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
            if(temp >= array[childIndex]){
                break;
            }
            //无需真正交换，直接单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建二叉堆
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