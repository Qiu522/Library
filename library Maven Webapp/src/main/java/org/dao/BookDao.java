package org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.Book;

public interface BookDao {
	//按id查找图书
	public Book queryOneBook(@Param("id") int id);
	
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
	
	
}
