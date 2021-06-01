package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

@Repository
public class HouseMapDaoImpl implements HouseMapDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("housemap.selectsido");
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("housemap.selectgugun",sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("housemap.selectdong",gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("housemap.selectapt",dong);
	}

}
