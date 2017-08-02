package com.ktmcard.home.service;

import java.util.List;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.home.model.RegistrationModel;

public interface HomeService {

	public List<RegistrationModel> registerlist();

	public void addregistration(RegistrationModel rmdl);

	public void statuschange(String unme, String status);


	public List<RegistrationModel> usernameuniquelist();

	public List<RegistrationModel> emailuniquelist();

	public List<RegistrationModel> loginlist(LoginBean lg);

	public List<RegistrationModel> forgotpasswordlist(String username,
			String emailid);

	public List<CounterModel> loginlist(String un, String pwd);

	
	public void updateCounter(CounterModel cm);

	public List verifingcardnumber(String cardnumber);

	public void updatecardticketbalance(String upb, String cardnumber);

	public List<CounterModel> counterforgotpaswordlist(String username,
			String emailid);

	public List loginusername(String un);

	public List<CounterModel> logincounterusername(String un);
	
	

}
