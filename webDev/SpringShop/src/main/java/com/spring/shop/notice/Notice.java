package com.spring.shop.notice;

public class Notice {
	private int ni_no;
	private String ni_title;
	private String ni_content;
	private String ni_writer;
	private String ni_insdate;
	private String saved_file_name;
	private String file_name;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public int getNi_no() {
		return ni_no;
	}

	public String getSaved_file_name() {
		return saved_file_name;
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

	public void setNi_no(int ni_no) {
		this.ni_no = ni_no;
	}

	public String getNi_title() {
		return ni_title;
	}

	public void setNi_title(String ni_title) {
		this.ni_title = ni_title;
	}

	public String getNi_content() {
		return ni_content;
	}

	public void setNi_content(String ni_content) {
		this.ni_content = ni_content;
	}

	public String getNi_writer() {
		return ni_writer;
	}

	public void setNi_writer(String ni_writer) {
		this.ni_writer = ni_writer;
	}

	public String getNi_insdate() {
		return ni_insdate;
	}

	public void setNi_insdate(String ni_insdate) {
		this.ni_insdate = ni_insdate;
	}

	public Notice(int ni_no, String ni_title, String ni_content, String ni_writer, String ni_insdate,
			String saved_file_name, String file_name) {
		super();
		this.ni_no = ni_no;
		this.ni_title = ni_title;
		this.ni_content = ni_content;
		this.ni_writer = ni_writer;
		this.ni_insdate = ni_insdate;
		this.saved_file_name = saved_file_name;
		this.file_name = file_name;
	}

	
	
	
	
	
	
	
	
	
}
