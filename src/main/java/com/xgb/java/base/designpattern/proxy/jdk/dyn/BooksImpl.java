package com.xgb.java.base.designpattern.proxy.jdk.dyn;

public class BooksImpl implements Books {

	@Override
	public void addBooks(String bookName) {
		System.out.println("\n添加书籍成功，书名：" + bookName);
	}

}
