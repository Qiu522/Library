package org.service.impl;

import org.dao.LendInfoDao;
import org.model.LendInfo;
import org.service.LendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lendInfoService")
public class LendInfoServiceImpl implements LendInfoService{
	@Autowired LendInfoDao lendInfoDao;
	
	@Override
	public int insertLendInfo(LendInfo lendInfo) {
		return lendInfoDao.insertLendInfo(lendInfo);
	}

}
