package org.service.impl;

import java.util.List;

import org.dao.AuthorDao;
import org.model.Author;
import org.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorDao authorDao;

	@Override
	public Author queryAuthorById(int id) {
		return authorDao.queryAuthorById(id);
	}

	@Override
	public List<Integer> queryAuthorByName(String name) {
		// TODO Auto-generated method stub
		return authorDao.queryAuthorByName(name);
	}
	
	
}
