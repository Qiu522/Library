package org.service.impl;

import org.dao.ReaderDao;
import org.model.Reader;
import org.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("readerService")
public class ReaderServiceImpl implements ReaderService {
	@Autowired ReaderDao readerDao;
	
	@Override
	public Reader queryReaderById(int id) {
		return readerDao.queryReaderById(id);
	}

	@Override
	public int updateReader(Reader reader) {
		
		return readerDao.updateReader(reader);
	}

}
