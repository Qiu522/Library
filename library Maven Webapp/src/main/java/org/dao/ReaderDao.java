package org.dao;

import org.apache.ibatis.annotations.Param;
import org.model.Reader;

public interface ReaderDao {
	//通过id查询用户
	public Reader queryReaderById(@Param("id") int id);
	
	//用户数据更新
	public int updateReader(Reader reader);
	
	/**
	 * 查找用户名和密码
	 */
	Reader findByReaderName(String readerName);

	/**
	 * 注册用户和密码
	 * @return 
	 */
	int registerByReaderNameAndPassword(@Param("readerName") String readerName,
			@Param("password") String password);

	public Reader queryReaderByName(@Param("readerName") String readerName);
}
