package org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.LendInfo;

public interface LendInfoDao {
	//根据readerId获取用户未还的借书信息
	public List<LendInfo> queryLendInfoByReaderId(int readerId);
	//插入借书信息
	public int insertLendInfo(LendInfo lendInfo);
}
