package com.ktmcard.user.validator;

import org.springframework.validation.Errors;


import com.ktmcard.user.bean.CardPaymentBean;

public class CardPaymentValidator {
	
	public boolean supports(Class<?> clazz) {
		return CardPaymentBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		 CardPaymentBean  r=(CardPaymentBean )target;
		 
		 
		 
		 String cnumber=r.getCardnumber();
		
		 
		
			
	
			
			String cname=r.getCardname();
			String cardname=cname;
			
			
			
		String exdt=r.getExpiredate();
		String expiredate=exdt;
		
		
		String cvv=r.getCvvnumber();
		String cvvnumber=cvv;
		
	
		if(cnumber.equals(""))
		{
			errors.rejectValue("cardnumber","errors.cardnumber.required","Cardnumber is required");
	    }
		else if(!cnumber.matches("^[0-9 ]+$")){
		errors.rejectValue("cardnumber","errors.cardnumber.acceptcharacters","cardnumber accepts only numbers");
		}
		
		
		if(cardname.equals("")){
			errors.rejectValue("cardname","errors.cardname.required","Cardname is required");
	    }
		else if(!cardname.matches("^[A-Za-z ]+$")){
		errors.rejectValue("cardname","errors.cardname.acceptcharacters","Cardname accepts only  alphabets");
		}
		
	
		
		
		if(expiredate.equals("")){
			
			errors.rejectValue("expiredate","errors.expiredate.required","ExpireDate is required");
			
		}
		
	if(cvvnumber.equals("")){
			
			errors.rejectValue("cvvnumber","errors.cvvnumber.required","Cvvnumsber is required");
			
		}
		
		
		
		
		 
		

}
}
