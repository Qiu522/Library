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
	public List<Book> queryHotBooks() {
		// TODO Auto-generated method stub
		return bookDao.queryHotBooks();
	}
	
}
