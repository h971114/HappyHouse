package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.StoreInfoDto;
import com.ssafy.util.PageNavigation;

public interface StoreInfoService {
	List<StoreInfoDto> getStoreInfo(String dong,Map<String, String> map) throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
