package com.ktmcard.home.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.home.dao.SecurityDao;
import com.ktmcard.home.model.UserRole;
import com.ktmcard.home.model.Userslist;

@Service("SecurityService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SecurityServiceImpl implements SecurityService,UserDetailsService{

	@Autowired
	private SecurityDao securityDao;
	
	@SuppressWarnings("rawtypes")
	public List getSearchDetails(LoginBean login){
		System.out.println("getSearchDetails in service impllllllllllllllllllllllll");
		return(List) securityDao.getSearchDetails(login);
	}
	
	@SuppressWarnings("rawtypes")
	public List searchUser(LoginBean login){
		System.out.println("searchUser in service impllllllllllllllllllllllll");
		return(List) securityDao.searchUser(login);
	}

	public Userslist getUserDetails(String id) {
		System.out.println("return null in service imppppppppppppppp --------- getUserDetails");
		return  null;
	}
    
	public List<UserRole> loadUserRoleByUsername(String username) {
		System.out.println("return null in service imp-------------****************** ");
		return null;
	}	
		
	
//............... spring security.........................
		
	
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		
		System.out.println("### # MyUserDetailsService : loadUserByUsername() :START: username:" + username + ":");
		
		Userslist usersListModel = securityDao.findByUserName(username);
		
		System.out.println("password:" + usersListModel.getPassword() + ":");
				
        Set<UserRole> userRolesSet = new HashSet<UserRole>(securityDao.loadUserRoleByUsername(username));
		
		System.out.println("userRolesSet : userRolesSetuserRolesSetuserRolesSetuserRolesSet:" + userRolesSet.size());
				
		/*List<GrantedAuthority> authorities = buildUserAuthority(usersListModel
				.getRole());*/
		
		List<GrantedAuthority> authorities = buildUserAuthority(userRolesSet);
		
		@SuppressWarnings("unused")
		GrantedAuthority grantedAuthority = (GrantedAuthority)authorities.get(0);
		
		System.out.println("### # MyUserDetailsService loadUserByUsername() : END");
				
		User securedUser = buildUserForAuthentication(usersListModel, authorities); 
		
		System.out.println("securedUser:" + securedUser + ":");
		
		System.out.println("suser securedUser.getUsername()2: " + securedUser.getUsername());
		
		System.out.println("suser securedUser.getPassword()2: " + securedUser.getPassword());
		
		System.out.println("suser securedUser.getAuthorities()2.size():" + securedUser.getAuthorities().size());
		
		System.out.println("suser :securedUser.getAuthorities().iterator().next().getAuthority():" 
				+ 
				securedUser.getAuthorities().iterator().next().getAuthority() + ":");
		System.out.println("securedUser.isEnabled():" + securedUser.isEnabled());
		return securedUser;

	}
	
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	
	
	private User buildUserForAuthentication(Userslist li,
			List<GrantedAuthority> authorities) {
		//System.out.println("### ## MyUserDetailsService buildUserForAuthentication() :START END:");
		return new User(li.getUsername(), li.getPassword(),
				li.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) 
	{
		//System.out.println("### ### MyUserDetailsService buildUserAuthority() : START");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		//System.out.println("Number of roles for this user3 : " + setAuths.size());
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);
		
		//System.out.println("Number of roles for this user3 : " + Result.size());
		
		//System.out.println("### ### MyUserDetailsService buildUserAuthority() : END");
		
		return Result;
	}
		
}

