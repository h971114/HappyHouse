package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.SubwayDto;
import com.ssafy.happyhouse.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Override
	public void regist(MemberDto m) throws SQLException {
		dao.insert(m);
	}

	@Override
	public void modify(MemberDto m) throws SQLException {
		dao.update(m);
	}

	@Override
	public void remove(String id) throws SQLException {
		dao.delete(id);
	}

	@Override
	public MemberDto search(String id) throws SQLException {

		return dao.select(id);
	}

	@Override
	public List<MemberDto> searchAll() throws SQLException {
		return dao.selectAll();
	}

	@Override
	public Integer loginCheck(String user, String pass) throws SQLException {
		return dao.loginCheck(user, pass);
	}

	@Override
	public int searchArea(String interestArea) throws SQLException {
		return dao.searchArea(interestArea);
	}

	@Override
	public String getArea(int dongcode) throws SQLException {
		return dao.getArea(dongcode);
	}

	@Override
	public Map<String, String> getLocate(int dongcode) throws SQLException {
		return dao.getLocate(dongcode);
	}

	@Override
	public String getGun(int dongcode) throws SQLException {
		return dao.getGun(dongcode);
	}

	@Override
	public int getRank(int dongcode) throws SQLException {
		return dao.getRank(dongcode);
	}

	@Override
	public List<SubwayDto> getSubway(int dongcode) throws SQLException {
		return dao.getSubway(dongcode);
	}

}
