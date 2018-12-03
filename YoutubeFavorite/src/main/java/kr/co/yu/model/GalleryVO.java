package kr.co.yu.model;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVO {
	private int g_no;
	private String g_title;
	private MultipartFile img;
	private String g_path;
	private String g_regdate;
	
	
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getG_path() {
		return g_path;
	}
	public void setG_path(String g_path) {
		this.g_path = g_path;
	}
	public String getG_regdate() {
		return g_regdate;
	}
	public void setG_regdate(String g_regdate) {
		this.g_regdate = g_regdate;
	}
	
	
	
	
}
