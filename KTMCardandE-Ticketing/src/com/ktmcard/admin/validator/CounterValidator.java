package com.ktmcard.admin.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.admin.bean.CounterBean;

public class CounterValidator implements Validator{

	@Override
	public boolean supports(Class<?> ee) {
		// TODO Auto-generated method stub
		return  CounterBean.class.isAssignableFrom(ee);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		CounterBean cb=(CounterBean)target;
		String username=cb.getUsername();
		String password=cb.getPassword();
		String conformpassword=cb.getConformpassword();
		String sname=cb.getStationname();
		String scode=cb.getStationcode();
		String city=cb.getCity();
		String pincode=cb.getPincode();
		
		//-----------------------------Username-----------------------------------//
		
		username=username.replaceAll(" ", "");
		String us=WordUtils.capitalizeFully(username);
		System.out.println("un ctpl..."+us);
		cb.setUsername(username);
		if(username == null ||username .trim().equals("")){
			errors.rejectValue("username","errors.username.required","Username is required");
		}
		else if(!(username .matches("^[a-zA-Z]+[0-9]+$")||(username.matches("^[a-zA-Z]+$")))){
			errors.rejectValue("username","errors.username.match","Username should be alphabets followed by digits(Ex:abc123/abc)");
		}
		
		else if(username .length()<6||username .length()>30){
			errors.rejectValue("username","errors.username.length","Username must be minimum length 6 and maximum 30");
		}
		
		else if(username.toLowerCase().contains("username")){
			errors.rejectValue("username","errors.username.equalss","Username should not entered as Username");
		}
		else if(username .substring(0,1).matches("^[0-9]")){
			
			errors.rejectValue("username","errors.username.start","Username starts with alphabets");
		}
		
		else 
		{
			try{
			 if(username .substring(0,1).matches("^[0-9]")){
					
					errors.rejectValue("username","errors.username.start","Username starts with alphabets");
				}
			
			}
			catch(Exception e){
				 
			}
		}
		
		
	//--------------------------Password--------------------------------------------------//
		cb.setPassword(password);
		password=password.replaceAll(" ", "");
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
		else if(!password.substring(0, 1).matches("^[A-Z]+$"))
		{
			errors.rejectValue("password","errors.password.startinit","Password first letter should be upper case letter only ");
		}
	
		
		
		else if(!password.matches("^(?!.*?[@._]{2})[a-zA-Z0-9@._]+$")){
			errors.rejectValue("password","errors.password.consecutivespecial","Password don't allow special characters consecutive");

		}
		else if(password.endsWith(".")||password.endsWith(",")||password.endsWith("?")||password.endsWith("@")||password.endsWith("!")||password.endsWith("#")||password.endsWith("$")||password.endsWith("%")||password.endsWith("^")||password.endsWith("&")||password.endsWith("*")){
			errors.rejectValue("password","errors.password.endswith","Password last character not ends with special character");
		}
		
		
		else{ 
			try{
		
		 if(password.substring(0,3).contains(us.substring(0, 3))){
			errors.rejectValue("password","errors.password.matchusername","Password first 3 characters should not be match with Username first 3 characters");
		}
		else if(password.substring(0,8).toLowerCase().contains("password")){
			errors.rejectValue("password","errors.password.contains","Password should not entered as password");

		}
		
			}
			catch(Exception e){

			}
		}
	
	//--------------------------------Confirm Password---------------------------------------------
		
		cb.setConformpassword(conformpassword);
		conformpassword=conformpassword.replaceAll(" ", "");
		if(conformpassword==null||conformpassword.trim().equals("")){
			errors.rejectValue("conformpassword","errors.conformpassword.required","Conform Password is required");
	}
	else if(!conformpassword.equals(password)){
		errors.rejectValue("conformpassword","errors.conformpassword.equal","Conform Password should be same as password");
	}
//------------------------------Station name-------------------------------
		
		sname=sname.trim();
		sname=sname.replaceAll("\\s+", "");
		//name = name.replace(" ", "");
		sname=WordUtils.capitalizeFully(sname);
		cb.setStationname(sname);
		
		if(sname.trim().equals("")){
			errors.rejectValue("stationname","stationname","Station Name is required");
	    }
		
		else if(sname.length()<2||sname.length()>30)
		{
			errors.rejectValue("stationname", "stationname","Station Name length is minimum 2 and maximum 30");
			}
		else if(!sname.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("stationname", "stationname","Station Name accepts alphabets only");
		}
		
		else if(sname.equals("stationname")||sname.equals("Stationname")){
			errors.rejectValue("stationname","stationname","stationname Should not be entered as Stationname");
			}
		
	//-----------------------Station Code------------------------------------------------------//	
		
		scode=scode.trim();
		scode=scode.replaceAll("\\s+", "");
		//name = name.replace(" ", "");
		scode=WordUtils.capitalizeFully(scode);
		cb.setStationcode(scode);
		
		if(scode.trim().equals("")){
			errors.rejectValue("stationcode","stationcode","Station Code is required");
	    }
	
		else if(scode.length()<2||scode.length()>30)
		{
			errors.rejectValue("stationcode", "stationcode","Station Code length is minimum 2 and maximum 30");
			}
		else if(!scode.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("stationcode", "stationcode","Station Code accepts alphabets only");
		}
		
		else if(scode.equals("stationcode")||scode.equals("Stationcode")){
			errors.rejectValue("stationcode","stationcode","StationCode Should not be entered as Stationcode");
			}
		else if(scode.equals(sname)){
			errors.rejectValue("stationcode","stationcode","Station Code  should not be same as Station Name");
		}
	//-----------------------------------------------city--------------------------------
	city=city.trim();
	city=city.replaceAll(" ", "");
	city=WordUtils.capitalizeFully(city);
	cb.setCity(city);
	
	if(city==null||city.trim().equals("")){
		errors.rejectValue("city","errors.city.required","City is required");
	}
	else if(city.length()<2||city.length()>30){
		errors.rejectValue("city","errors.citylength","City length should be minimum 2 and maximum 30");
	}
	else if(!city.matches("^[a-zA-Z ]+$")){
		errors.rejectValue("city","errors.city.match","City accepts only alphabets");
	}
	else if(city.toLowerCase().contains("city")){
		errors.rejectValue("city","errors.city.match","City Should not be entered as city");

	}
	
	
	//---------------------------------------------------Pincode------------------------------------
	pincode=pincode.replaceAll(" ", "");
	cb.setPincode(pincode);
	 if(pincode==null||pincode.trim().equals("")){
			errors.rejectValue("pincode","errors.pincode.required","Pincode is required");
	}
	else if(pincode.length()<3||pincode.length()>8){
		errors.rejectValue("pincode","errors.pincode.length","Pincode length must be minimum 3 and maximum 8");
	}
	else if(!pincode.matches("^[0-9]+$")){
		errors.rejectValue("pincode","errors.pincode.matchdgt","Pincode accepts only digits");
	}
	
	
	}
}
