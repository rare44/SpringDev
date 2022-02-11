package com.spring.shop.notice;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {
	public abstract int writeNotice(Notice n);

	public abstract List<Notice> getList(Map<String, Object> param);

	public abstract Notice selectOne(int no);

	public abstract int updateOne(Notice n);

	public abstract int deleteOne(Notice n);

	public abstract int getTotalCnt(Map<String, Object> param);

	public abstract int insertAttach(Map<String, Object> param);

	public abstract int deleteAttach(Notice noti);
	
	
}
