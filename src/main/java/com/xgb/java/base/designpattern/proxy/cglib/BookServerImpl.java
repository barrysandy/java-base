package com.xgb.java.base.designpattern.proxy.cglib;

/**
 * Cglib proxy targer
 * @author xgb
 *
 */
public class BookServerImpl {

	public void addBook(String bookName) {
		
		System.out.println("Add new Book , Book Name£º" + bookName);
	}
}
