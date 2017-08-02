package com.ktmcard.counter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.TicketModel;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;
@Repository("DaoCounter")
public class DaoCounterImplementation implements DaoCounter{
	@Autowired
	 private SessionFactory sessionFactory;

	@Override
	public void counterChangePassword(Integer id, String newpassword,
			String confirmnewpwd) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("UPDATE CounterModel set password='"+newpassword+"',conformpassword='"+confirmnewpwd+"' where id='"+id+"'").executeUpdate();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CounterModel> loginlist(String un, String pwd) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM CounterModel where username='"+un+"'and password='"+pwd+"'").list();
	}

	@Override
	public void updateCounter(CounterModel cm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(cm);
	}

	@Override
	public void saveApplyCard(ApplyCardModel acm) {
	System.out.println("enter into saveApplyCard in dao implementation");
	sessionFactory.getCurrentSession().save(acm);
		
	}

	@Override
	public void updatecardbalance(String inttopup, String cardid) {
		 {
			System.out.println("enter into updatecardbalance in  dao counter imple");
			String query="UPDATE ApplyCardModel SET BALANCE='"+inttopup+"' WHERE CARDID='"+cardid+"'";
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
		}
		
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void saveUserRechargetxmodel(UserRechargeTrasactionsModel urtm) {
		System.out.println("enter into saveUserRechargetxmodel in counter dao imple");
		 sessionFactory.getCurrentSession().save(urtm);
	}
	@SuppressWarnings("rawtypes")
	public List gettrainsserach() {
		List li=sessionFactory.getCurrentSession().createQuery("from com.ktmcard.admin.model.TrainsModel").list();
		return li;
	}

	@Override
	public void savetktdetails(TicketModel tm) {
		sessionFactory.getCurrentSession().save(tm);
	}

	@SuppressWarnings("rawtypes")
	public List gettktsdetails(String a,String un) {
		List li=sessionFactory.getCurrentSession().createQuery("from com.ktmcard.admin.model.TicketModel where tktdate='"+a+"' and counterusername='"+un+"'").list();
		return li;
	}

	@Override
	public List gettarinstopdetails(String a) {
		// TODO Auto-generated method stub
		List li=sessionFactory.getCurrentSession().createQuery("from com.ktmcard.admin.model.TrainsModel where trainnumber='"+a+"'").list();
		return li;
	}

	@Override
	public void counterchangepasswordlist(String un, String newpassword) {
		sessionFactory.getCurrentSession().createQuery("update Userslist set password='"+newpassword+"' where username='"+un+"'").executeUpdate();
		
	}
}
