package org.dao;


import org.model.Reader;

public interface ChangeInfoDao {
	// 修改个人信息
	public int updateInfo(Reader reader);

	// 修改密码
	public int updatePassword(Reader reader);

	public Reader queryByReaderName(Reader reader);

}
