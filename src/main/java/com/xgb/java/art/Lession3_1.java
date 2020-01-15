package com.xgb.java.art;

/**
 * 迭代法，简单的来说就是不断的用旧的变量值，递推计算新的变量值。
 * @author 86581
 *
 */
public class Lession3_1 {
	
	/**
	 * 计算罕王需要给多少麦粒
	 * 迭代公式f(Xn) = f(Xn-1) * 2;
	 * @param grid 格子的数量
	 * @return long 麦粒的总数
	 */
	public static long getNumberOfWheat(int grid) {
		long sum = 0;//麦粒总数
		long numberOfWheatInGrid = 0;//当前格子里麦粒的数量
		
		numberOfWheatInGrid = 1;//第一个子麦粒的数量
		sum += numberOfWheatInGrid;
		System.out.println("当前第1格，需要放置麦粒" + numberOfWheatInGrid + "颗，累积放置麦粒" + sum + "颗");
		for (int i = 2; i < grid; i++) {
			numberOfWheatInGrid *= 2;//当前格子的麦粒数量是前一格的2倍
			sum += numberOfWheatInGrid;//累积当前格子的麦粒
			System.out.println("当前第" + i + "格，需要放置麦粒" + numberOfWheatInGrid + "颗，累积放置麦粒" + sum + "颗");
		}
		return sum;
	}
	
	/**
	 * 计算大于1的正整数之平方根
	 * 这里采用迭代中常见的二分法。每次查看区间内的中间值，检验它是否符合标准
	 * @param n 待求的数
	 * @param deltaThreshold 误差的阔值
	 * @param maxTry 二分查找的最大次数
	 * @return
	 */
	public static double getSqureRoot(int n,double deltaThreshold,int maxTry) {
		if(n <= 1) {
			System.out.println("请输入大于1的整数");
			return - 1.0;
		}
		double min = 1.0 , max = (double)n;
		for (int i = 0; i < maxTry; i++) {
			double middle = (min + max) / 2;
			double square = middle * middle;
			double delta = Math.abs((square / n) - 1);
			if(delta <= deltaThreshold) {
				System.out.println("找到解：" + middle);
				return middle;
			}else {
				if(square > n) {
					max = middle;
				}else {
					min = middle;
				}
			}
			
		}
		System.out.println("未能找到解");
		return -2.0;
	}
	
	
	
	public static void main(String[] args) {
		//System.err.println(Lession3_1.getNumberOfWheat(64));
		
		int number = 10;
		double squareRoot = Lession3_1.getSqureRoot(number, 0.000001, 1000);
	}
}
