package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.SubwayDto;

public interface MemberDao {
	public void insert(MemberDto member) throws SQLException;
	public void update(MemberDto member) throws SQLException;
	public void delete(String id) throws SQLException;
	
	public MemberDto select(String id) throws SQLException;
	public List<MemberDto> selectAll() throws SQLException;
	
	public Integer loginCheck(String user, String pass) throws SQLException;
	public int searchArea(String interestArea) throws SQLException;
	public String getArea(int dongcode) throws SQLException;
	
	public Map<String, String> getLocate(int dongcode) throws SQLException;
	
	public String getGun(int dongcode) throws SQLException;
	public int getRank(int dongcode) throws SQLException;
	public List<SubwayDto> getSubway(int dongcode)throws SQLException;
}
