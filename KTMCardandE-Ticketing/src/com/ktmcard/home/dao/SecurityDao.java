package com.ktmcard.home.dao;

import java.util.List;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.home.model.UserRole;
import com.ktmcard.home.model.Userslist;

public interface SecurityDao {
	
	@SuppressWarnings("rawtypes")
	public List getSearchDetails(LoginBean login);
	
	public Userslist findByUserName(String username);
	
	public List<UserRole> loadUserRoleByUsername(String username);
	
    @SuppressWarnings("rawtypes")
	public List searchUser(LoginBean login);
}
