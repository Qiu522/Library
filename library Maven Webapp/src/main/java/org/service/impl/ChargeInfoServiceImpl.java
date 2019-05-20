package org.service.impl;

import java.util.List;

import org.dao.ChargeInfoDao;
import org.model.ChargeInfo;
import org.service.ChargeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("chargeInfoService")
public class ChargeInfoServiceImpl implements ChargeInfoService {
	@Autowired ChargeInfoDao chargeInfoDao;
	
	@Override
	public int insertChargeInfo(ChargeInfo chargeInfo) {
		return chargeInfoDao.insertChargeInfo(chargeInfo);
	}

	@Override
	public List<ChargeInfo> queryAllByReaderId(int readerId) {
		return chargeInfoDao.queryAllByReaderId(readerId);
	}

}
