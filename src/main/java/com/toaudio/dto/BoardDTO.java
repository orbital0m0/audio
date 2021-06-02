package com.toaudio.dto;

public class BoardDTO {
	private int codenum;
	private String title;
	private String m_id;
	private String realpath;
	private String update_time;
	
	public int getCodenum() {
		return codenum;
	}
	public void setCodenum(int codenum) {
		this.codenum = codenum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [codenum=" + codenum + ", title=" + title + ", m_id=" + m_id + ", realpath=" + realpath
				+ ", update_time=" + update_time + "]";
	}
	
}
