package org.service;

import org.model.Author;

public interface AuthorService {
	//根据id获取作者信息
		public Author queryAuthorById(int id);
}