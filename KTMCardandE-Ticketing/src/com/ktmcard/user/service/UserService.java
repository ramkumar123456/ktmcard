package com.ktmcard.user.service;

import java.util.List;

import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;

public interface UserService {

	List<RegistrationModel> loginlist(String username, String password);


	public void changepassword(String username, String npd, String cnpd);
	
	
	public void saveApplyCard(ApplyCardModel acm);

	public void saveUserRechargetxmodel(UserRechargeTrasactionsModel urtm);

	public List checkusercard(String cardid, String username, String password);

	public List getbalance(String rechcard);

	public void updatebalance(int updatedbalance, String rechcard, String rechargeamount);

	public List listoftransactions(String username, String password);

	public void updatecardbalance(String inttopup, String cardid);

	public List listofuserapplycards(String username, String password);


	public void updateuserprofile(RegistrationModel rm);


	void changepasswordlist(String username, String npd);

}
