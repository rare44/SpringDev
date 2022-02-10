package com.spring.shop.gallery;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.notice.Notice;

public interface GalleryMapper {
	public abstract int writeGallery(Gallery g);

	

	public abstract int getTotalCnt(Map<String, Object> param);



	public abstract List<Gallery> getGalleryList(Map<String, Object> param);



	public abstract int updateOne(Gallery n);



	public abstract int detailWrite(Gallery g);



	public abstract int deleteOne(int no);



	public abstract List<Gallery> selectOne(int no);



	public abstract int insertAttach(List<Map<String, Object>> list);



	public abstract int deleteImg(String name);



	public abstract int deleteAttach(int imgNo);


}
