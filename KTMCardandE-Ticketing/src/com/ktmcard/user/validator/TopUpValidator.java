package com.ktmcard.user.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.home.bean.ApplyCardBean;


public class TopUpValidator implements Validator{

	

	public boolean supports(Class<?> clazz) {
		return ApplyCardBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ApplyCardBean  r=(ApplyCardBean )target;
		
		
		String country=r.getCountry();
		
		
		if(country==null||country.trim().equals("")){
			errors.rejectValue("country","errors.country.required","TopUp Amount is Required");
		}
	}
}
