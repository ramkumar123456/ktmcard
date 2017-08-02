package com.ktmcard.home.dao;

import java.util.List;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.home.model.RegistrationModel;

public interface HomeDao {

	List<RegistrationModel> registerlist();

	void addregistration(RegistrationModel rmdl);

	void statuschange(String unme, String status);

	List<RegistrationModel> usernameuniquelist();

	List<RegistrationModel> emailuniquelist();

	List<RegistrationModel> loginlist(LoginBean lg);

	List<RegistrationModel> forgotpasswordlist(String username, String emailid);

	List<CounterModel> loginlist(String un, String pwd);

	void updateCounter(CounterModel cm);

	List verifingcardnumber(String cardnumber);

	void updatecardticketbalance(String upb, String cardnumber);

	List<CounterModel> counterforgotpasswordlist(String username, String emailid);

	List loginusername(String un);

	List<CounterModel> logincounterusername(String un);
	
	

}
