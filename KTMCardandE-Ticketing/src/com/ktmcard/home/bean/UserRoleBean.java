package com.ktmcard.home.bean;

import com.ktmcard.home.model.Userslist;

public class UserRoleBean {

	private String userroleid;
	private String role;
	private Userslist usersListModel;
	
	
	
	public String getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(String userroleid) {
		this.userroleid = userroleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Userslist getUsersListModel() {
		return usersListModel;
	}
	public void setUsersListModel(Userslist usersListModel) {
		this.usersListModel = usersListModel;
	}
	
}

