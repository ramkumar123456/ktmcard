package com.ktmcard.session;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd=null;
	    String path = request.getServletPath();
	    System.out.println("The Path is : "+path);
	    if(path.equals("/index.html")||path.equals("/aboutus.html")||path.equals("/RegisterAdmin.html")||path.equals("/registersuccess.html")||path.equals("/mailapproveregister.html")||path.equals("/usernameuniquehome.html")||path.equals("/emailduniquehome.html")||path.equals("/login.html")
	    		||path.equals("/logsuc.html")||path.equals("/forgotpassword.html")||path.equals("/contactus.html")||path.equals("/homepaymentsuccess.html")||path.equals("/cardbookticket.html")||path.equals("/cardtrainsearch1.html")||path.equals("/registersuccess.html")
	    		||path.equals("/findtraincountersucc1.html")||path.equals("/journytkt1.html")||path.equals("/confrmticketcounter1.html")||path.equals("/cardbooksearch.html")||path.equals("/cardbookticketcounter.html")||path.equals("/counterlogin.html")||path.equals("/counterhome.html")
	    		||path.equals("/bookticket.html")||path.equals("/booksearch.html")||path.equals("/conformtrain.html")||path.equals("/conformticket.html")||path.equals("/payment.html")||path.equals("/counterapplycard.html")||path.equals("/counterapplycardtopup.html")
	    		||path.equals("/counteraplycardsus1.html")||path.equals("/cardpaymentsuccess.html")||path.equals("/tickets.html")||path.equals("/cancelticket.html")||path.equals("/counterupdateprofile.html")||path.equals("/updatecountersucc.html")||path.equals("/counterchangepassword.html")
	    		||path.equals("/counterlogout.html")||path.equals("/bookticketcounter.html")||path.equals("/printjourneytkt.html")||path.equals("/findtrainscounter.html")||path.equals("/findtraincountersucc.html")||path.equals("/journytkt.html")||path.equals("/confrmticketcounter.html")
	    		||path.equals("/tktscount.html")||path.equals("/trainstopdetails.html"))
	
	    {
			
			 chain.doFilter(request, response);
			 
	
		}
		else
		{
			String username = null;
			try
			{
				 HttpSession as = request.getSession(false);
				 username = (String) as.getAttribute("username");
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			if(username==null)
			{
				if(path.equals("/adminlogin.html")||path.equals("/adminhome.html")	||path.equals("/counters.html")||path.equals("/addcounter.html")||path.equals("/addcountersucc.html")||path.equals("/addcountre_userunique.html")
						||path.equals("/CounterDisplayGrid.html")||path.equals("/requestedcards.html")||path.equals("/adrequsedcards.html")||path.equals("/finding.html")||path.equals("/deletecard999.html")||path.equals("/approvecard999.html")
						||path.equals("/rejectcard999.html")||path.equals("/approvedcardsuccess.html")||path.equals("/rejectcardsuccess.html")||path.equals("/updatecounter.html")||path.equals("/updatecountersuccs.html")||path.equals("/deletecounter.html")
						||path.equals("/counter_searchstationcode.html")||path.equals("/station_searchcode.html")||path.equals("/trainidsearch.html")||path.equals("/adminupdateprofile.html")||path.equals("/adminupdateprofilesucc.html")
						||path.equals("/adminchangepassword")||path.equals("/adminchangepwdsucc.html")||path.equals("/adminlogout.html")||path.equals("/viewstations.html")||path.equals("/stationsgrid.html")
						||path.equals("/addstation.html")||path.equals("/addstationsave.html")||path.equals("/uniquestations.html")||path.equals("/uniquestationcode.html")||path.equals("/uniquestationcode.html")||path.equals("/editstation.html")||path.equals("/updatestationsucc.html")
						||path.equals("/deletestation.html")||path.equals("/viewtrainsgrid.html")||path.equals("/addtrains.html")||path.equals("/edittrain.html")||path.equals("/deletetrain.html")||path.equals("/ktm_Stations.html")||path.equals("/ktm_StationsCode.html")
						||path.equals("/addtrainssavesave.html")||path.equals("/updatetrains1.html")||path.equals("/viewtrains.html")||path.equals("/userhome1.html")||path.equals("/userupdate1.html")||path.equals("/usereditsave1.html")||path.equals("/changepassword1.html")
						||path.equals("/userchangepasssus1.html")||path.equals("/bookticket11.html")||path.equals("/trainslist1.html")||path.equals("/bookticketuser.html")||path.equals("/faredetails1.html")||path.equals("/bookingnow1.html")||path.equals("/paymentmodepage1.html")
						||path.equals("/ktmcard1.html")||path.equals("/paymentrechargesuccess.html")||path.equals("/homepaymentsuccess1.html")||path.equals("/creditcard1.html")||path.equals("/debitcard1.html")||path.equals("/netbanking1.html")||path.equals("/creditcardrecharge.html")
						||path.equals("/debitcardrecharge.html")||path.equals("/netbankingrecharge.html")||path.equals("/rechargecard1.html")||path.equals("/rechargepaymentpage1.html")||path.equals("/creditcard111.html")||path.equals("/debitcard111.html")||path.equals("/netbanking111.html")
						||path.equals("/rechargesus1.html")||path.equals("/topuptransactions1.html")||path.equals("/topuptxs.html")||path.equals("/viewbalance1.html")||path.equals("/availablebalance1.html")||path.equals("/applycard.html")||path.equals("/applycardtopuppage.html")
						||path.equals("/paymentpage1.html")||path.equals("/creditcard.html")||path.equals("/debitcard.html")||path.equals("/netbanking.html")||path.equals("/aplpaymentsuccess1.html")||path.equals("/cardstatus1.html")||path.equals("/showcardstatus.html")
						||path.equals("/adminlogout.html"))
				{
					rd=request.getRequestDispatcher("psessionexpire.html");
			        rd.forward(request,response);
				}
			
				else
				{
					rd=request.getRequestDispatcher("sessionexpire.html");
					rd.forward(request,response);
				}
				
			}
			else
			{
				chain.doFilter(request, response);
			}
			
		}
	    
	

}
}
