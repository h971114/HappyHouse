package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.StoreInfoDto;
import com.ssafy.happyhouse.model.dao.StoreInfoDao;
import com.ssafy.util.PageNavigation;

@Service
public class StoreInfoServiceImpl implements StoreInfoService {
	
	@Autowired
	private  StoreInfoDao dao;
	
	@Override
	public List<StoreInfoDto> getStoreInfo(String dong, Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		int currentPage = Integer.parseInt(map.get("pg"));
		//int sizePerPage = Integer.parseInt(map.get("10"));
		int start = (currentPage - 1) * 10;
		param.put("start", start);
		param.put("spp", 10);
		return dao.getStoreInfo(dong,param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
	//	int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = dao.makePageNavigation(map);
				//sqlSession.getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / 10 + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

}
