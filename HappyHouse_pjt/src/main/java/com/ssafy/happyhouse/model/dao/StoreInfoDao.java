package com.ssafy.happyhouse.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.StoreInfoDto;

public interface StoreInfoDao {
	List<StoreInfoDto> getStoreInfo(String dong,Map<String, Object> param) throws Exception;

	int makePageNavigation(Map<String, String> map);
}
