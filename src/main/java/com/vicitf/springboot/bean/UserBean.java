package com.vicitf.springboot.bean;

public class UserBean {
	private Long id;
	private String username;
	private String avatar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", avatar="
				+ avatar + "]";
	}
	
}
