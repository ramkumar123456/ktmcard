package com.ktmcard.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.home.dao.HomeDao;
import com.ktmcard.home.model.RegistrationModel;

@Service("HomeService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class HomeServiceImplementation implements HomeService{

	@Autowired
	private HomeDao homedao;
	public List<RegistrationModel> registerlist() {
		
				return homedao.registerlist();
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public void addregistration(RegistrationModel rmdl) {
		
		homedao.addregistration(rmdl);
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public void statuschange(String unme, String status) {
homedao.statuschange(unme,status);		
	}
	@Override
	public List<RegistrationModel> usernameuniquelist() {
		
		return homedao.usernameuniquelist();
	}
	@Override
	public List<RegistrationModel> emailuniquelist() {
		return homedao.emailuniquelist();
	}
	public List<RegistrationModel> loginlist(LoginBean lg) {
		return homedao.loginlist(lg);
	}
	@Override
	public List<RegistrationModel> forgotpasswordlist(String username,
			String emailid) {
		return homedao.forgotpasswordlist(username,emailid);
	}
	public List<CounterModel> loginlist(String un, String pwd) {
		// TODO Auto-generated method stub
		return homedao.loginlist(un,pwd);
	}
	@Override
	public void updateCounter(CounterModel cm) {
		// TODO Auto-generated method stub
		homedao.updateCounter(cm);
	}
	@Override
	public List verifingcardnumber(String cardnumber) {
	System.out.println("enter into service implementation verifingcardnumber");
		return homedao.verifingcardnumber(cardnumber);
	}
	@Override
	public void updatecardticketbalance(String upb, String cardnumber) {
		System.out.println("enter into service implementation updatecardticketbalance");
		homedao.updatecardticketbalance(upb,cardnumber);
		
		
	}
	@Override
	public List<CounterModel> counterforgotpaswordlist(String username,
			String emailid) {
		return homedao.counterforgotpasswordlist(username,emailid);
	}
	@Override
	public List loginusername(String un) {
		// TODO Auto-generated method stub
		return homedao.loginusername(un);
	}
	@Override
	public List<CounterModel> logincounterusername(String un) {
		// TODO Auto-generated method stub
		return homedao.logincounterusername(un);
	}
}
