package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.dao.HouseDealDao;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	@Autowired
	private  HouseDealDao dao;
	
	@Override
	public List<HouseDealDto> getAptInDong(int code, String aptName) throws Exception {
		return dao.getAptInDong(code,aptName);
	}

	@Override
	public List<HouseDealDto> getDealInApt(int code, String aptName) throws Exception {
		return dao.getDealInApt(code,aptName);
	}

}
