package com.spring.shop.gallery;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.notice.Notice;

@Controller
class GalleryController {

	@Autowired
	GalleryDAO gd;

	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String gallery(HttpServletRequest req) {
		req.setAttribute("content", "gallery.jsp");
		return "home";
	}

	@RequestMapping(value = "/gallery/writeGallery", method = RequestMethod.GET)
	public String writeGallery(HttpServletRequest req) {
		
		try {
			req.setAttribute("one", gd.selectOne(req));
			
		} catch (Exception e) {
			req.setAttribute("content", "galleryWrite.jsp");

			return "home";
		}
		
		req.setAttribute("content", "galleryWrite.jsp");
		return "home";
	}

	@RequestMapping(value = "/gallery/writeGo", method = RequestMethod.POST)
	public String writeGo(Gallery n, HttpServletRequest req) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		
		String mode = mr.getParameter("MODE");
		int rst = 0;
		if (mode.equals("ADD")) {
			rst = gd.writeGallery(mr, n);
			if (rst > 0) {
				/*req.setAttribute("MSG", "�۾��� ����"); */
			} else {
				req.setAttribute("MSG", "�۾��� ����");
			}

		} else {
			// ����
			rst = gd.updateOne(mr, n);
			if (rst > 0) {
				/*  req.setAttribute("MSG", "���� ����"); */
			} else {
				req.setAttribute("MSG", "���� ����");
			}
		}

		req.setAttribute("content", "gallery.jsp");

		return "home";
	}

	@RequestMapping(value = "/getGalleryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getGalleryList(HttpServletRequest req) {

		return gd.getGalleryList(req);
	}

	@RequestMapping(value = "/gallery/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest req) {
		gd.deleteOne(req);
		req.setAttribute("content", "gallery.jsp");
		return "home";
	}
	
	@RequestMapping(value = "/gallery/deleteImg", method = RequestMethod.GET)
	public String deleteImg(HttpServletRequest req) {
		
		
		String name = req.getParameter("saved_file_name");
		
		System.out.println("control" + name );
		gd.deleteImg(req);
		req.setAttribute("content", "gallery.jsp");
		return "home";
	}
	
	
	
}