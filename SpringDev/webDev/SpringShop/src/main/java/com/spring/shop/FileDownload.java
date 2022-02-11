package com.spring.shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownload extends AbstractView{
	public void Download() {
		setContentType("aplication/download; utf-8");
		
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		File file = (File) model.get("downloadFile");
		System.out.println("path : " + file.getPath());
		System.out.println("name : " + file.getName());
		String fileName = null;
		String realName = request.getParameter("file_name");
		if(request.getHeader("User-Agent").indexOf("MISE") > 1) {
			fileName = URLEncoder.encode(realName, "utf-8");
			
		}else {
			fileName = new String(realName.getBytes("utf-8"),"ISO-8859-1");
		}
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally { 
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		out.flush();
	}
}
