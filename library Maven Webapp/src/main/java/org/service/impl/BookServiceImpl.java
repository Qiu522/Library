package org.service.impl;

import java.util.List;

import org.dao.BookDao;
import org.model.Book;
import org.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book queryOneBook(int id) {
		return bookDao.queryOneBook(id);
	}
	
	@Override
	public List<Book> queryHotBooks(String columnName, int limit) {
		return bookDao.queryHotBooks(columnName, limit);
	}
	
	
}
