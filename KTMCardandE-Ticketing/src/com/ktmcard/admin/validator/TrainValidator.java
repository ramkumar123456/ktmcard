package com.ktmcard.admin.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ktmcard.admin.bean.TrainsBean;


public class TrainValidator implements Validator{

	@Override
	public boolean supports(Class<?> ee) {
		return  TrainsBean.class.isAssignableFrom(ee);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TrainsBean tb=(TrainsBean)target;
		String tnum=tb.getTrainnumber();
		String src=tb.getSource();
		String dest=tb.getDestination();
		String arltme=tb.getArrivaltime();
		String dpttme=tb.getDeparturetime();
		System.out.println(dpttme);
		String tkm=tb.getTotalkms();
		String bsefre=tb.getBasefare();
		String stops=tb.getNumberofstops();
		
		
		if(tnum==null||tnum=="" ||tnum.matches("[\\s]+"))
		{
			
			errors.rejectValue("trainnumber", "trainnumber","Trainnumber is required");

		}
		if(src==null||src=="" ||src.matches("[\\s]+"))
		{
			
			errors.rejectValue("source", "source","Source is required");

		}
		if(dest==null||dest=="" ||dest.matches("[\\s]+"))
		{
			
			errors.rejectValue("destination", "destination","Destination is required");

		}
		else if(src==dest){
			errors.rejectValue("destination", "destinationsame","Destination/Source Should not be same");

		}
		if(arltme==null||arltme=="" ||arltme.matches("[\\s]+"))
		{
			
			errors.rejectValue("arrivaltime", "arrivaltime","Arrivaltime is required");

		}
		if(dpttme==null||dpttme=="" ||dpttme.matches("[\\s]+"))
		{
			
			errors.rejectValue("departuretime", "departuretime","Departuretime is required");

		}
		if(tkm==null||tkm=="" ||tkm.matches("[\\s]+"))
		{
			
			errors.rejectValue("totalkms", "totalkms","Totalkms is required");

		}
		if(bsefre==null||bsefre=="" ||bsefre.matches("[\\s]+"))
		{
			
			errors.rejectValue("basefare", "basefare","Basefare is required");

		}
		if(stops==null||stops=="" ||stops.matches("[\\s]+"))
		{
			
			errors.rejectValue("numberofstops", "numberofstops","Number Of Stops is required");

		}
		
	}

}
