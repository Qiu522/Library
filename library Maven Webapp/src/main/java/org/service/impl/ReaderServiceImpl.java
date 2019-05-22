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
	
	//实现登陆
		@Override
		public Reader checkLogin(String readername, String password) {
			Reader reader = readerDao.findByReaderName(readername);
			if (reader != null && reader.getPassword().equals(password)) {
				return reader;
			}

			return null;
		}

		//实现注册
		@Override
		public int Regist(String readername, String password) {
			int n = readerDao.registerByReaderNameAndPassword(readername, password);
			return n;
		}

		@Override
		public Reader queryReaderByName(String readerName) {
			return readerDao.queryReaderByName(readerName);
		}

}
