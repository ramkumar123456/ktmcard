package com.ktmcard.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.user.dao.UserDao;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;

@Service("UserService")
@Transactional
public class UserServiceImplementation implements UserService{
	@Autowired
	private UserDao userdao;

	@Override
	public List<RegistrationModel> loginlist(String username, String password) {
		return userdao.loginlist(username,password);
	}

	

	@Override
	public void changepassword(String username, String npd, String cnpd) {
		userdao.changepassword(username,npd,cnpd);		
	}
	
	
	@Override
	public void saveApplyCard(ApplyCardModel acm) {
	System.out.println("enter into saveApplyCard method in user service imple");
	userdao.saveApplyCard(acm);
		
	}


	@Override
	public void saveUserRechargetxmodel(UserRechargeTrasactionsModel urtm) {
		System.out.println("enter into saveUserRechargetxmodel method in user service imple");
		userdao.saveUserRechargetxmodel(urtm);
		
	}


	@Override
	public List checkusercard(String cardid,String username,String password) {
	System.out.println("enter into userservice checkusercard");
		return userdao.checkusercard(cardid,username,password);
	}


	@Override
	public List getbalance(String rechcard) {
		System.out.println("enter into getbalance method in userservice");
		return userdao.getbalance(rechcard);
	}


	@Override
	public void updatebalance(int updatedbalance,String rechcard, String rechargeamount) {
		System.out.println("enter into updatebalance method in userservice");
	userdao.updatebalance(updatedbalance,rechcard);
	}


	@Override
	public List listoftransactions(String username, String password) {
		System.out.println("enter into listoftransactions method in userservice");
		return userdao.listoftransactions(username,password);
	}


	@Override
	public void updatecardbalance(String inttopup, String cardid) {
		System.out.println("enter into updatecardbalance method in userservice");
		userdao.updatecardbalance(inttopup,cardid);
	}


	@Override
	public List listofuserapplycards(String username, String password) {
		System.out.println("enter into updatecardbalance method in userservice");
		return userdao.listofuserapplycards(username,password);
	}



	@Override
	public void updateuserprofile(RegistrationModel rm) {
		userdao.updateuserprofile(rm);		
	}



	@Override
	public void changepasswordlist(String username, String npd) {
		userdao.changepasswordlist(username,npd);		
	}
	
}
