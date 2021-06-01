package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseDealDto;

public interface HouseDealService {
	List<HouseDealDto> getAptInDong(int code, String aptName) throws Exception;
	List<HouseDealDto> getDealInApt(int code,String aptName) throws Exception;
}
