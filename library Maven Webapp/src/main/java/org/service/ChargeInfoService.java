package org.service;

import java.util.List;

import org.model.ChargeInfo;

public interface ChargeInfoService {
	//插入逾期信息
	public int insertChargeInfo(ChargeInfo chargeInfo);
	//查询用户全部逾期信息
	public List<ChargeInfo> queryAllByReaderId(int readerId);
}
