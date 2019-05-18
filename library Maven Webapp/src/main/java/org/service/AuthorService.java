package org.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.Author;

public interface AuthorService {
	//根据id获取作者信息
	public Author queryAuthorById(int id);
	//根据名字获取作者信息
	public List<Integer> queryAuthorByName(@Param("name") String name);
}
