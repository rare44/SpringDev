package com.spring.shop.notice;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
class NoticeController {
	
	@Autowired
	NoticeService ns;
	
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(HttpServletRequest req) {
		
	
		req.setAttribute("content", "notice.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/notice/write", method = RequestMethod.GET)
	public String write(HttpServletRequest req) {
		req.setAttribute("content", "write.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/notice/writeGo", method = RequestMethod.POST)
	public String writeGo(Notice n, HttpServletRequest req) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		String mode = mr.getParameter("MODE");
		int rst = 0;
		if(mode.equals("ADD")) {
			rst = ns.writeNotice(n, mr);
			if(rst > 0) {
				req.setAttribute("MSG", "글쓰기 성공");
			}else {
				req.setAttribute("MSG", "글쓰기 실패");
			}
		
		}else {
			//업뎃
			rst = ns.updateOne(n);
			if(rst > 0) {
				req.setAttribute("MSG", "수정 성공");
			}else {
				req.setAttribute("MSG", "수정 실패");
			}
		}
		
		req.setAttribute("content", "notice.jsp");
		
		return "home";
	}
	
	@RequestMapping(value = "/notice/detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest req) {
		
		Notice one = ns.selectOne(req);
		req.setAttribute("one", one);
		req.setAttribute("content", "write.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/notice/delete", method = RequestMethod.GET)
	public String delete(Notice n, HttpServletRequest req) {
		int rst = 0;
		ns.deleteOne(req);
		req.setAttribute("content", "notice.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/getNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNoticeList(Notice n, HttpServletRequest req) {
		return ns.getNoticeList(req);
	}
	
	@RequestMapping(value = "/notice/fileDownload", method = RequestMethod.GET)
	public ModelAndView download(HttpServletRequest req, HttpServletResponse res) {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		File file = new File(path + "/" +req.getParameter("saved_file_name"));
		return new ModelAndView("download","downloadFile", file);
	}
	
	
	
	
	
	
	
	
}
