package com.ssafy.happyhouse.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.NoticeDto;

public interface NoticeDao {
	List<NoticeDto> getNoticeList() throws Exception;
	NoticeDto getNotice(int no) throws Exception;
	int insert(NoticeDto notice) throws Exception;
	List<NoticeDto> getNoticeList(Map<String, Object> map) throws Exception;
	int makePageNavigation(Map<String, String> map);
	
}
