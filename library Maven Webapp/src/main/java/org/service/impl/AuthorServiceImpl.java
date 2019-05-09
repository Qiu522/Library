package org.service.impl;

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
	
	
}
