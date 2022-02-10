package com.spring.shop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Page {
	public Map<String, Object> generatePagingParam(float totalCnt, float pagePerCnt, int curPage){
		Map<String, Object> pageValue = new HashMap<String, Object>();
		//총 몇개의 페이지가 나올건지
		int pageCount = (int)Math.ceil(totalCnt/pagePerCnt);
		
		
		pageValue.put("off", pagePerCnt * (curPage - 1));
		pageValue.put("li", pagePerCnt * (curPage - 1) + pagePerCnt);
		
		pageValue.put("CUR_PAGE", curPage);
		pageValue.put("PAGE_CNT", pageCount);
		pageValue.put("TOTAL_CNT", totalCnt);
		//pagePerCnt * (curPage - 1) + pagePerCnt = limit
		//총 게시글 갯수
		//한페이지당 몇개 = limit
		//offset, limit
		//내가 현재 보고있는 페이지
		//
		
		//현재 페이지1이고, pagePerCnt = 2, total=10
		
		
		
		return pageValue;
	}
}
