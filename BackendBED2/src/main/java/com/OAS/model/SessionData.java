package com.OAS.model;

public class SessionData {
	private int user_id;
	private String user_mailId;
	private String user_name;

	public SessionData() {

	}

	public SessionData(int user_id, String user_mailId, String user_name) {
		this.user_id = user_id;
		this.user_mailId = user_mailId;
		this.user_name = user_name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_mailId() {
		return user_mailId;
	}

	public void setUser_mailId(String user_mailId) {
		this.user_mailId = user_mailId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
