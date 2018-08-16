package com.xgb.java.base.designpattern.proxy.cglib;

public class Test {

	public static void main(String[] args) {
		BookServerImpl bookServerImpl = new BookServerImpl();
		BookServerCglib cglib = new BookServerCglib();
		BookServerImpl bookCglib = (BookServerImpl) cglib.getInstance(bookServerImpl);
		bookCglib.addBook("JAVA");
	}

}
