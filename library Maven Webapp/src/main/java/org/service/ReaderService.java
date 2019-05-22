package org.service;

import org.apache.ibatis.annotations.Param;
import org.model.Reader;

public interface ReaderService {
	//通过id查询用户
	public Reader queryReaderById(int id);
	//通过name查询用户
	public Reader queryReaderByName(String readerName);
	
	
	//用户数据更新
	public int updateReader(Reader reader);
	
	Reader checkLogin(String readername, String password);
	
	int Regist(String readername, String password);
}
