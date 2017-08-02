package com.ktmcard.counter.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.admin.bean.TrainsBean;


public class FindTrainsValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return TrainsBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		TrainsBean tb=(TrainsBean)target;
	
	String source=tb.getSource();
	String destn=tb.getDestination();
	System.out.println("station name.."+source);
	System.out.println("station name.."+destn);

	if(source.trim().equals("")){
		errors.rejectValue("source","errors.source.required","Source is required");
    }
	else if(source.length()<2||source.length()>15){
		errors.rejectValue("source","errors.source.length","Source length should be minimum 2 and maximum 15");

	}
	else if(source.toLowerCase().equals("source")||source.toLowerCase().equals("destination")){
		errors.rejectValue("source","errors.source.match","Source should not be entered as source or destination");
	}
	if(destn.trim().equals("")){
		errors.rejectValue("destination","errors.destination.required","Destination is required");

	}
	else if(destn.length()<2||destn.length()>15){
		errors.rejectValue("destination","errors.destination.length","Destination length should be minimum 2 and maximum 15");

	}
	else if(destn.toLowerCase().equals("source")||destn.toLowerCase().equals("destination")){
		errors.rejectValue("destination","errors.destination.match","Destination should not be entered as destination or source");
	}
	}

}
