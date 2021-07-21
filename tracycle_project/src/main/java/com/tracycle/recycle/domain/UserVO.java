package com.tracycle.recycle.domain;

public class UserVO {
	private String userId;
	private String password;
	private String nickName;
	private String address;
	
	
	public UserVO() { }
	
	public UserVO(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public UserVO(String userId, String password, String nickName, String address) {
		super();
		this.userId = userId;
		this.password = password;
		this.nickName = nickName;
		this.address = address;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", password=" + password + ", nickName=" + nickName + ", address=" + address
				+ "]";
	}
	
	
	
}
