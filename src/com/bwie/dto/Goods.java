package com.bwie.dto;

public class Goods {

	private int gid;
	
	private String gname;
	
	private int price;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Goods(int gid) {
		this.gid = gid;
	}
	
	public Goods() {
		
	}
	
}
