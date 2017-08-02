package com.ktmcard.user.validator;

import java.util.Set;





import org.springframework.validation.Errors;


import com.ktmcard.user.bean.CardPaymentBean;

public class ViewBalanceValidator implements org.springframework.validation.Validator{

	public boolean supports(Class<?> clazz) {
		return CardPaymentBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CardPaymentBean  r=(CardPaymentBean)target;
		
String cardnumber=r.getCardnumber(); 
cardnumber=cardnumber.replaceAll(" ","");
r.setCardnumber(cardnumber.trim());


if(cardnumber.trim().equals("")){
	errors.rejectValue("cardnumber","errors.cardnumber.required","Cardnumber is required");
}
else if(!cardnumber.matches("^[0-9 ]+$")){
errors.rejectValue("cardnumber","errors.cardnumber.acceptcharacters","Cardnumber accepts only Numbers");
}
else if(!(cardnumber.length()==12)){
errors.rejectValue("cardnumber","errors.cardnumber.length","CardNumber length should be 12 numbers");
}
	

}
}
