package org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.Book;
import org.model.Category;

public interface BookDao {
	//按需查找全部图书
	public List<Book> queryAllBooksByCategory(@Param("categories")List<Integer> categories);
	
	//按id查找图书
	public Book queryOneBook(@Param("id") int id);
	//按author_id查找图书
	public List<Book> queryBookByAuthor(@Param("author_ids") List<Integer> ids);
	
	//按序检索图书
	/**
     * 按排序检索出需求量的图书
     *
     * @param columnName 用于排序的量
     * @param limit 需要检索的数据量
     * 
     * @return 书集合
     */
	public List<Book> queryHotBooks(@Param("columnName") String columnName, @Param("limit") int limit);
	
	//按分类检索一页图书            
	public List<Book> queryBooksByCategory(@Param("categories")List<Integer> categories, @Param("pageNum") int pageNum, @Param("totalPageNum") int totalPageNum);
	
	//按关键字查询
	public List<Book> queryBookByKey(@Param("key") String key);
}
