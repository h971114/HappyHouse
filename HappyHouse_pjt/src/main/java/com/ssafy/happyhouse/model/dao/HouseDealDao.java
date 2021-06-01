package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.HouseDealDto;

public interface HouseDealDao {
	List<HouseDealDto> getAptInDong(int code, String aptName) throws Exception;
	List<HouseDealDto> getDealInApt(int code,String aptName) throws Exception;
}
