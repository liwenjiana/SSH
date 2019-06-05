package com.bwie.dto;

import java.util.HashSet;
import java.util.Set;

public class Order {

	private int oid;
	
	private String oname;
	
	private String otime;
	
	private int payType;
	
	private int status;
	
	private int totalPrice;
	
	private Set<Goods> goods = new HashSet<Goods>();

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOtime() {
		return otime;
	}

	public void setOtime(String otime) {
		this.otime = otime;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public int getTotalPrice() {
		for (Goods g : goods) {
			totalPrice += g.getPrice();
		}
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Order(int oid) {
		super();
		this.oid = oid;
	}
	
	public Order() {
	}
}
