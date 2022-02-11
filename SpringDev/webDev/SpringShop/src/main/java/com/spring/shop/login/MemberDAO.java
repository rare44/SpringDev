package com.spring.shop.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	
	@Autowired
	SqlSession ss;
	
	
	public int joinMember(Member m, HttpServletRequest req) {
		//값들을 가공해서 여기서 DB통신
		//ss가지고 통신

		String addr = req.getParameter("addr") + "!" + req.getParameter("detailAddr") + req.getParameter("postCode");
		m.setMi_address(addr);
		return ss.getMapper(MemberMapper.class).joinMember(m);
	}
	
	public int checkID(HttpServletRequest req) {
		String id = req.getParameter("mi_id");
		
		return ss.getMapper(MemberMapper.class).checkID(id);
	}
	
	public Member getMemberByID(Member m) {
		return ss.getMapper(MemberMapper.class).getMemberByID(m);
	}
}
