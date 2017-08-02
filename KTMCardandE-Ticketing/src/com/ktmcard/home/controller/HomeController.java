package com.ktmcard.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktmcard.admin.bean.LoginBean;
import com.ktmcard.admin.bean.TrainsBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.TrainsModel;
import com.ktmcard.counter.service.ServiceCounter;
import com.ktmcard.home.bean.Registration;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.home.service.HomeService;
import com.ktmcard.home.validator.Forgotpasswordvalidator;
import com.ktmcard.home.validator.HomeFindTrainsValidator;
import com.ktmcard.home.validator.KtmCardValidator;
import com.ktmcard.home.validator.RegistrationValidator;
import com.ktmcard.user.service.UserService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	private Logger log = Logger.getLogger(HomeController.class);

	
	@Autowired
	private HomeService homeservice;
	
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private ServiceCounter servicecounter;
	
	@Autowired
	private UserService userservice;
	
	
	
	
	@Autowired
	private HttpSession ses;
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView aboutus() {
try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::aboutus",e);
	}
		return new ModelAndView("aboutus1");
	}
	
	@RequestMapping(value = "/RegisterAdmin", method = RequestMethod.GET)
	public ModelAndView RegisterAdmin(@ModelAttribute("command")Registration rg, BindingResult result) {
		
		try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::RegisterAdmin",e);
	}
		return new ModelAndView("RegisterAdmin1");
	}
	
	
	

	// Session expired
			@RequestMapping(value = "/psessionexpire", method = RequestMethod.GET)
			public ModelAndView sessionexpforsup() {
				
				return new ModelAndView("sessionexpforsup1");
			}
			@RequestMapping(value = "/sessionexpire", method = RequestMethod.GET)
			public ModelAndView sessionexp() {
				
				return new ModelAndView("sessionexp");
			}
			
	@SuppressWarnings("unused")
	@RequestMapping(value = "/registersuccess", method = RequestMethod.POST)
	public ModelAndView registersuccess(@ModelAttribute("command")Registration rg, BindingResult result,RegistrationModel rmdl) {
		try{
		System.out.println("enter register controller..");
		RegistrationValidator r=new RegistrationValidator();
		r.validate(rg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("RegisterAdmin1");
		}
		else{
		List<RegistrationModel> li=homeservice.registerlist();
		System.out.println("list size..."+li.size());
		
		if(li.size()==0){
		rmdl.setType("Admin");
		rmdl.setStatus("Pending");
		homeservice.addregistration(rmdl);
		}
		else{
			rmdl.setType("User");
			rmdl.setStatus("Pending");
			homeservice.addregistration(rmdl);
		}
		String umne=rg.getUsername();
		String pwd=rg.getPassword();
		System.out.println("username..."+umne);
		System.out.println("pwd.."+pwd);
		final String Username = "schimaticsoft@gmail.com";
		final String Password = "Naresh@5009";
		
		String r1 = null;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
			        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			           return new PasswordAuthentication(
			            		"schimaticsoft@gmail.com", "Naresh@5009");
			        }
			});

		try {
			String status ="Approved";
			String url = "http://localhost:8225/KTMCardandE-Ticketing/mailapproveregister.html?unme="+umne+"&status="+status;
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(
							rg.getEmail()));
		
			message.setSubject("You are Registered successfully!");
			message.setText("Your username  is : "
					+rg.getUsername()
					+ " \nYour Password is:"
					+ rg.getPassword()
					+"\n"
					+url
					+"\n click this link to activate your account"
					);
			 Transport.send(message);						
			System.out.println("mail sent successfuly");
			
		} catch (MessagingException e1) {
			throw new RuntimeException(e1);
		}
		
	System.out.println("registration is success");
		
		
		
		return new ModelAndView("registersuccess1");
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::registersuccess",e);
	}
		return null;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="mailapproveregister", method = RequestMethod.GET)
	public ModelAndView mailapprove(@ModelAttribute("command") Registration reg,HttpServletRequest request) {
		try{
		System.out.println("enter....mail approve...");
		String status = request.getParameter("status");
		String unme = request.getParameter("unme");
		String pwd=request.getParameter("pwd");
		System.out.println("status.."+status);
		System.out.println("username..."+unme);
		
		homeservice.statuschange(unme,status);
		System.out.println("end sts...");
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::mailapproveregister",e);
	}
		return new ModelAndView("login1");
	}
	
	@RequestMapping(value="/usernameuniquehome",method=RequestMethod.GET)
	public void usernameunique(@ModelAttribute("command")Registration r,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		try{
		System.out.println("enter unique username....");
		PrintWriter out=response.getWriter();
		List<RegistrationModel> li=homeservice.usernameuniquelist();
		System.out.println("list in unique.."+li.size());
		Iterator<RegistrationModel> i=li.iterator();
		String undb=null;
		while(i.hasNext()){
			
			RegistrationModel ul=(RegistrationModel) i.next();
			System.out.println("size..."+ul.getUsername());
			if(undb==null){
				undb=ul.getUsername();
			}
			
			else{
				undb=undb+","+ul.getUsername();
			}
		}
		out.println(undb);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::usernameuniquehome",e);
	}
		}
	@RequestMapping(value="/emailduniquehome",method=RequestMethod.GET)
	public void emailduniquehome(@ModelAttribute("command")Registration r,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		try{
		System.out.println("enter unique email....");
		PrintWriter out=response.getWriter();
		List<RegistrationModel> li=homeservice.emailuniquelist();
		System.out.println("list in unique.."+li.size());
		Iterator<RegistrationModel> i=li.iterator();
		String undb=null;
		while(i.hasNext()){
			
			RegistrationModel ul=(RegistrationModel) i.next();
			System.out.println("size..."+ul.getEmail());
			if(undb==null){
				undb=ul.getEmail();
			}
			
			else{
				undb=undb+","+ul.getEmail();
			}
		}
		out.println(undb);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::emailduniquehome",e);
	}
		}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginpage(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout,ModelAndView model)
	{
	try{	
		if (error!= null) {
			model.addObject("error", "Invalidd Username and Password");
			System.out.println("Error is not null : so error is adding in the "
					+ "mylogin controller : error:" + error + ":");
			
		}
		
		model.setViewName("login1");
		model.addObject("command",new Registration());
		return model;
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::HomeController ::login",e);
}
	return model;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/logsuc", method = RequestMethod.GET)
	public ModelAndView logsuc(@ModelAttribute("command")LoginBean lg,BindingResult result,HttpServletResponse response,HttpServletRequest request,Principal prince) throws IllegalAccessException, InvocationTargetException {
		try{
		
		/*String un=lg.getUsername();
		String pwd=lg.getPassword();*/
		lg.setUsername(prince.getName());
		RegistrationModel reg=new RegistrationModel();
		BeanUtils.copyProperties(lg,reg);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   		//String un = auth.getName();
   		//String pwd = (String) auth.getCredentials();              // Getting Password
   		String un=prince.getName();
   		lg.setUsername(un);
   		//lg.setPassword(pwd);
		System.out.println("username..."+un);
		//System.out.println("password..."+pwd);
		List<RegistrationModel> lp=homeservice.loginusername(un);
		
	//String ppss=lp.get(0).get
		@SuppressWarnings("rawtypes")
		//List li=homeservice.loginlist(lg);
		//System.out.println("list login.."+li.size());
		HttpSession s=request.getSession();
		
		 
		if(lp.size()>0){
			String ppsreg=lp.get(0).getPassword();
			System.out.println("list..lp"+lp.size());
			 s.setAttribute("username", un);
			 s.setAttribute("password", ppsreg);
				s.setMaxInactiveInterval(60*20);

			@SuppressWarnings("unchecked")
			Iterator<RegistrationModel> i=lp.iterator();
			while(i.hasNext()){
				RegistrationModel rm=(RegistrationModel) i.next();
				String tp= rm.getType();
				String ts=rm.getStatus();
			 
		if(tp.matches("Admin")){
		return new ModelAndView("adminhome");
		}
		
		else if(tp.matches("User")){
			System.out.println("enter into userlogin in controller");
			return new ModelAndView("userlogin1");

			}
		}
	}
		
		List<CounterModel> lcp=homeservice.logincounterusername(un);
		//List<CounterModel> lis=homeservice.loginlist(un,pwd);
		//System.out.println("listtttt login.."+lis.size());
		if(lcp.size()>0){
			String passct=lcp.get(0).getPassword();

			s.setAttribute("username", un);
			 s.setAttribute("password", passct);

			Iterator<CounterModel> i=lcp.iterator();
			while(i.hasNext()){
				CounterModel rm=(CounterModel) i.next();
				String tp= rm.getType();
		
			 
				    if(tp.matches("Counter")){
					return new ModelAndView("counterlogin1");
			       }
		   }
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::logsuc",e);
	}
		return new ModelAndView("loginfailure1");
	}
	
	//Denied page
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		try{
			System.out.println("Running Denied page");
	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName("denied1");
	  return model;
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::denied",e);
	}
		return null;
}
	
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView forgotpassword(@ModelAttribute("command")Registration reg,BindingResult result) {
		try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::forgotpassword",e);
	}
		return new ModelAndView("forgotpassword1");
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/checkforgotpassword", method = RequestMethod.POST)
	public ModelAndView checkforgotpassword(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws AddressException, MessagingException {
		try{
		String username=reg.getUsername();
		String emailid=reg.getEmail();
		System.out.println("username for forgotpassword......"+reg.getUsername());
		System.out.println("email for forgotpassword......"+reg.getEmail());
		List<RegistrationModel> li=homeservice.forgotpasswordlist(username,emailid);
		System.out.println("FORGOT PWD LIST...."+li.size());
		
		
		/*List<CounterModel> lc=homeservice.counterforgotpaswordlist(username,emailid);
		System.out.println("counter forgot list.."+li.size());
		String pwd1=lc.get(0).getPassword();
		System.out.println("password in counter.."+pwd1);*/
		Forgotpasswordvalidator r=new Forgotpasswordvalidator();
		r.validate(reg, result);
		
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("forgotpassword1");
		
		}
			else if(li.size()==1){
				String pwd=li.get(0).getPassword();
		System.out.println("email in forgot pswd list...."+emailid);
		System.out.println("password in forgot pswd list...."+pwd);
		final String Username = "schimaticsoft@gmail.com";
		final String Password = "Naresh@5009";
		
		String r1 = null;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
			        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			           return new PasswordAuthentication(
			            		"schimaticsoft@gmail.com", "Naresh@5009");
			        }
			});


			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(
							emailid));
		
			message.setSubject("Forgot Password for your account");
			message.setText("Your Password is:"
					+ pwd
					);
			 Transport.send(message);						
			System.out.println("mail sent successfuly");
			return new ModelAndView("checkforgotpassword1");

			}

		/*else if(lc.size()==1){
			System.out.println("enter supp team..");
			
			System.out.println("email in forgot pswd list...."+emailid);
			System.out.println("password in forgot pswd list...."+pwd1);
			final String Username = "schimaticsoft@gmail.com";
			final String Password = "Naresh@5009";
			
			String r1 = null;
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getDefaultInstance(props, 
				    new javax.mail.Authenticator(){
				        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				           return new PasswordAuthentication(
				            		"schimaticsoft@gmail.com", "Naresh@5009");
				        }
				});

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(Username));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(
								emailid));
			
				message.setSubject("Forgot Password for your account");
				message.setText("Your Password is:"
						+ pwd1
						);
				 Transport.send(message);						
				System.out.println("mail sent successfully");
				
			 
		System.out.println("mail send success for forgot password");
			
		
			return new ModelAndView("checkforgotpassword1");

		}*/

		
		else{
			return new ModelAndView("forgotpassworderror");
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::checkforgotpassword",e);
	}
		return null;
	}
	
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView contactus() {
		try{}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::contactus",e);
	}
		return new ModelAndView("contactus1");
	}
	/*@RequestMapping(value = "/applycard", method = RequestMethod.GET)
	public ModelAndView applycard(@ModelAttribute("command")ApplyCardBean aplybn, BindingResult result) {
		
		return new ModelAndView("applycard1");
	}
	@RequestMapping(value = "/applycardtopuppage", method = RequestMethod.GET)
	public ModelAndView applycardtopuppage(@ModelAttribute("command")ApplyCardBean aplybn, BindingResult result) {
		
		return new ModelAndView("applycardtopuppage1");
	}*/
	/*@RequestMapping(value = "/creditcard", method = RequestMethod.GET)
	public ModelAndView creditcard() {
		
		return new ModelAndView("creditcard1");
	}
	@RequestMapping(value = "/debitcard", method = RequestMethod.GET)
	public ModelAndView debitcard() {
		
		return new ModelAndView("debitcard1");
	}
	@RequestMapping(value = "/netbanking", method = RequestMethod.GET)
	public ModelAndView netbanking() {
		
		return new ModelAndView("netbanking1");
	}*/
	@RequestMapping(value = "/homepaymentsuccess", method = RequestMethod.GET)
	public ModelAndView homepaymentsuccess() {
		try{}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::HomeController ::homepaymentsuccess",e);
	}
		return new ModelAndView("homepaymentsuccess1");
	}
	// book ticket using KTM card
	
		@RequestMapping(value = "/cardbookticket", method = RequestMethod.GET)
		public ModelAndView cardbookticket(@ModelAttribute("command")TrainsBean tcb,BindingResult result) {
			try{}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::cardbookticket",e);
		}
			return new ModelAndView("cardbookticket");
		}
		
		// search between trains
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/cardtrainsearch1", method = RequestMethod.POST)
		public ModelAndView cardticketsearch(@ModelAttribute("command")TrainsBean tcb,BindingResult result) {
			try{
			System.out.println("enter into cardtrainsearch in home controller");
			String cardnumber=tcb.getCardid();
			KtmCardValidator r=new KtmCardValidator();
			r.validate(tcb,result);
			if(result.hasErrors())
			{
				return new ModelAndView("cardbookticket");	
				
			}
			else
			{
			
			System.out.println("the card nuber is........."+cardnumber);
			ses.setAttribute("ktmcardnumber",cardnumber);
			List li=homeservice.verifingcardnumber(cardnumber);
			System.out.println("the list size is............"+li.size());
			
			
			if(li.size()>0)
			{
				
				return new ModelAndView("cardtrainsearch2");	
				
			}
			
			else{
				return new ModelAndView("cardfailurepage2");	
			}
			}
			}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::cardtrainsearch1",e);
		}
			return null;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value = "/findtraincountersucc1", method = RequestMethod.GET)
		public ModelAndView findtraincountersucc(@ModelAttribute("command")TrainsBean tb,BindingResult result,HttpServletRequest request) {
			try{
			HomeFindTrainsValidator f=new HomeFindTrainsValidator();
			f.validate(tb, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("cardtrainsearch2");
			}
			else{
			System.out.println("coming to cccccnnnnnnnnnnnnttrrrrrrlllllll");
			String s=tb.getSource();
			System.out.println("coming to cccccnnnnnnnnnnnnttrrrrrrlllllll" +s);
			String d=tb.getDestination();
			request.getSession().setAttribute("source", s);
			request.getSession().setAttribute("destination", d);
			List li=servicecounter.gettrainsserach();
			System.out.println("List size is::::::::::::::::"+li.size());
			List lc=new ArrayList();
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				TrainsModel tm = (TrainsModel) iterator.next();
				
				/*if(s.equals(tm.getSource()) && d.equals(tm.getDestination()))
				{
					System.out.println("coming to first looopppppppp");
					lc.add(tm);
				}
				System.out.println("before second loop is:::::::::::" +tm.getStations());*/
				
				if(tm.getStations().contains(s) && tm.getStations().contains(d))
				{
				System.out.println("coming to second looppppp");
				String[] routeMap1=tm.getStations().split(",");
				int srcVal=Arrays.asList(routeMap1).indexOf(s);
				int desVal=Arrays.asList(routeMap1).indexOf(d);
				String[] distances=tm.getDistancefromsource().split(",");
				String sdfr=distances[srcVal];
				String ddfr=distances[desVal];
				int i=Integer.parseInt(ddfr);
			    int h=Integer.parseInt(sdfr);
				int q=i-h;
				int l=Integer.parseInt(tm.getBasefare());
				int v=q*l;
				String p=Integer.toString(v);
				System.out.println("the source count is:::::::" +srcVal);
				System.out.println("the destination count is:::::::" +desVal);
				System.out.println("the source count is:::::::" +sdfr);
				System.out.println("the destination count is:::::::" +ddfr);
				String al=p+"@"+tm.getTrainnumber();
				String tn=tm.getTrainnumber();
				if(srcVal<desVal)
				{
					System.out.println("coming to crct format::::::::::::::::::::::");
					String ag="<input type='button' name='"+al+"' id='btn' class='text-button' value='Ticket' onclick='getmenubyusername(this.name);' />";
					String sl="<input type='button' name='"+tn+"' id='btn' class='text-button' value='"+tn+"'  onclick='gettrainstopdetails(this.name);' />";
					tm.setTrainnumber(sl);
					tm.setBtn(ag);
					lc.add(tm);
				}
				}


			}
			if(lc.size()>0)
			{
				
			}
			else
			{
				result.rejectValue("destination","destination.invalid.regex","Trains are Not Available");
				return new ModelAndView("cardtrainsearch2");

			}
			request.getSession().setAttribute("trainslistt", lc);
			return new ModelAndView("findtrainscountersuccess2");
			}
			}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::findtraincountersucc1",e);
		}
			return null;
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/journytkt1", method = RequestMethod.GET)
		public ModelAndView journytkt(@ModelAttribute("command") TrainsBean tb,HttpServletRequest request) {
			try{
			System.out.println("enter into journytkt1 in home controller");
			String y=request.getParameter("r");
			String k=request.getParameter("w");
			System.out.println("the fare iss:::::" +y);
			ses.setAttribute("faredetails",y);
			System.out.println("the trainnumbver is::::::" +k);
			String s=(String) request.getSession().getAttribute("source");
			String d=(String) request.getSession().getAttribute("destination");
			String cardnumber=(String) ses.getAttribute("ktmcardnumber");
			System.out.println("The card number is.........."+cardnumber);
			List li=homeservice.verifingcardnumber(cardnumber);
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				ApplyCardModel acm = (ApplyCardModel) iterator.next();
				String balance=acm.getBalance();
				System.out.println("The balance is................."+balance);
				int balance1=Integer.valueOf(balance);
				int updatebalance=balance1-Integer.parseInt(y);
				System.out.println("the update balance is..........."+updatebalance);
				
				if(updatebalance<0)
				{
					return new ModelAndView("insufficentbalpage1");	
				}
			}
			tb.setSource(s);
			tb.setDestination(d);
			tb.setBasefare(y);
			 Random randomGenerator = new Random();
			      int randomInt = randomGenerator.nextInt(100000000);
			      String rn=Integer.toString(randomInt);
			tb.setBtn(rn);
			}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::journytkt1",e);
		}
			return new ModelAndView("jurneyperformtkt1");
		}
		
		@SuppressWarnings({ "unused", "rawtypes" })
		@RequestMapping(value = "/confrmticketcounter1", method = RequestMethod.GET)
		public @ResponseBody String confrmticketcounter(TrainsBean tb,HttpServletRequest request)
		{
			try{
			System.out.println("enter into confrmticketcounter1 in home controller");
			String s=(String) request.getSession().getAttribute("source");
			String d=(String) request.getSession().getAttribute("destination");
			System.out.println("the sssssssssssssssrceeeeeeeee is::::::" +s);
			System.out.println("the dstnnnnnnnnnnnnnnnnnnnnnnnnnnn is::::::" +d);
			String sn=request.getParameter("numr");
			String fr=request.getParameter("fr");
			String fare=(String) ses.getAttribute("faredetails");
			int fare1=Integer.valueOf(fare);
			System.out.println("The fare detail are......................."+fare1);
			String cardnumber=(String) ses.getAttribute("ktmcardnumber");
			System.out.println("The card number is.........."+cardnumber);
			
			
			List li=homeservice.verifingcardnumber(cardnumber);
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				ApplyCardModel acm = (ApplyCardModel) iterator.next();
				String balance=acm.getBalance();
				System.out.println("The balance is................."+balance);
				int balance1=Integer.valueOf(balance);
				int updatebalance=balance1-fare1;
			
				String upb=Integer.toString(updatebalance);
				System.out.println("The update balance is..........."+updatebalance);
				
				homeservice.updatecardticketbalance(upb,cardnumber);
				
				
			}
			
			/*TicketModel tm=new TicketModel();
			tm.setTicketnumber(sn);
			tm.setSource(s);
			tm.setDestination(d);
			tm.setFare(fr);
			Date today = new Date();
			SimpleDateFormat formatter5 = new SimpleDateFormat("MM/dd/yyyy");
			String formats1 = formatter5.format(today);
			System.out.println("the tkt date isss::::::::::::::::::" +formats1);
			tm.setTktdate(formats1);
			String un=(String) request.getSession().getAttribute("username");
			System.out.println("the username issss:::::::::::" +un);
			tm.setCounterusername(un);
			servicecounter.savetktdetails(tm);*/
		
			return s;
			}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::confrmticketcounter1",e);
		}
			return null;
		}

		
		@RequestMapping(value = "/cardbooksearch", method = RequestMethod.GET)
		public ModelAndView cardbooksearch() {
			try{}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::cardbooksearch",e);
		}
			return new ModelAndView("cardbooksearch");
		}
		
		@RequestMapping(value = "/cardbookticketcounter", method = RequestMethod.GET)
		public ModelAndView cardbookticketcounter() {
			try{}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::HomeController ::cardbookticketcounter",e);
		}
			return new ModelAndView("cardbookticketcounter");
		}
		
		
}
