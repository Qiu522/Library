package org.service;

import java.util.List;

import org.model.Book;

public interface BookService {
	//按id查找图书
		public Book queryOneBook(int id);
	//获取热门图书
	public List<Book> queryHotBooks(String columnName, int limit);
}
