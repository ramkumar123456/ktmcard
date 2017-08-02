package com.ktmcard.home.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.home.model.UserRole;
import com.ktmcard.home.model.Userslist;

public interface SecurityService {


	@SuppressWarnings("rawtypes")
	public List getSearchDetails(LoginBean login);
	
	public UserDetails loadUserByUsername(final String username);
	
	Userslist getUserDetails(String id);
	
	public List<UserRole> loadUserRoleByUsername(String username);
	
	@SuppressWarnings("rawtypes")
	public List searchUser(LoginBean login);

}
