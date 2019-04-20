package com.springboot.model;

public class PlatformSessionModel<T> {
	private T id;
	private String username;
	private int expireTime;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
}
