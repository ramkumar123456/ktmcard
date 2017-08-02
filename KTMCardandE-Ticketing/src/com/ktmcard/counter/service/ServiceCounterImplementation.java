package com.ktmcard.counter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.TicketModel;
import com.ktmcard.counter.dao.DaoCounter;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;

@Service("ServiceCounter")

@Transactional
public class ServiceCounterImplementation implements ServiceCounter{
	@Autowired
	private DaoCounter daocounter;

	@Override
	public void counterChangePassword(Integer id, String newpassword,
			String confirmnewpwd) {
		// TODO Auto-generated method stub
		daocounter.counterChangePassword(id,newpassword,confirmnewpwd);
	}

	@Override
	public List<CounterModel> loginlist(String un, String pwd) {
		// TODO Auto-generated method stub
		return daocounter.loginlist(un,pwd);
	}

	@Override
	public void updateCounter(CounterModel cm) {
		// TODO Auto-generated method stub
		daocounter.updateCounter(cm);
	}

	@Override
	public void saveApplyCard(ApplyCardModel acm) {
		daocounter.saveApplyCard(acm);
		
	}

	@Override
	public void updatecardbalance(String inttopup, String cardid) {
		System.out.println("enter into saveUserRechargetxmodel in service counter");
		daocounter.updatecardbalance(inttopup,cardid);
		
	}

	@Override
	public void saveUserRechargetxmodel(UserRechargeTrasactionsModel urtm) {
		System.out.println("enter into saveUserRechargetxmodel in service counter");
		daocounter.saveUserRechargetxmodel(urtm);
	}
	@Transactional
	public List gettrainsserach() {
		// TODO Auto-generated method stub
		return daocounter.gettrainsserach();
	}
	@Override
	@Transactional
	public void savetktdetails(TicketModel tm) {
		// TODO Auto-generated method stub
		daocounter.savetktdetails(tm);
	}
	@Override
	@Transactional
	public List gettktsdetails(String a,String un) {
		// TODO Auto-generated method stub
		return daocounter.gettktsdetails(a,un);
	}

	@Override
	@Transactional
	public List gettarinstopdetails(String a) {
		// TODO Auto-generated method stub
		return daocounter.gettarinstopdetails(a);
	}

	@Override
	public void counterchangepasswordlist(String un, String newpassword) {
		daocounter.counterchangepasswordlist(un,newpassword);		
	}

}
