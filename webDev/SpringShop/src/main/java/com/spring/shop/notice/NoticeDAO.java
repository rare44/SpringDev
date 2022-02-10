package com.spring.shop.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	SqlSession ss;

	public int writeNotice(Notice n) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).writeNotice(n);
	}

	public List<Notice> getList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).getList(param);
	}

	public Notice selectOne(int no) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).selectOne(no);
	}

	public int updateOne(Notice n) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).updateOne(n);
	}

	public int deleteOne(Notice n) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).deleteOne(n);
	}

	public int getTotalCnt(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).getTotalCnt(param);
	}

	public int insertAttach(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).insertAttach(param);
	}

	public int deleteAttach(Notice noti) {
		// TODO Auto-generated method stub
		return ss.getMapper(NoticeMapper.class).deleteAttach(noti);
	}
	
}
