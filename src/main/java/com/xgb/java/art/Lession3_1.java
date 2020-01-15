package com.xgb.java.art;

/**
 * ���������򵥵���˵���ǲ��ϵ��þɵı���ֵ�����Ƽ����µı���ֵ��
 * @author 86581
 *
 */
public class Lession3_1 {
	
	/**
	 * ���㺱����Ҫ����������
	 * ������ʽf(Xn) = f(Xn-1) * 2;
	 * @param grid ���ӵ�����
	 * @return long ����������
	 */
	public static long getNumberOfWheat(int grid) {
		long sum = 0;//��������
		long numberOfWheatInGrid = 0;//��ǰ����������������
		
		numberOfWheatInGrid = 1;//��һ��������������
		sum += numberOfWheatInGrid;
		System.out.println("��ǰ��1����Ҫ��������" + numberOfWheatInGrid + "�ţ��ۻ���������" + sum + "��");
		for (int i = 2; i < grid; i++) {
			numberOfWheatInGrid *= 2;//��ǰ���ӵ�����������ǰһ���2��
			sum += numberOfWheatInGrid;//�ۻ���ǰ���ӵ�����
			System.out.println("��ǰ��" + i + "����Ҫ��������" + numberOfWheatInGrid + "�ţ��ۻ���������" + sum + "��");
		}
		return sum;
	}
	
	/**
	 * �������1��������֮ƽ����
	 * ������õ����г����Ķ��ַ���ÿ�β鿴�����ڵ��м�ֵ���������Ƿ���ϱ�׼
	 * @param n �������
	 * @param deltaThreshold ������ֵ
	 * @param maxTry ���ֲ��ҵ�������
	 * @return
	 */
	public static double getSqureRoot(int n,double deltaThreshold,int maxTry) {
		if(n <= 1) {
			System.out.println("���������1������");
			return - 1.0;
		}
		double min = 1.0 , max = (double)n;
		for (int i = 0; i < maxTry; i++) {
			double middle = (min + max) / 2;
			double square = middle * middle;
			double delta = Math.abs((square / n) - 1);
			if(delta <= deltaThreshold) {
				System.out.println("�ҵ��⣺" + middle);
				return middle;
			}else {
				if(square > n) {
					max = middle;
				}else {
					min = middle;
				}
			}
			
		}
		System.out.println("δ���ҵ���");
		return -2.0;
	}
	
	
	
	public static void main(String[] args) {
		//System.err.println(Lession3_1.getNumberOfWheat(64));
		
		int number = 10;
		double squareRoot = Lession3_1.getSqureRoot(number, 0.000001, 1000);
	}
}
