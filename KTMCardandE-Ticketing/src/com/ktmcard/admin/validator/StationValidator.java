package com.ktmcard.admin.validator;









import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



import com.ktmcard.admin.bean.StationBean;



public class StationValidator implements Validator{

	@Override
	public boolean supports(Class<?> ee) {
		// TODO Auto-generated method stub
		return  StationBean.class.isAssignableFrom(ee);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StationBean sb=(StationBean)target;
		String sname=sb.getStationname();
		String scode=sb.getStationcode();
		
		//------------------------------Station name-------------------------------
		
				sname=sname.trim();
				sname=sname.replaceAll("\\s+", "");
				//name = name.replace(" ", "");
				sname=WordUtils.capitalizeFully(sname);
				sb.setStationname(sname);
				
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
				sb.setStationcode(scode);
				
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
		
	}

}