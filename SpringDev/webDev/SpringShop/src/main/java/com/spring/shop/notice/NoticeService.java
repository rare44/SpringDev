package com.spring.shop.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.Page;

@Service
public class NoticeService {
	@Autowired
	NoticeDAO nDAO;

	@Autowired
	Page pg;

	@Autowired
	private PlatformTransactionManager transactionManager;

	public int writeNotice(Notice n, MultipartHttpServletRequest mr) {
		// Ʈ������ó�� >> ���������� �۾������� �ϳ��� �۾����� ���� ��
		String path = mr.getSession().getServletContext().getRealPath("resources/file");
		Map<String, Object> param = new HashMap<String, Object>();
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());
		File saveDir = new File(path);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		MultipartFile f = mr.getFile("file");
		String name = f.getOriginalFilename();
		long size = f.getSize();
		String savedname = "";

		try {
			nDAO.writeNotice(n);
			if (!name.isBlank()) {
				try {
					
					File destination = File.createTempFile("F_" + System.currentTimeMillis(),
							name.substring(name.lastIndexOf(".")), saveDir);
					savedname = destination.getName();
					FileCopyUtils.copy(f.getInputStream(), new FileOutputStream(destination));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return 0;
				}
				
				param.put("savedfilename", savedname);
				param.put("filename", name);
				param.put("size", size);
				param.put("boardid", n.getNi_no());

				nDAO.insertAttach(param);
			}
			transactionManager.commit(status);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			File delFile = new File(path + "/" + savedname);
			delFile.delete();
			transactionManager.rollback(status);
			return 0;
		}

		// ���Ͼ��ε�, �������� ����
		// �����, ������
		// ������>> �������� ��θ� ���� �˰�, ������ �ۿ� ���� ����� ���� ��
		// �����>> �������� ��θ� ���� �� ��

		// realpath >> webapp ����

		// �������� �����ϰ� db�� �̸��� ����
		// file_name, saved_file_name, file_size �ʿ�

		// saved_file_name >> img.jpg �����ؼ� �̸��� �ٲٰ� �ٽ� �޸𸮿� �÷�����

		// ���������ϰ� notice_info�� insert�ϰ� �� key�� �޾Ƽ� board_attach�� insert ����

	}

	public Map<String, Object> getNoticeList(HttpServletRequest req) {
		// TODO Auto-generated method stub
		// totalCnt
		// pagePerCnt
		// CurPage
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		param.put("searchType", searchType);
		param.put("keyword", keyword);
		int totalCnt = nDAO.getTotalCnt(param);
		int pagePerCnt = Integer.parseInt(req.getParameter("pagePerCnt"));
		int curPage = Integer.parseInt(req.getParameter("curPage"));

		param.putAll(pg.generatePagingParam(totalCnt, pagePerCnt, curPage));

		List<Notice> list = nDAO.getList(param);
		result.put("list", list);
		result.put("paging", param);
		return result;
	}

	public Notice selectOne(HttpServletRequest req) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(req.getParameter("ni_no"));
		return nDAO.selectOne(no);
	}

	public int updateOne(Notice n) {
		// TODO Auto-generated method stub
		return nDAO.updateOne(n);
	}

	public int deleteOne(HttpServletRequest req) {
		//notice_info, boardattach, ���ϻ��� 3��
		//insert���� >> notice_info >> ���Ͼ��ε� >> board
		//delete���� >> board >> notice >> ���� ����
		//
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		int no = Integer.parseInt(req.getParameter("ni_no"));
		String savedFileName = null;
		try {
			Notice noti = nDAO.selectOne(no);
			savedFileName = noti.getSaved_file_name();
			System.out.println(savedFileName);
			if(savedFileName != null) {
				nDAO.deleteAttach(noti);
			}
			
			nDAO.deleteOne(noti);
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
			return 0;
		}
		if(savedFileName != null) {
			try {
				File delFile = new File(path+"/"+savedFileName);
				delFile.delete();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return 0;
			}
			
			
		}
		
		return 1;
	}

	public Boolean downservice(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String realName = req.getParameter("fileName");
		String savedName= req.getParameter("savedFileName");
		if(realName == null || realName.equals("")||savedName == null|| savedName.equals("")) {
			return false;
		}
		
		//contentType : http header
		res.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		try {
			//
			res.setHeader("Content-Disposition", "attachment;fileName=\"" + URLEncoder.encode(realName, "UTF-8") + "\";");
			res.setHeader("Content-Transfer-Encoding", "binary");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//������ ���� �ٿ�ε�
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path + "/" + savedName));
			res.getOutputStream().write(fileByte);
			res.getOutputStream().flush();
			res.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

}
