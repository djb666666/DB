package com.cy.pj.sys.entity;

public class SysDrug {
	private Integer id;
	private String drugname;
	private Integer account;
	private double price;
	private String local;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	@Override
	public String toString() {
		return "SysDrug [id=" + id + ", drugname=" + drugname + ", account=" + account + ", price=" + price + ", local="
				+ local + "]";
	}
	
}
