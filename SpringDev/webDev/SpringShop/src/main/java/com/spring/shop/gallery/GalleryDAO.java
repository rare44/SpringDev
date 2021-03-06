package com.spring.shop.gallery;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.Page;
import com.spring.shop.notice.Notice;
import com.spring.shop.notice.NoticeMapper;

@Service
public class GalleryDAO {
	@Autowired
	SqlSession ss;

	@Autowired
	Page pg;

	@Autowired
	private PlatformTransactionManager transactionManager;

	public int writeGallery(MultipartHttpServletRequest mr, Gallery g) {
		// TODO Auto-generated method stub
		// 트랜젝션처리 >> 여러가지의 작업단위를 하나의 작업으로 묶는 것
				String path = mr.getSession().getServletContext().getRealPath("resources/file");
				
				List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
				TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());
				File saveDir = new File(path);
				if (!saveDir.exists()) {
					saveDir.mkdirs();
				}
				List<MultipartFile> files = mr.getFiles("files");
					String name = null;
					long size = 0;
					String savedname = "";
				try { //트랜잭션의 try
					ss.getMapper(GalleryMapper.class).writeGallery(g);
					for(MultipartFile f : files) {
						Map<String, Object> param = new HashMap<String, Object>();
						size= f.getSize();
						name = f.getOriginalFilename();
						System.out.println(name);
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
							param.put("boardid", g.getGi_no());
							list.add(param);
							int d = ss.getMapper(GalleryMapper.class).insertAttach(list);
						}		
					}


			
					transactionManager.commit(status);
					return 1;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					File delFile = new File(path + "/" + savedname);
					delFile.delete();
					transactionManager.rollback(status);
					return 0;
				}
				
					
					
		
	}

	public Map<String, Object> getGalleryList(HttpServletRequest req) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		param.put("searchType", searchType);
		param.put("keyword", keyword);
		int totalCnt = ss.getMapper(GalleryMapper.class).getTotalCnt(param);
		int pagePerCnt = Integer.parseInt(req.getParameter("pagePerCnt"));
		int curPage = Integer.parseInt(req.getParameter("curPage"));

		param.putAll(pg.generatePagingParam(totalCnt, pagePerCnt, curPage));

		List<Gallery> list = ss.getMapper(GalleryMapper.class).getGalleryList(param);
		result.put("list", list);
		result.put("paging", param);
		return result;
	}

	public int updateOne(MultipartHttpServletRequest mr, Gallery g) {
		// TODO Auto-generated method stub
		String path = mr.getSession().getServletContext().getRealPath("resources/file");
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionAttribute());
		File saveDir = new File(path);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		List<MultipartFile> files = mr.getFiles("files");
			String name = null;
			long size = 0;
			String savedname = "";
		try { //트랜잭션의 try
			ss.getMapper(GalleryMapper.class).updateOne(g);
			for(MultipartFile f : files) {
				Map<String, Object> param = new HashMap<String, Object>();
				size= f.getSize();
				name = f.getOriginalFilename();
				System.out.println(name);
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
					param.put("boardid", g.getGi_no());
					list.add(param);
				}
			}
			int imgNo = g.getGi_no(); 
			//int d = ss.getMapper(GalleryMapper.class).deleteAttach(imgNo);
			int e = ss.getMapper(GalleryMapper.class).insertAttach(list);
	
			transactionManager.commit(status);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			File delFile = new File(path + "/" + savedname);
			delFile.delete();
			transactionManager.rollback(status);
			return 0;
		}
	}

	public int detailWrite(Gallery g, MultipartHttpServletRequest mr) {
		// TODO Auto-generated method stub
		return ss.getMapper(GalleryMapper.class).detailWrite(g);
	}

	public int deleteOne(HttpServletRequest req) {

		int no = Integer.parseInt(req.getParameter("gi_no"));
		return ss.getMapper(GalleryMapper.class).deleteOne(no);
	}

	public List<Gallery> selectOne(HttpServletRequest req) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(req.getParameter("gi_no"));
		List<Gallery> list = ss.getMapper(GalleryMapper.class).selectOne(no);

		return list;
	}

	public int deleteImg(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String name = req.getParameter("saved_file_name");
	
		System.out.println("dao" + name);
		return ss.getMapper(GalleryMapper.class).deleteImg(name);
	}

}
