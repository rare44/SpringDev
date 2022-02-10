package com.spring.shop.login;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class LoginController {
	
	@Autowired
	MemberDAO mDAO;
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		req.setAttribute("content", "login.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/joinMember", method = RequestMethod.GET)
	public String join(HttpServletRequest req) {
		if(req.getSession().getAttribute("loginMember") != null) {
			Member loginMember = (Member)req.getSession().getAttribute("loginMember");
			String addr = loginMember.getMi_address();
			String[] addr1 = addr.split(",");
			req.getSession().setAttribute("addr1", addr1);
			
		
		}
		req.setAttribute("content", "join.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/joinGo", method = RequestMethod.POST)
	public String joingo(Member m, HttpServletRequest req) {
		int result = mDAO.joinMember(m, req);
		if(req.getSession().getAttribute("loginMember") == null) {
			if(result > 0) {
				req.setAttribute("MSG", "ȸ�����Լ���");
			}else {
				req.setAttribute("MSG", "ȸ�����Խ���");
			}
			req.setAttribute("content", "login.jsp");
		}else {
			//��������
			
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/checkID", method = RequestMethod.POST)
	@ResponseBody
	public String checkID(HttpServletRequest req) {
		System.out.println(req.getParameter("mi_id"));
		int rst = mDAO.checkID(req);
		if(rst>0) {
			return "Y";
		}else {
			return "N";
		}
		
	}
	
	@RequestMapping(value="/loginGo", method = RequestMethod.POST)
	public String loginGo(Member m, HttpServletRequest req) {
		Member loginMember = mDAO.getMemberByID(m);
		if(loginMember != null) {
			//�α��μ����ÿ� ��������
			//����, ��Ű
			//
			req.getSession().setAttribute("loginMember", loginMember);
			req.setAttribute("content", "main.jsp");
			req.setAttribute("MSG", "�α��ο� �����ϼ̽��ϴ�.");
		}else {
			req.setAttribute("content", "login.jsp");
			req.setAttribute("MSG", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		req.setAttribute("MSG", "LOG OUT");
		req.setAttribute("content", "main.jsp");
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
