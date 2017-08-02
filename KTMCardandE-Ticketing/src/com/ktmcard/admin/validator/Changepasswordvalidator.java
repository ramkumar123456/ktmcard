package com.ktmcard.admin.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.home.bean.Registration;


public class Changepasswordvalidator implements Validator {
	
	
	
	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		Registration r=(Registration)target;
		
		//....oldpwd...
		String oldpwd=r.getOldpassword();
		oldpwd=oldpwd.replaceAll(" ", "");
	//..........password.............................
		String password=r.getPassword();	
		password=password.replaceAll(" ", "");
	//............conformpassword..............
		String conformpassword=r.getConformpassword();
		if(oldpwd == null || oldpwd.trim().equals("")){
			errors.rejectValue("oldpassword","errors.oldpassword.required","OldPassword is required");
		}
		//...........password..........
		if(password == null || password.trim().equals("")){
			errors.rejectValue("password","errors.password.required","Password is required");
		}
		else if(password.length()<6||password.length()>24){
			errors.rejectValue("password","errors.password.length","Password must be minimum length 6 and maximum 24 ");
		}
		else if(!password.matches("^[A-Za-z]+[a-z]+[_ @.]+[0-9!@#$%&*.-]+$"))
		{
			errors.rejectValue("password","errors.password.match","Password invalid (ex:Abc@123) and it allow special characters @._ only");
		} 
			else{ 
				try{
				if(!password.substring(0, 1).matches("^[A-Z]+$"))
		{
			errors.rejectValue("password","errors.password.startinit","Password first letter should be upper case letter only ");
		}
				
		else if(!password.matches("^(?!.*?[@._]{2})[a-zA-Z0-9@._]+$")){
			errors.rejectValue("password","errors.password.consecutivespecial","Password don't allow special characters consecutive");

		}
		else if(password.endsWith(".")||password.endsWith(",")||password.endsWith("?")||password.endsWith("@")||password.endsWith("!")||password.endsWith("#")||password.endsWith("$")||password.endsWith("%")||password.endsWith("^")||password.endsWith("&")||password.endsWith("*")){
			errors.rejectValue("password","errors.password.endswith","Password last character not ends with special character");
		}
		
			}
			catch(Exception e){

			}
		}
			 //..............conformpassword.....................
			if(conformpassword==null||conformpassword.trim().equals("")){
					errors.rejectValue("conformpassword","errors.conformpassword.required","Conform Password is required");
			}
			else if(!conformpassword.equals(password)){
				errors.rejectValue("conformpassword","errors.conformpassword.equal","Conform Password should be same as password");
			}

	}

}
