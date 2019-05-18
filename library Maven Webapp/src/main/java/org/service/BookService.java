package org.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.Book;
import org.model.Pagebean;

public interface BookService {
	//按需查找全部图书
	public List<Book> queryAllBooksByCategory(List<Integer> categories);
	//按id查找图书
	public Book queryOneBook(int id);
	//获取热门图书
	public List<Book> queryHotBooks(String columnName, int limit);
	//按分类检索全部图书
	public Pagebean queryBooksByCategory(int pageNum, int id);
	//按关键字查询
	public List<Book> queryBookByKey(String key);
	//按author_id查找图书
	public List<Book> queryBookByAuthor(List<Integer> ids);
}
