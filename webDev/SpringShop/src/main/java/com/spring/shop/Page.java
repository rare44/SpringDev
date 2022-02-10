package com.spring.shop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Page {
	public Map<String, Object> generatePagingParam(float totalCnt, float pagePerCnt, int curPage){
		Map<String, Object> pageValue = new HashMap<String, Object>();
		//�� ��� �������� ���ð���
		int pageCount = (int)Math.ceil(totalCnt/pagePerCnt);
		
		
		pageValue.put("off", pagePerCnt * (curPage - 1));
		pageValue.put("li", pagePerCnt * (curPage - 1) + pagePerCnt);
		
		pageValue.put("CUR_PAGE", curPage);
		pageValue.put("PAGE_CNT", pageCount);
		pageValue.put("TOTAL_CNT", totalCnt);
		//pagePerCnt * (curPage - 1) + pagePerCnt = limit
		//�� �Խñ� ����
		//���������� � = limit
		//offset, limit
		//���� ���� �����ִ� ������
		//
		
		//���� ������1�̰�, pagePerCnt = 2, total=10
		
		
		
		return pageValue;
	}
}
