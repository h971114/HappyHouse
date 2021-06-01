package com.ssafy.happyhouse.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.HouseDealDto;

@Repository
public class HouseDealDaoImpl implements HouseDealDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<HouseDealDto> getAptInDong(int code, String aptName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("housedeal.selectapt");
	}

	@Override
	public List<HouseDealDto> getDealInApt(int code, String aptName) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		String code1 = Integer.toString(code);
		map.put("code", code1);
		map.put("aptName", aptName);
		
		return sqlSession.selectList("housedeal.selectdeal",map);
	}

}
