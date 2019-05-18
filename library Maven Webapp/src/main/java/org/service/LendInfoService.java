package org.service;

import org.apache.ibatis.annotations.Param;
import org.model.LendInfo;

public interface LendInfoService {
	public int insertLendInfo(@Param("lendInfo") LendInfo lendInfo);
}
