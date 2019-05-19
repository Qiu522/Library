package org.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.LendInfo;

public interface LendInfoService {
	//插入借书信息
	public int insertLendInfo(int readerId, int bookId);
	//还书借书信息
	public int updateLendInfo(int readerId, int bookId);
	//查询全部
	public List<LendInfo> queryAllByReaderId(int readerId);
	//根据readerId获取用户未还的借书信息
	public List<LendInfo> queryLendInfoByReaderId(int readerId);
	//查询用户逾期记录
	public List<LendInfo> queryLateBorrowByReaderId(int readerId);
	//查询某项借书记录
	public LendInfo queryOneLendInfo(int readerId, int bookId);
}
