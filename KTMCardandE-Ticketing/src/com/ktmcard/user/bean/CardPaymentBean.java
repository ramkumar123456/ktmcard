package com.ktmcard.user.bean;

public class CardPaymentBean {
	
	private String cardnumber;
	private String cardname;
	private String expiredate;
	private String cvvnumber;
	
	
	
	
	
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber.trim().replaceAll(" ", "");
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname.trim().replaceAll(" ", "");
	}
	public String getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate.trim().replaceAll(" ", "");
	}
	public String getCvvnumber() {
		return cvvnumber;
	}
	public void setCvvnumber(String cvvnumber) {
		this.cvvnumber = cvvnumber.trim().replaceAll(" ", "");
	}
	
	
	
	
	

}
