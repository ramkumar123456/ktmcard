package com.ktmcard.home.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.home.bean.Registration;

public class Forgotpasswordvalidator implements Validator {
	
	
	
	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		Registration r=(Registration)target;
		String username=r.getUsername();
		username=username.replaceAll(" ", "");
		username=username.trim();
		r.setUsername(username);
		String email=r.getEmail();
		email=email.replaceAll(" ", "");
		email=email.trim();
		r.setEmail(email);
		if(username == null ||username .trim().equals("")){
			errors.rejectValue("username","errors.username.required","Username is required");
		}
		if(email == null||email.trim().equals("")){
			errors.rejectValue("email","errors.email.required","Email Id is required");
		}
	}}
