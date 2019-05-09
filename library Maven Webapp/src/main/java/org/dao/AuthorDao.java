package org.dao;

import org.model.Author;

public interface AuthorDao {
	//根据id获取作者信息
	public Author queryAuthorById(int id);
}
