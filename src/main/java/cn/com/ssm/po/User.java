package cn.com.ssm.po;

import java.util.Date;

public class User {
	private Integer id;
	private String userName;
	private Date birtyDay;
	private String sex;
	private String address;
	private String picPath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirtyDay() {
		return birtyDay;
	}

	public void setBirtyDay(Date birtyDay) {
		this.birtyDay = birtyDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", birtyDay=" + birtyDay +
				", sex='" + sex + '\'' +
				", address='" + address + '\'' +
				", picPath='" + picPath + '\'' +
				'}';
	}
}
