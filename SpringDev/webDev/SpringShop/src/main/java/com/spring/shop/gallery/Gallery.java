package com.spring.shop.gallery;

public class Gallery {
	private int gi_no;
	private String gi_title;
	private String gi_content;
	private String gi_writer;
	private String gi_insdate;
	private String saved_file_name;
	private String file_name;
	
	
	
	public String getSaved_file_name() {
		return saved_file_name;
	}


	public Gallery(int gi_no, String gi_title, String gi_content, String gi_writer, String gi_insdate,
			String saved_file_name, String file_name) {
		super();
		this.gi_no = gi_no;
		this.gi_title = gi_title;
		this.gi_content = gi_content;
		this.gi_writer = gi_writer;
		this.gi_insdate = gi_insdate;
		this.saved_file_name = saved_file_name;
		this.file_name = file_name;
	}


	public void setSaved_file_name(String saved_file_name) {
		this.saved_file_name = saved_file_name;
	}


	public String getFile_name() {
		return file_name;
	}


	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	
	public Gallery() {
		// TODO Auto-generated constructor stub
	}


	public int getGi_no() {
		return gi_no;
	}


	public void setGi_no(int gi_no) {
		this.gi_no = gi_no;
	}


	public String getGi_title() {
		return gi_title;
	}


	public void setGi_title(String gi_title) {
		this.gi_title = gi_title;
	}


	public String getGi_content() {
		return gi_content;
	}


	public void setGi_content(String gi_content) {
		this.gi_content = gi_content;
	}


	public String getGi_writer() {
		return gi_writer;
	}


	public void setGi_writer(String gi_writer) {
		this.gi_writer = gi_writer;
	}


	public String getGi_insdate() {
		return gi_insdate;
	}


	public void setGi_insdate(String gi_insdate) {
		this.gi_insdate = gi_insdate;
	}

	
}
