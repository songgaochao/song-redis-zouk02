package com.songgc.redis;

import java.io.Serializable;

public class User implements Serializable{

	//重写hashCode()
	 public int hashCode() {
		
		 return id;
		 
	}
	 //重写equals(Object obj)
	 public boolean equals(Object obj) {
		
		 return false;
		 
	 }
	private Integer id;//id
	private String name;//姓名
	private String sex;//性别
	private String phone;//手机
	private String mail;//邮箱
	private Integer shengr;//生日
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getShengr() {
		return shengr;
	}
	public void setShengr(Integer shengr) {
		this.shengr = shengr;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", mail=" + mail
				+ ", shengr=" + shengr + "]";
	}
	
	
	
}
