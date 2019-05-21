package org.service;

import org.model.Reader;

public interface ChangeInfoService {
	
	//修改个人信息
	public int updateInfo(Reader reader);
	//修改密码
	public int uadatePassword(Reader reader);
	//通过查找是否存在相同用户名
	public Reader queryByReaderName(Reader reader);
}
