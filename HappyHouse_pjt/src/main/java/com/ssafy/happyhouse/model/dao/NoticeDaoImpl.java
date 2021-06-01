package com.ssafy.happyhouse.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<NoticeDto> getNoticeList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("notice.selectnotice");
	}

	@Override
	public NoticeDto getNotice(int n_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.select",n_no);
	}

	@Override
	public int insert(NoticeDto notice) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("notice.insert",notice);
	}

	@Override
	public List<NoticeDto> getNoticeList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("notice.selectnoticeall",map);
	}

	@Override
	public int makePageNavigation(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.getTotalCount",map);
	}

}
