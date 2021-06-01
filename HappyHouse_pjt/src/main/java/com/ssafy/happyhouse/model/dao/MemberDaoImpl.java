package com.ssafy.happyhouse.model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.SubwayDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(MemberDto member) throws SQLException {
		// TODO Auto-generated method stub
		if (member.getDongcode() == 0) {
			sqlSession.insert("member.insertNull", member);
		} else {
			sqlSession.insert("member.insert", member);
		}
	}

	@Override
	public void update(MemberDto member) throws SQLException {
		// TODO Auto-generated method stub
		sqlSession.update("member.update", member);
	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub
		sqlSession.delete("member.delete", id);
	}

	@Override
	public MemberDto select(String id) throws SQLException {
		// TODO Auto-generated method stub
		MemberDto m = sqlSession.selectOne("member.select", id);

		return m;
	}

	@Override
	public List<MemberDto> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.selectAll");
	}

	@Override
	public Integer loginCheck(String user, String pass) throws SQLException {
		Map<String, String> map = new HashMap<>();

		map.put("id", user);
		map.put("pw", sha256(pass));

		return sqlSession.selectOne("member.loginCheck", map);
	}

	public static String sha256(String msg) {

		MessageDigest md;
		StringBuilder builder = new StringBuilder();
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());

			for (byte b : md.digest()) {
				builder.append(String.format("%02x", b));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}

		return builder.toString();
	}

	@Override
	public int searchArea(String interestArea) throws SQLException {
		Map<String, String> map = new HashMap<>();

		String[] areaArray = interestArea.split(" ");
		int dongcode = 0;
		if (areaArray.length == 3) {
			System.out.println(areaArray[0] + " " + areaArray[1] + " " + areaArray[2]);

			map.put("city", areaArray[0]);
			map.put("gugun", areaArray[1]);
			map.put("dong", areaArray[2]);

			try {
				dongcode = sqlSession.selectOne("member.searchArea", map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dongcode;
	}

	@Override
	public String getArea(int dongcode) throws SQLException {
		Map<String, String> map = new HashMap<>();

		String result = "";

		map = sqlSession.selectOne("member.getArea", dongcode);

		String city = map.get("city");
		String gugun = map.get("gugun");
		String dong = map.get("dong");

		result = city + " " + gugun + " " + dong;

		return result;
	}

	@Override
	public Map<String, String> getLocate(int dongcode) throws SQLException {
		Map<String, String> map = new HashMap<>();

		map = sqlSession.selectOne("member.getLocate", dongcode);
		return map;
	}

	@Override
	public String getGun(int dongcode) throws SQLException {
		// TODO Auto-generated method stub
		String gun = sqlSession.selectOne("member.getGun", dongcode);
		return sqlSession.selectOne("member.getPercent", gun);
	}

	@Override
	public int getRank(int dongcode) throws SQLException {
		// TODO Auto-generated method stub
		String gun = sqlSession.selectOne("member.getGun", dongcode);
		return sqlSession.selectOne("member.getRank", gun);
	}

	@Override
	public List<SubwayDto> getSubway(int dongcode) throws SQLException {
		// TODO Auto-generated method stub
		String dong = sqlSession.selectOne("member.getDong", dongcode);
		dong = dong.replace("동", "");
		System.out.println(dong);
		return sqlSession.selectList("member.getSubway", dong);
	}

}
