package com.ssafy.happyhouse.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.StoreInfoDto;

@Repository
public class StoreInfoDaoImpl implements StoreInfoDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<StoreInfoDto> getStoreInfo(String dong, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dong", dong);
		param.put("map", map);
		return sqlSession.selectList("storeinfo.selectstore",param);
	}

	@Override
	public int makePageNavigation(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("storeinfo.getTotalCount",map);
	}

}
