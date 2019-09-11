package com.woniuxy.springboot.po;

import java.util.Date;

public class Dep {
	private Integer did;
	private String dname;
	public Dep() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dep(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dep [did=" + did + ", dname=" + dname + "]";
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

}
