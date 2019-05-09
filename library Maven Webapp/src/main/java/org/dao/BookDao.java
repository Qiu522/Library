package org.dao;

import java.util.List;

import org.model.Book;

public interface BookDao {
	//获取热门图书
	public List<Book> queryHotBooks();
}
