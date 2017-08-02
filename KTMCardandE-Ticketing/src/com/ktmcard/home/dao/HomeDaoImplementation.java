package com.ktmcard.home.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.home.model.UserRole;
import com.ktmcard.home.model.Userslist;

@Repository
public class HomeDaoImplementation implements HomeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<RegistrationModel> registerlist() {
		System.out.println("enter daoimp");
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel").list();
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addregistration(RegistrationModel rmdl) {
		System.out.println("enter reg dal impln");
		sessionFactory.getCurrentSession().saveOrUpdate(rmdl) ;		
		
		//.........save to users list...
		
		Userslist ul=new Userslist();

		ul.setUsername(rmdl.getUsername());
		ul.setPassword(rmdl.getPassword());
		ul.setEnabled(false);
		ul.setStatus("Inactive");
		ul.setType(rmdl.getType());
		sessionFactory.getCurrentSession().save(ul);
		
		 //............save users role....
		
        UserRole userrole=new UserRole();
        userrole.setUsersListModel(ul);
        if(rmdl.getType().equalsIgnoreCase("Admin"))
         {
        userrole.setRole("ROLE_Admin");
         }
        if(rmdl.getType().equalsIgnoreCase("User"))
         {
	        userrole.setRole("ROLE_User");
         }
sessionFactory.getCurrentSession().merge(userrole);

 System.out.println("Insertion over......");
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void statuschange(String unme, String status) {
		String ap="Active";
		sessionFactory.getCurrentSession().createQuery("update Userslist set enabled='"+1+"',status = '"+ap+"' WHERE USERNAME='"+unme+"'").executeUpdate();

	//sessionFactory.getCurrentSession().createQuery("update RegistrationModel set status ='"+ap+"' WHERE username='"+unme+"'").executeUpdate();		
	
	}

	@SuppressWarnings("unchecked")
		public List<RegistrationModel> usernameuniquelist() {
		return (List<RegistrationModel>) sessionFactory.getCurrentSession().createCriteria(RegistrationModel.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<RegistrationModel> emailuniquelist() {
		return (List<RegistrationModel>) sessionFactory.getCurrentSession().createCriteria(RegistrationModel.class).list();

	}

	public List<RegistrationModel> loginlist(LoginBean lg) {
		String u=lg.getUsername();
		String p=lg.getPassword();
		
		System.out.println(u);
		
		@SuppressWarnings("unchecked")
		List<RegistrationModel> l=sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+u+"' and password='"+p+"'").list();
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<RegistrationModel> forgotpasswordlist(String username,
			String emailid) {
		
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"' and emailid='"+emailid+"'").list();
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

;	public List verifingcardnumber(String cardnumber) {
		System.out.println("enter into verifingcardnumber home dao implementation");
		
		return sessionFactory.getCurrentSession().createQuery("FROM ApplyCardModel where STATUS='Approved'and CARDID='"+cardnumber+"'").list();	
		
	}

	@Override
	public void updatecardticketbalance(String upb, String cardnumber) {
		System.out.println("enter into updatecardticketbalance dao implementation");
		String query="UPDATE ApplyCardModel SET BALANCE='"+upb+"' WHERE CARDID='"+cardnumber+"'";
		sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	public List<CounterModel> counterforgotpasswordlist(String username,
			String emailid) {
		return(List<CounterModel>) sessionFactory.getCurrentSession().createQuery("from CounterModel where username='"+username+"' and emailid='"+emailid+"'").list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List loginusername(String un) {
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+un+"'").list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CounterModel> logincounterusername(String un) {
		return(List<CounterModel>) sessionFactory.getCurrentSession().createQuery("from CounterModel where username='"+un+"'").list();
	}

}
