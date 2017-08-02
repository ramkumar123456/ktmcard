package com.ktmcard.user.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.home.bean.ApplyCardBean;


public class RechargePageValidator implements Validator{

	

	public boolean supports(Class<?> clazz) {
		return ApplyCardBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ApplyCardBean  r=(ApplyCardBean )target;
		
		
		String fn=r.getFirstname();
		System.out.println("firstname in validator is"+fn);
		
		String firstname=fn.replaceAll(" ", "");
		r.setFirstname(firstname.trim());
		//....................middlename.............
		String mn=r.getMiddlename();
		String middlename=mn.replaceAll(" ", "");
	
		
		r.setMiddlename(middlename.trim());
		
		
		if(firstname.trim().equals("")){
			errors.rejectValue("firstname","errors.firstname.required","Cardnumber is required");
	    }
		else if(!firstname.matches("^[0-9 ]+$")){
		errors.rejectValue("firstname","errors.firstname.acceptcharacters","Cardnumber accepts only Numbers");
		}
		else if(!(firstname.length()==12)){
		errors.rejectValue("firstname","errors.firstname.length","CardNumber length should be 12 numbers");
		}
		
		
		if(middlename.trim().equals("")){
			errors.rejectValue("middlename","errors.middlename.required","Amount is required");
		}
		else if(!middlename.matches("^[0-9 ]+$")){
			errors.rejectValue("middlename","errors.middlename.accepts","Amount accepts only numbers");
		}
		else if(Integer.valueOf(middlename)<50){
			errors.rejectValue("middlename","errors.middlename.length","Minimum Amount Should be 50");
		}
		
		
	
	}
}
