package com.bdi.sp.vo;

import org.apache.ibatis.type.Alias;

@Alias("japan")
public class Japan {

	private Integer jpnum;
	private String jpname;
	private String jpdesc;
	
	public Japan() {}
	public Japan(Integer jpnum, String jpname, String jpdesc) {
		super();
		this.jpnum = jpnum;
		this.jpname = jpname;
		this.jpdesc = jpdesc;
	}
	public Integer getJpnum() {
		return jpnum;
	}
	public void setJpnum(Integer jpnum) {
		this.jpnum = jpnum;
	}
	public String getJpname() {
		return jpname;
	}
	public void setJpname(String jpname) {
		this.jpname = jpname;
	}
	public String getJpdesc() {
		return jpdesc;
	}
	public void setJpdesc(String jpdesc) {
		this.jpdesc = jpdesc;
	}
	@Override
	public String toString() {
		return "Japan [jpnum=" + jpnum + ", jpname=" + jpname + ", jpdesc=" + jpdesc + "]";
	}
	
	
}
