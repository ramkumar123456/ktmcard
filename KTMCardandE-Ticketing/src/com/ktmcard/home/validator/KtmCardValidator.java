package com.ktmcard.home.validator;

import org.springframework.validation.Errors;

import com.ktmcard.admin.bean.TrainsBean;
import com.ktmcard.home.bean.ApplyCardBean;


public class KtmCardValidator {

	public boolean supports(Class<?> clazz) {
		return TrainsBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		TrainsBean r=(TrainsBean)target;
		
		
		String cardid=r.getCardid();
		cardid=cardid.replaceAll(" ","");
		cardid=cardid.trim();
		r.setCardid(cardid);
		
		
		if(cardid.trim().equals("")){
			errors.rejectValue("cardid","errors.cardid.required","Cardnumber is required");
	    }
		else if(!cardid.matches("^[0-9 ]+$")){
		errors.rejectValue("cardid","errors.cardid.acceptcharacters","Cardnumber accepts only Numbers");
		}
		else if(!(cardid.length()==12)){
		errors.rejectValue("cardid","errors.cardid.length","CardNumber length should be 12 numbers");
		}
}
}
