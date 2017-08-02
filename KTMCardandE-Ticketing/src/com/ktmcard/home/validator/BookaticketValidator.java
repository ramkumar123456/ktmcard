package com.ktmcard.home.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.home.bean.Registration;

public class BookaticketValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
	}

}
