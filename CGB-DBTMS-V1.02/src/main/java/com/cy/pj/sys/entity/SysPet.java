package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysPet implements Serializable{
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8550739689789636072L;
	private Integer id;
	private String name;
	private String health;
	private Date createTime;
	private String gender;
	private String color;
	private Integer age;
	private Date modifiedTime;
	private int time;
	private String mastername;
	private String phone;
	private Integer volid;
	public Integer getVolid() {
		return volid;
	}
	public void setVolid(Integer volid) {
		this.volid = volid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getMastername() {
		return mastername;
	}
	public void setMastername(String mastername) {
		this.mastername = mastername;
	}
	@Override
	public String toString() {
		return "SysPet [id=" + id + ", name=" + name + ", health=" + health + ", createTime=" + createTime + ", gender="
				+ gender + ", color=" + color + ", age=" + age + ", modifiedTime=" + modifiedTime + ", time=" + time
				+ ", mastername=" + mastername + ", phone=" + phone + ", volid=" + volid + "]";
	}

	
	
}
