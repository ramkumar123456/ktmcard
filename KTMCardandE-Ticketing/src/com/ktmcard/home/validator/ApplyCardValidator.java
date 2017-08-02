package com.ktmcard.home.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;

import com.ktmcard.home.bean.ApplyCardBean;
import com.ktmcard.home.bean.Registration;

public class ApplyCardValidator {

	public boolean supports(Class<?> clazz) {
		return ApplyCardBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ApplyCardBean r=(ApplyCardBean)target;
		
		
		//.....................firstname..................
			String fn=r.getFirstname();
			System.out.println("firstname in validator is"+fn);
			String firstname=fn.replaceAll(" ", "");
			firstname=WordUtils.capitalizeFully(firstname);
			
			String f=firstname.toLowerCase();
			r.setFirstname(firstname);
			//....................middlename.............
			String mn=r.getMiddlename();
			String middlename=mn.replaceAll(" ", "");
			middlename=WordUtils.capitalizeFully(middlename);
			String m=middlename.toLowerCase();
			r.setMiddlename(middlename);
		//.....................lastname............................
			String lastname=r.getLastname();
			lastname=lastname.replaceAll(" ", "");
			lastname=WordUtils.capitalizeFully(lastname);
			String l=lastname.toLowerCase();
			r.setLastname(lastname);
		//..................username.................
		/*	String username=r.getUsername();
			username=username.replaceAll(" ", "");
			String us=WordUtils.capitalizeFully(username);
			System.out.println("un ctpl..."+us);
			r.setUsername(username);
			//System.out.println(username);
			//System.out.println(firstname);
			//System.out.println(f);
		//..........password.............................
			String password=r.getPassword();	
			password=password.replaceAll(" ", "");
		//............conformpassword..............
			String conformpassword=r.getConformpassword();
			conformpassword=conformpassword.replaceAll(" ", "");*/
		//...............dataofbirth..............	
			
			String dob=r.getDateofbirth();

		//................gender...................
			String gender=r.getGender();
			
		//........email................
			String email=r.getEmail();
					email=email.replaceAll(" ", "");
					r.setEmail(email);
		//......mobile..........
					String mobileno=r.getMobileno();
					mobileno=mobileno.replaceAll(" ", "");
					r.setMobileno(mobileno);
		//..........address..................
					String address=r.getAddress();
					address=address.trim();
					//address = address.replaceAll("  "," ");
					r.setAddress(address);
		//..........pincode.........
					String pincode=r.getPincode();
					pincode=pincode.replaceAll(" ", "");
					r.setPincode(pincode);
		//...............country.........
					String country=r.getCountry();
		//............state................
					String state=r.getState();
		//.........city............
					String city=r.getCity();
					city=city.trim();
					city=city.replaceAll(" ", "");
					city=WordUtils.capitalizeFully(city);
					r.setCity(city);
		//..........language.......................
					
	
		//.................firstname................
			if(firstname.trim().equals("")){
				errors.rejectValue("firstname","errors.firstname.required","Firstname is required");
		    }
			else if(!firstname.matches("^[a-zA-Z ]+$")){
			errors.rejectValue("firstname","errors.firstname.acceptcharacters","Firstname accepts only characters");
			}
			else if(firstname.length()<2||firstname.length()>30){
			errors.rejectValue("firstname","errors.firstname.length","Firstname length should be minimum 2 and maximum 30");
			}
			else if(firstname.equals("firstname")||firstname.equals("Firstname")||firstname.equals("middlename")||firstname.equals("Middlename")||firstname.equals("lastname")||firstname.equals("Lastname")){
			errors.rejectValue("firstname","errors.firstname.match","Firstname should not entered as Firstname or Middlename or Lastname");
			}
			
			
		//.....................middlename..........................
		if(middlename.trim().equals("")){
			errors.rejectValue("middlename","errors.middlename.required","Middlename is required");
		}
		else if(!middlename.matches("^[a-zA-Z ]+$")){
			errors.rejectValue("middlename","errors.middlename.accepts","Middlename accepts only characters");
		}
		else if(middlename.length()<2||middlename.length()>30){
			errors.rejectValue("middlename","errors.middlename.length","Middlename length should be minimum2 and maximum30");
		}
		else if(middlename.equals("firstname")|middlename.equals("Firstname")||middlename.equals("middlename")||middlename.equals("Middlename")||middlename.equals("lastname")||middlename.equals("Lastname")){
			errors.rejectValue("middlename","errors.middlename.matchall","Middlename should not entered as Firstname or Middlename or Lastname");
		}
		else if(middlename.equals(firstname)){
			errors.rejectValue("middlename","errors.middlename.matchfirstname","Middlename should not be same as Firstname");
		}
			//.....................lastname............................
			
		if(lastname == null || lastname.trim().equals("")){
			errors.rejectValue("lastname","errors.lastname.required","Lastname is required");
		}
		else if(!lastname.matches("^[a-zA-Z ]+$")){
			errors.rejectValue("lastname","errors.lastname.match","Lastname accepts only characters");
		}
		else if(lastname.length()<2||lastname.length()>30){
			errors.rejectValue("lastname","errors.lastname.length","Lastname length should be minimum2 and maximum30");
		}
		else if(lastname.equals("firstname")|lastname.equals("Firstname")||lastname.equals("middlename")||lastname.equals("Middlename")||lastname.equals("lastname")||lastname.equals("Lastname")){
			errors.rejectValue("lastname","errors.lastname.matchall","Lastname should not entered as Firstname or Middlename or Lastname");
		}
		else if(lastname.equals(firstname)||lastname.equals(middlename)){
			errors.rejectValue("lastname","errors.lastname.matchform","Lastname should not be same as Firstname or Middlename");
		}	
		//......................username................................	
		/*if(username == null ||username .trim().equals("")){
			errors.rejectValue("username","errors.username.required","Username is required");
		}
		else if(!(username .matches("^[a-zA-Z]+[0-9]+$")||(username.matches("^[a-zA-Z]+$")))){
			errors.rejectValue("username","errors.username.match","Username should be alphabets followed by digits(Ex:abc123/abc)");
		}
		
		else if(username .length()<6||username .length()>30){
			errors.rejectValue("username","errors.username.length","Username must be minimum length 6 and maximum 30");
		}
		else if(username.toLowerCase().contains("firstname")|username.toLowerCase().contains("middlename")|username.toLowerCase().contains("lastname")){
			
			errors.rejectValue("username","errors.username.equalss","Username should not entered as firstname or lastname or middlename");
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
			 else if (!firstname.equalsIgnoreCase("")||!middlename.equalsIgnoreCase("")||!lastname.equalsIgnoreCase(""))
		        {
		        	
				if(username.toLowerCase().contains(f)){
					errors.rejectValue("username","errors.username.startfir","Username not match with firstname");

				}
				else if(username.toLowerCase().contains(m)){
					errors.rejectValue("username","errors.username.lowerm","Username not match with Middlename");
				}
				else if(username.toLowerCase().contains(l)){
					errors.rejectValue("username","errors.username.lowerl","Username not match with Lastname");
				}
		        }
			}
			catch(Exception e){
				 
			}
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
				aelse {
					   
					   try{
						   for(int i=0;i<password.length()-1;i++){
								char c=password.charAt(i);
								String s=Character.toString(c);
								char cc=password.charAt(i+1);
								String ss=Character.toString(cc);
								if(s.matches("^[?.@!#$%^&*|_]+$")&&ss.matches("^[?.@!#$%^&*|_]+$")){
									errors.rejectValue("password","errors.password.consecutivespecial","Password don't allow special characters consecutive");
								}

				    	   }
				    }
				    	 catch(Exception e){
				    		 for(int i=0;i<password.length()-1;i++){
				 				char c=password.charAt(i);
				 				String s=Character.toString(c);
				 				char cc=password.charAt(i+1);
				 				String ss=Character.toString(cc);
				 				if(s.matches("^[?.@!#$%^&*|_]+$")&&ss.matches("^[?.@!#$%^&*|_]+$")){
				 					errors.rejectValue("password","errors.password.consecutivespecial","Password don't allow special characters consecutive");
				 					
				 				}

				     }
				   }  	    
				 }
				
				else{ 
					try{
					
					if(password.substring(0,3).contains(firstname.substring(0, 3))){
					errors.rejectValue("password","errors.password.matchfirstname","Password first 3 characters should not be match with Firstname first 3 characters");
				}
				else if(password.substring(0,3).contains(middlename.substring(0, 3))){
					errors.rejectValue("password","errors.password.matchmiddlename","Password first 3 characters should not be match with Middlename first 3 characters");
				}
				else if(password.substring(0,3).contains(lastname.substring(0, 3))){
					errors.rejectValue("password","errors.password.matchlastname","Password first 3 characters should not be match with Lastname first 3 characters");
				}
				else if(password.substring(0,3).contains(us.substring(0, 3))){
					errors.rejectValue("password","errors.password.matchusername","Password first 3 characters should not be match with Username first 3 characters");
				}
				else if(password.substring(0,8).toLowerCase().contains("password")){
					errors.rejectValue("password","errors.password.contains","Password should not entered as password");

				}
				if(password == null || password.trim().equals("")){
					errors.rejectValue("password","errors.password.required","Password is required");
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
					}*/

					 //.................dateofbirth.................
					if(dob==null||dob.trim().equals("")){
						errors.rejectValue("dateofbirth","errors.dateofbirth.required","Date Of Birth is required");
					}	
					
					else
					{	 
						 try
						 {
						  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						   //get current date time with Date()
						   Date date = new Date();
						   int  yr=date.getYear()+1900;
					     	 int mm=date.getMonth()+1;
					     	 int dd=date.getDate();
					    
					     	 
					     	String[] s = dob.split("/");
					     	
					     	int mth = Integer.parseInt(s[0]);
					     	int dat = Integer.parseInt(s[1]);
					     	int yrr = Integer.parseInt(s[2]);
					     	int  ny=yr-yrr;
					     	int nm=mm-mth;
					     	int nd=dd-dat;
					     	if ((ny ==0 && nm == 0 && nd < 0)||(ny==0 && nm<0 && nd<=nd) || ny< 0)
					     	{
					     		errors.rejectValue("dateofbirth", "errors.dateofbirth.feature", " Feature date is not allowed.");
					           
					        }
					     	else if ((ny == 6 && nm == 0 && nd < 0)||(ny==6 && nm<0 && nd<=nd) || ny< 6) 
					     	{
					     		errors.rejectValue("dateofbirth", "errors.dateofbirth.below", "Age must be greater than 6 years.");
					        }
					     	
					     	
					      }
					      catch(Exception e)
					      {
					    	  System.out.println(e);
					      }
					}
						/*int year = date.getYear();
						   int month = date.getMonth();
						   month = month+1;
						   int day = date.getDate();
						  
						   String sp = month + "/" + day + "/" + year;
						   Date ps = new Date(dob);
						   int year1 = ps.getYear();
						   int month1 = ps.getMonth();
						   month1 = month1+1;
						   int day1 = ps.getDate();
						  
						   String s = month1 + "/" + day1 + "/" + year1;
						   
						   if(ps.getYear()>date.getYear())
						   {
								errors.rejectValue("dateofbirth","errors.dateofbirth.required","Your Age should not more than current year");
						   }
						   else if(year-year1<18)
						   {
								errors.rejectValue("dateofbirth","errors.dateofbirth.required","Your Age should not be above 18 years");
						   }
						  
						    
						   else if(year-year1==18)
						   
							   if(month-month1<0)
							   {
									errors.rejectValue("dateofbirth","errors.dateofbirth.required","Your Age should not be above 18 years");
							   }
						   
							   else if(month-month1==0)
							   {
								   if((day-day1)<0)
								   {
										errors.rejectValue("dateofbirth","errors.dateofbirth.required","Your Age should not be above 18 years");
								   }
							   }
						   }
						 
						 catch(Exception e)
						 {
							 //e.printStackTrace();
						 }
					}*/
						 
						 
				//..................gender...............   
						 
					
					
					
						 if(gender==null||gender.equals("")){
								errors.rejectValue("gender","errors.dateofbirth.required","Gender is required");
					}
					//...................email................
						 
					if(email == null||email.trim().equals("")){
						errors.rejectValue("email","errors.email.required","Email Id is required");
					}
					else if(email.length()<12||email.length()>70){
						errors.rejectValue("email","errors.email.length","Email-id must be minimum length 12 or max 70 ");
				}
					else if(!email.matches("^[A-Za-z._0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z.]+$")){
						errors.rejectValue("email","errors.email.match","Enter valid Email-id (ex:abcd@gmail.com)");
					}
					
					else if(!email.matches("^(?!.*?[@._]{2})[a-zA-Z0-9@._]+$")){
						errors.rejectValue("email","errors.email.special","Email-id don't allow special characters consecutive");
					}
					else if(email.toLowerCase().contains("emailid")||email.toLowerCase().contains("email")){
						errors.rejectValue("email","errors.email.mat","Email-id should not entered as email or emailid");

		 		 }
					/*else{
						   
						   try{
							   for(int i=0;i<email.length()-1;i++){
									char c=email.charAt(i);
									String s=Character.toString(c);
									char cc=email.charAt(i+1);
									String ss=Character.toString(cc);
									if(s.matches("^[?.@!#$%^&*|_]+$")&&ss.matches("^[?.@!#$%^&*|_]+$")){
										errors.rejectValue("email","errors.email.special","Email-id don't allow special characters consecutive");
									}

					    	   }
					    }
					    	 catch(Exception e){
					    		 for(int i=0;i<email.length()-1;i++){
					 				char c=email.charAt(i);
					 				String s=Character.toString(c);
					 				char cc=email.charAt(i+1);
					 				String ss=Character.toString(cc);
					 				if(s.matches("^[?.@!#$%^&*|_]+$")&&ss.matches("^[?.@!#$%^&*|_]+$")){
										errors.rejectValue("email","errors.email.special","Email-id don't allow special characters consecutive");
					 				}
					     }
					   }  	    
					 }*/
					
					
					else{
						   try{
						   final String[] e1=email.split("@");
				 	   String e11=e1[0];
				 	   String e12=e1[1];
				 	  if(!email.substring(0, 1).matches("^[a-zA-Z]+$"))
						{
							errors.rejectValue("email","errors.email.firstltr","Email-id starts with alphabets only");
						}
				 	  else if(e1[0].length()<6||e1[0].length()>30){
							errors.rejectValue("email","errors.email.actlngth","Email-id account name length should be minimum 6 and maximum 30");
				      }
				 	   else if(e12.contains(".")){
				 		   final String [] em1=e12.split("\\.");
				 		   System.out.println("em1......."+em1);
				 		   String em11=em1[0];
				 		   System.out.println("em11......."+em11);
				 		   String em12=em1[1];
				 		   System.out.println("em12......."+em12);
				 		   System.out.println("em1[0]..."+em1[0]);
				 		   System.out.println("e11...."+e11);
				 		   int esl=em1.length;
				 		   System.out.println("lgth..."+esl);
				 		  if(e11.matches(em11)){
								errors.rejectValue("email","errors.email.samedomainmame","Email-id address name or domain name should not be same");
				 		   }
				 		  else if(e11.matches(em12)){
								errors.rejectValue("email","errors.email.sameservmame","Email-id address name or service name should not be same");

				 		  }
				 		  else if(em11.matches(em12)){
								errors.rejectValue("email","errors.email.domservmame","Email-id domain name or service name should not be same");
  
				 		  }
				 		
				 		 else if(em1[2].toLowerCase().equals(e11.toLowerCase())){
								errors.rejectValue("email","errors.email.sameservmame1","Email-id address name or service name should not be same");

		 				 }
		 				 else if(em1[2].toLowerCase().equals(em11.toLowerCase())){
								errors.rejectValue("email","errors.email.domservmame1","Email-id domain name or service name should not be same");

		 				 }		
				 	   
				 		  /*else if(em1.length>3){
								errors.rejectValue("email","errors.email.domainnamelgth","Email-id domain name length should not be more than 3");
				 		  }*/
				 		  else if(em1[0].length()<2||em1[0].length()>30){
								errors.rejectValue("email","errors.email.domainnamelgth1","Email-id domain name length should be minimum 2 and maximum 30");
				  		 }
				 		 else if(em1[1].length()<2||em1[1].length()>4){
								errors.rejectValue("email","errors.email.domainnamelgth2","Email-id service name length should be minimum 2 and maximum 4");
				 		 }
				 		else if(em1[2].length()<2||em1[2].length()>4){
							errors.rejectValue("email","errors.email.domainnamelgth2","Email-id second service name length should be minimum 2 and maximum 4");
			 		 }
				 		 else if(esl<2||esl>3){
								errors.rejectValue("email","errors.email.domainnamelgth4","Email-id valid service name");

				 		 }
				 		 else if(email.endsWith(".")){
								errors.rejectValue("email","errors.email.ends","Email-id last character not ends with special characters");
							}
				 		 else if(em1[1].toLowerCase().equals("com")&&em1[2].toLowerCase().equals("in")){
								errors.rejectValue("email","errors.email.domservmamew","Enter valid service name");
				 				
				 		  }
				 		 else if(em1[1].toLowerCase().equals(em1[2])){
								errors.rejectValue("email","errors.email.domservmamewsam","Enter valid service name");

				 		 }
				 		 
				 	   }
						   }
						   catch(Exception e){

					   }}
					  
					//.................mobileno...............
					  
						
					 if(mobileno==null||mobileno.trim().equals("")){
							errors.rejectValue("mobileno","errors.mobileno.required","Mobile number is required");
					}
					else if(!mobileno.matches("^[0-9 ]+$")){
						errors.rejectValue("mobileno","errors.mobileno.match","Mobile number accepts only digits");
					}
					else if(mobileno.length()<8||mobileno.length()>15){
						errors.rejectValue("mobileno","errors.mobileno.length","Mobile number should be minimum 8 and maximum 15 only");
					}
					else {
						try{
					
						if(mobileno.substring(0,5).equals("00000")){
					
						errors.rejectValue("mobileno","errors.mobileno.ltrmatch","Mobile number first five numbers should not be zeros");
					}
						}
						catch(Exception e){
							
						}
					}
					 //.................address...................
					if(address==null||address.trim().equals("")){
						errors.rejectValue("address","errors.address.required","Address is required");
					}
					else if(!address.matches("^[0-9a-zA-Z-/_@.,)( \n]+$")){
						errors.rejectValue("address","errors.address.match","Enter valid address it allow special characters -/_@.,)( only");
					}
					else if(address.length()<4||address.length()>100){
						errors.rejectValue("address","errors.address.length","Address length must be minimum length 4 or max 100");
					}
					
		              
		              else {
		            	  try{
		            		  if(!address.substring(0, 1).matches("^[a-zA-Z]+$")){
		  						errors.rejectValue("address","errors.address.startltr","Address starts with alphabets only");
		  					}
		            		  else if(address.toLowerCase().equalsIgnoreCase("address")){
		  						errors.rejectValue("address","errors.address.same","Address should not entered as address");

		  					}
		            		  else if (!address.matches("^(?!.*?[:.,/ _-]{2})[a-zA-Z0-9 :.,/_-]+$")){
		  						errors.rejectValue("address","errors.address.special","Address don't allow special characters or consecutive spaces");
		  					}
		            		  else if(address.replaceAll(" ", "").toLowerCase().equals("address")){
		  						System.out.println("enter address...");
		    						errors.rejectValue("address","errors.address.same","Address should not entered as address");

		          		  }  
		            	  }
		            	  catch(Exception e){
		            		  
		            	  }
		              }

					/*else{
						   
						   try{
							   for(int i=0;i<address.length()-1;i++){
									char c=address.charAt(i);
									String s=Character.toString(c);
									char cc=address.charAt(i+1);
									String ss=Character.toString(cc);
									if(s.matches("^[?.@!#$%^&*|_ ]+$")&&ss.matches("^[?.@!#$%^&*|_ ]+$")){
										errors.rejectValue("address","errors.address.special","Address don't allow special characters or spaces consecutive");
									}
									
					    	   }
					    }
					    	 catch(Exception e){
					    		 for(int i=0;i<address.length()-1;i++){
					 				char c=address.charAt(i);
					 				String s=Character.toString(c);
					 				char cc=address.charAt(i+1);
					 				String ss=Character.toString(cc);
					 				if(s.matches("^[?.@!#$%^&*|_ ]+$")&&ss.matches("^[?.@!#$%^&*|_ ]+$")){
										errors.rejectValue("address","errors.address.special","Address don't allow special characters or spaces consecutive");
					 				}
					 	}
					   }  	    
					 }
					 */
					
					 //.............pincode....................
					
					 if(pincode==null||pincode.trim().equals("")){
							errors.rejectValue("pincode","errors.pincode.required","Pincode is required");
					}
					else if(pincode.length()<3||pincode.length()>8){
						errors.rejectValue("pincode","errors.pincode.length","Pincode length must be minimum 3 and maximum 8");
					}
					else if(!pincode.matches("^[0-9]+$")){
						errors.rejectValue("pincode","errors.pincode.matchdgt","Pincode accepts only digits");
					}
					 //...............country..............
					if(country==null||country.trim().equals("")){
						errors.rejectValue("country","errors.country.required","Country is required");
					}
					 //.............state..............
					if(state==null||state.trim().equals("")){
						errors.rejectValue("state","errors.state.required","State is required");
					}
					 //.............city.................
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
					else if(city.toLowerCase().contains("firstname")||city.toLowerCase().contains("middlename")||city.toLowerCase().contains("lastname")){
						errors.rejectValue("city","errors.city.match","City Should not be entered as firstname or middlename or lastname");

					}
					else 
					{
					try{
						/*if(username.contains(lastname)||username.contains(middlename)||username.contains(firstname)){
							errors.rejectValue("username","errors.username.equal","Username should not be same as Firstname or Middlename or Lastname");
						}*/
						 
				 if(city.equalsIgnoreCase(firstname)){
					errors.rejectValue("city","errors.city.lowerf","City not match with Firstname");
				}
				else if(city.equalsIgnoreCase(middlename)){
					errors.rejectValue("city","errors.city.lowerm","City not match with Middlename");
				}
				else if(city.equalsIgnoreCase(lastname)){
					errors.rejectValue("city","errors.city.lowerl","City not match with Lastname");
				}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					}
				
	}

}
