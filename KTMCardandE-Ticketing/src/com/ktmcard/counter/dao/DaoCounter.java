package com.ktmcard.counter.dao;

import java.util.List;

import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.TicketModel;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;

public interface DaoCounter {

	void counterChangePassword(Integer id, String newpassword,
			String confirmnewpwd);

	List<CounterModel> loginlist(String un, String pwd);

	void updateCounter(CounterModel cm);

public void saveApplyCard(ApplyCardModel acm);

void updatecardbalance(String inttopup, String cardid);

void saveUserRechargetxmodel(UserRechargeTrasactionsModel urtm);
@SuppressWarnings("rawtypes")
List gettrainsserach();

void savetktdetails(TicketModel tm);

@SuppressWarnings("rawtypes")
List gettktsdetails(String a, String un);

List gettarinstopdetails(String a);

void counterchangepasswordlist(String un, String newpassword);
}
