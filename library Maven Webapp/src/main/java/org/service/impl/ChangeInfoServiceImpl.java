package org.service.impl;


import org.dao.ChangeInfoDao;
import org.model.Reader;
import org.service.ChangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("changeInfoService")
public class ChangeInfoServiceImpl implements ChangeInfoService{
	
	@Autowired ChangeInfoDao changeInfoDao;
	
	@Override
	public int updateInfo(Reader reader) {
		int n = changeInfoDao.updateInfo(reader);
		return n;
	}

	@Override
	public int uadatePassword(Reader reader) {
		int n = changeInfoDao.updatePassword(reader);
		return n;
	}

	@Override
	public Reader queryByReaderName(Reader reader) {
		Reader reader1 = changeInfoDao.queryByReaderName(reader);
		return reader1;
	}

}
