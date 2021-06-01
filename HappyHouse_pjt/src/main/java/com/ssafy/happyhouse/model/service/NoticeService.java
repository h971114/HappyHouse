package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.util.PageNavigation;

public interface NoticeService {
	List<NoticeDto> getNoticeList() throws Exception;
	NoticeDto getNotice(int no) throws Exception;
	int insert(NoticeDto notice) throws Exception;
	 List<NoticeDto> getNoticeList(Map<String, String> map) throws Exception;
	 PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
