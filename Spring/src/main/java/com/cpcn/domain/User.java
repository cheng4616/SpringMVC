package com.cpcn.domain;

import java.io.Serializable;

public class User implements Serializable {
	private String username;

	private String password;

	private static final long serialVersionUID = 1L;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append(", username=").append(username);
		sb.append(", password=").append(password);
		sb.append("]");
		return sb.toString();
	}
}