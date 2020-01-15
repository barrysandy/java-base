package com.xgb.java.art;

/**
 * 矩阵类
 * @author 86581
 *
 */
public class Matrix {

	private int rows,columns;			//矩阵行、列数
	private int[][] element;			//二维矩阵元素
	public Matrix(int m,int n) {
		this.element = new int[m][n];
		this.rows = m;
		this.columns = n;
	}
	
	public Matrix(int n) {
		this(n,n);
	}
	
	public Matrix(int m,int n,int[][] value) {
		this(m,n);
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				this.element[i][j] = value[i][j];
			}
		}
	}
	
	public int getRows() {
		return this.rows;
	}

	
	public int getColumns() {
		return this.columns;
	}
	
	public int get(int i,int j) {
		if(i >= 0 && i <this.rows && j >=0 && j < this.columns) 
			return this.element[i][j];
		throw new IndexOutOfBoundsException("i=" + i + " j:" + j);
	}
	
	public void set(int i,int j,int x) {
		if(i >= 0 && i <this.rows && j >=0 && j < this.columns) 
			this.element[i][j] = x;
		else throw new IndexOutOfBoundsException("i=" + i + " j:" + j);
	}
	
	public String toString() {
		String str = "矩阵：" + this.getClass().getName() + "(" + this.rows + "x" + this.columns + "): \n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) 
				str += String.format("%6d", this.element[i][j]);
			str += "\n";
		}
		return str;
	}
	
	public void setRowsColumns(int m,int n) {
		if(m >0 && n > 0) {
			if(m > this.element.length || n > this.element[0].length) {
				int[][] source = this.element;
				this.element = new int[m][n];
				for (int i = 0; i < this.rows; i++) {
					for (int j = 0; j < this.columns; j++) {
						this.element[i][j] = source[i][j];
					}
					
				}
				this.rows = m;
				this.columns = n;
			}
		}
		else throw new IllegalArgumentException("矩阵行列数不能<=0, m=" + m + " ,n" + n);
	}
	
	
	public static void main(String[] args) {
		int value[][] = {{1,2,3},{4,5,6},{7,8}};
		Matrix matrix = new Matrix(3,4,value);
		System.err.println(matrix.get(2, 2));
		matrix.set(2, 2, 9);
		System.err.println(matrix);
	}
}