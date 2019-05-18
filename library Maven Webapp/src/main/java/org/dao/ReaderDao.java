package org.dao;

import org.apache.ibatis.annotations.Param;
import org.model.Reader;

public interface ReaderDao {
	//通过id查询用户
	public Reader queryReaderById(@Param("id") int id);
	
	//用户数据更新
	public int updateReader(Reader reader);
}
