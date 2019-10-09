package com.tmc.beans;

public class User {

	String userName;
	String passWord;
	String mobileNo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public User() {
		super();
	}

	public User(String userName, String passWord, String mobileNo) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.mobileNo = mobileNo;
	}

}
