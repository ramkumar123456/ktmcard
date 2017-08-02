package com.ktmcard.home.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.home.model.UserRole;
import com.ktmcard.home.model.Userslist;

@Repository("securityDao")
public class SecurityDaoIMmpl implements SecurityDao{
	@Autowired
	private SessionFactory sf;	
		
	@SuppressWarnings("rawtypes")
	public List getSearchDetails(LoginBean login)
	{
		System.out.println("getSearchDetails in dao imp:::::::::::::::::::");
		String us=login.getUsername();
		String pa=login.getPassword();
		
		System.out.println("hii  "+us);
		System.out.println("hii  "+pa);
		
		List userslist=sf.getCurrentSession().createQuery("from Userslist where username='"+us+"' and password='"+pa+"'").list();
		return userslist;				
	}
	
	@SuppressWarnings("rawtypes")
	public List searchUser(LoginBean login)
	{
		System.out.println("searchuser in dao imp::::::::::::::::");
		return sf.getCurrentSession().createQuery("from Userslist where username='"+login.getUsername()+"'").list();
	}
			
	@SuppressWarnings("unchecked")
	public Userslist findByUserName(String username)
	{
		System.out.println("findByUserName in dao imp::::::::::::::::");
		//Userslist userslist=new Userslist();
		List<Userslist> li=new ArrayList<Userslist>();
		li=sf.getCurrentSession().createQuery("from Userslist where username=?").setParameter(0,username).list();
		if(li.size()>0){
			
			System.out.println("enter into if of security dao imp::::::::::::::");
			
			return li.get(0);			
		}
		return null;		
	}

	@SuppressWarnings("unchecked")
	public List<UserRole> loadUserRoleByUsername(String username){
		System.out.println("List<UserRole> in dao imp::::::::::::::::");
		return (List<UserRole>) sf.getCurrentSession().createQuery("from UserRole where username=?").setParameter(0,username).list();
	}
	
	

}
