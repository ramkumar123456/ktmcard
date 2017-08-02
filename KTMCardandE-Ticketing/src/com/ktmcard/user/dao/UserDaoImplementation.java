package com.ktmcard.user.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;

@Repository("UserDao")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UserDaoImplementation implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HttpServletRequest req;

	@SuppressWarnings("unchecked")
	public List<RegistrationModel> loginlist(String username, String password) {
		return sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"' and password='"+password+"'").list();
	}
	
	

	public void changepassword(String username, String npd, String cnpd) {
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+npd+"',conformpassword='"+cnpd+"' where username='"+username+"'").executeUpdate();
		
	}
	
	
	//@ram user dao

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void saveApplyCard(ApplyCardModel acm) {
		System.out.println("enter into saveApplyCard in user dao imple");
		 sessionFactory.getCurrentSession().save(acm);
		 
		 System.out.println("66666666666666666666666");
		 
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void saveUserRechargetxmodel(UserRechargeTrasactionsModel urtm) {
		System.out.println("enter into saveUserRechargetxmodel in user dao imple");
		 sessionFactory.getCurrentSession().save(urtm);
	}

	@Override
	public List checkusercard(String cardid,String username,String password) {
	System.out.println("enter into checkusercard in user dao imple");
	String query="FROM ApplyCardModel WHERE CARDID='"+cardid+"' and PASSWORD='"+password+"'and USERNAME='"+username+"' and STATUS='Approved'";
	   System.out.println(".......2222222222222.............");
	   List li=sessionFactory.getCurrentSession().createQuery(query).list();
		return li;
	}

	@Override
	public List getbalance(String rechcard) {
		System.out.println("enter into getbalance in user dao imple");
		String query="FROM ApplyCardModel WHERE CARDID='"+rechcard+"'";
		 System.out.println(".......2222222222222.............");
		   List li=sessionFactory.getCurrentSession().createQuery(query).list();
			return li;
		
	}

	@Override
	public void updatebalance(int updatedbalance,String rechcard) {
		System.out.println("enter into updatebalance in user dao imple");
		System.out.println(".......2222222222222.............");
		 String balance=Integer.toString(updatedbalance);
		String query="UPDATE ApplyCardModel SET BALANCE='"+balance+"' WHERE CARDID='"+rechcard+"'";
		sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
		 
	}

	@Override
	public List listoftransactions(String username, String password) {
		System.out.println("enter into getbalance in user dao imple");
		String query="FROM UserRechargeTrasactionsModel WHERE USERNAME='"+username+"' and PASSWORD='"+password+"'";
		 System.out.println(".......2222222222222.............");
		   List li=sessionFactory.getCurrentSession().createQuery(query).list();
		return li;
	}

	@Override
	public void updatecardbalance(String inttopup, String cardid) {
		System.out.println("enter into updatecardbalance in user dao imple");
		String query="UPDATE ApplyCardModel SET BALANCE='"+inttopup+"' WHERE CARDID='"+cardid+"'";
		sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
	}

	@Override
	public List listofuserapplycards(String username, String password) {
		System.out.println("enter into listofuserapplycards in user dao imple");
		String query="FROM ApplyCardModel WHERE PASSWORD='"+password+"'and USERNAME='"+username+"'";
		   System.out.println(".......2222222222222.............");
		   List li=sessionFactory.getCurrentSession().createQuery(query).list();
			return li;
		
	}



	public void updateuserprofile(RegistrationModel rm) {
		System.out.println("enter dao impln admin");
		System.out.println(rm.getId());
		sessionFactory.getCurrentSession().saveOrUpdate(rm);		
	}



	@Override
	public void changepasswordlist(String username, String npd) {
		sessionFactory.getCurrentSession().createQuery("update Userslist set password='"+npd+"' where username='"+username+"'").executeUpdate();
		
	}
	
}
