package org.dao;

import org.apache.ibatis.annotations.Param;
import org.model.LendInfo;

public interface LendInfoDao {
	public int insertLendInfo(@Param("lendInfo") LendInfo lendInfo);
}
