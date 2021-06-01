package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.SubwayDto;

public interface MemberService {
	public void regist(MemberDto m) throws SQLException;
	public void modify(MemberDto m) throws SQLException;
	public void remove(String id) throws SQLException;
	
	public MemberDto search(String id) throws SQLException;
	public List<MemberDto> searchAll() throws SQLException;
	
	public Integer loginCheck(String user, String pass) throws SQLException;
	public int searchArea(String interestArea) throws SQLException;
	public String getArea(int dongcode) throws SQLException;
	
	public Map<String, String> getLocate(int dongcode) throws SQLException;
	
	public   String getGun(int dongcode) throws SQLException;
	public int getRank(int dongcode) throws SQLException;
	public List<SubwayDto> getSubway(int dongcode) throws SQLException;
}
