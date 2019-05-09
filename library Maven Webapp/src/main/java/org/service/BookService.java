package org.service;

import java.util.List;

import org.model.Book;

public interface BookService {
	//获取热门图书
		public List<Book> queryHotBooks();
}
