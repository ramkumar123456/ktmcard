package com.ktmcard.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktmcard.admin.validator.Changepasswordvalidator;
import com.ktmcard.counter.bean.BookticketBean;
import com.ktmcard.home.bean.ApplyCardBean;
import com.ktmcard.home.bean.Registration;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.home.validator.ApplyCardValidator;
import com.ktmcard.home.validator.RegistrationValidator;
import com.ktmcard.user.bean.CardPaymentBean;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;
import com.ktmcard.user.service.UserService;
import com.ktmcard.user.validator.CardPaymentValidator;
import com.ktmcard.user.validator.RechargePageValidator;
import com.ktmcard.user.validator.TopUpValidator;
import com.ktmcard.user.validator.ViewBalanceValidator;


@Controller
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userservice;
	
	@Autowired
	private HttpSession ses;
	
	@Autowired
	private HttpServletRequest req;
	
	

	
	@RequestMapping(value="/userhome1",method= RequestMethod.GET)
	public ModelAndView adhome1()
{
try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::userhome1",e);
	}
		return new ModelAndView("userhome2");
		
	}
	
	
	@RequestMapping(value="/userupdate1",method= RequestMethod.GET)
	public ModelAndView userupdate1(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
   {
		try{
		System.out.println("enter into userupdate1 requestmapping");
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("in session un"+username);
		System.out.println("in session pwd"+password);
		RegistrationModel rm=null;
		List<RegistrationModel> li=userservice.loginlist(username,password);
		System.out.println("list for login..."+li.size());
		System.out.println("list for login..."+li.size());
		Integer i=li.get(0).getId();
		String st=li.get(0).getStatus();
		String tp=li.get(0).getType();
		reg.setId(i);
		reg.setStatus(st);
		reg.setType(tp);
		System.out.println("id.."+i);
		for (Iterator<RegistrationModel> iterator = li.iterator(); iterator.hasNext();) {
			rm = (RegistrationModel) iterator.next();
			
		}
		BeanUtils.copyProperties(reg, rm);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::userupdate1",e);
	}
		
		return new ModelAndView("userupdate2");
		
	}
	
	
	
	@RequestMapping(value="/usereditsave1",method= RequestMethod.POST)
	public ModelAndView admineditsave1(@ModelAttribute("command")Registration reg,BindingResult result,RegistrationModel rm,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
   {
		try{
		System.out.println("enter into usereditsave1 requestmapping");
		System.out.println("enter update success..");
		System.out.println(reg.getFirstname());
		System.out.println(reg.getCity());
		BeanUtils.copyProperties(rm, reg);
		System.out.println(reg.getId());
		RegistrationValidator r=new RegistrationValidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("userupdate2");
		}
		userservice.updateuserprofile(rm);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::usereditsave1",e);
	}
		return new ModelAndView("usereditsave2");
		
	}
	
	@RequestMapping(value="/changepassword1",method= RequestMethod.GET)
	public ModelAndView changepassword1(@ModelAttribute("command")Registration reg, BindingResult result,HttpServletRequest request)
   {
		try{
		System.out.println("enter into changepassword1 requestmapping");
		HttpSession hs=request.getSession(false);
		
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("username...."+username);
		System.out.println("password....."+password);
		List<RegistrationModel> li=userservice.loginlist(username, password);
		System.out.println(li.size());
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::changepassword1",e);
	}
		return new ModelAndView("changepassword2");
		
	}
	
	@RequestMapping(value="/userchangepasssus1",method= RequestMethod.POST)
	public ModelAndView userchangepasssus1(@ModelAttribute("command")Registration reg, BindingResult result,HttpServletRequest request)
   {
		try{
		Changepasswordvalidator r=new Changepasswordvalidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("changepassword2");
		}
		else{
		System.out.println("enter into userchangepasssus1 requestmapping");
		String opd=reg.getOldpassword();
		String npd=reg.getPassword();
		String cnpd=reg.getConformpassword();
		System.out.println("oldp..."+opd);
		System.out.println("npd..."+npd);
		System.out.println("cnpd..."+cnpd);
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("username...."+username);
		System.out.println("password....."+password);

		
		if(opd.equalsIgnoreCase(password)){
		userservice.changepassword(username,npd,cnpd);
		userservice.changepasswordlist(username,npd);
		return new ModelAndView("userchangepasssus2");
		}
		else {
			return new ModelAndView("userchangepassworderror");
		}
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::userchangepasssus1",e);
	}
		return null;
	}
	
	
	@RequestMapping(value="/bookticket11",method= RequestMethod.GET)
	public ModelAndView bookticket11(@ModelAttribute("command")BookticketBean bt, BindingResult result)
   {
		try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::bookticket11",e);
	}
		return new ModelAndView("bookticket22");
		
	}
	
	
	@RequestMapping(value="/trainslist1",method= RequestMethod.GET)
	public ModelAndView trainslist1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::trainslist1",e);
	}
		return new ModelAndView("trainslist2");
		
	}/*faredetails1.html*/
	@RequestMapping(value="/bookticketuser",method= RequestMethod.GET)
	public ModelAndView bookticketuser()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::bookticketuser",e);
	}		return new ModelAndView("bookticketuser1");
		
	}
	@RequestMapping(value="/faredetails1",method= RequestMethod.GET)
	public ModelAndView faredetails1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::faredetails1",e);
	}		return new ModelAndView("faredetails2");
		
	}
	
	@RequestMapping(value="/bookingnow1",method= RequestMethod.GET)
	public ModelAndView bookingnow1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::bookingnow1",e);
	}		return new ModelAndView("bookingnow2");
		
	}
	
	@RequestMapping(value="/paymentmodepage1",method= RequestMethod.GET)
	public ModelAndView paymentmodepage1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::paymentmodepage1",e);
	}		return new ModelAndView("paymentmodepage2");
		
	}
	
	@RequestMapping(value="/ktmcard1",method= RequestMethod.GET)
	public ModelAndView ktmcard1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::ktmcard1",e);
	}		return new ModelAndView("ktmcard2");
		
	}
	
	@RequestMapping(value="/paymentrechargesuccess",method= RequestMethod.POST)
	public ModelAndView paymentrechargesuccess()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::paymentrechargesuccess",e);
	}		return new ModelAndView("paymentrechargesuccess1");
		
	}
	
	@RequestMapping(value="/homepaymentsuccess1",method= RequestMethod.POST)
	public ModelAndView homepaymentsuccess1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::homepaymentsuccess1",e);
	}		return new ModelAndView("homepaymentsuccess2");
		
	}
	
	@RequestMapping(value="/creditcard1",method= RequestMethod.GET)
	public ModelAndView creditcard1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::creditcard1",e);
	}		return new ModelAndView("creditcard2");
		
	}
	
	
	@RequestMapping(value="/debitcard1",method= RequestMethod.GET)
	public ModelAndView debitcard1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::debitcard1",e);
	}		return new ModelAndView("debitcard2");
		
	}
	
	@RequestMapping(value="/netbanking1",method= RequestMethod.GET)
	public ModelAndView netbanking1()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::netbanking1",e);
	}		return new ModelAndView("netbanking2");
		
	}
	
	@RequestMapping(value="/creditcardrecharge",method= RequestMethod.GET)
	public ModelAndView creditcardrecharge()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::creditcardrecharge",e);
	}		return new ModelAndView("creditcardrecharge1");
		
	}
	@RequestMapping(value="/debitcardrecharge",method= RequestMethod.GET)
	public ModelAndView debitcardrecharge()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::debitcardrecharge",e);
	}		return new ModelAndView("debitcardrecharge1");
		
	}
	@RequestMapping(value="/netbankingrecharge",method= RequestMethod.GET)
	public ModelAndView netbankingrecharge()
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::netbankingrecharge",e);
	}		return new ModelAndView("netbankingrecharge1");
		
	}
	@RequestMapping(value="/rechargecard1",method= RequestMethod.GET)
	public ModelAndView rechargecard1(@ModelAttribute("command")ApplyCardBean acb, BindingResult result)
   {
try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::rechargecard1",e);
	}		return new ModelAndView("rechargecard2");
		
	}
	
	
	
	
	@RequestMapping(value="/rechargepaymentpage1",method= RequestMethod.POST)
	public ModelAndView rechargepaymentpage1(@ModelAttribute("command")ApplyCardBean acb, BindingResult result)
   {
		try{
		System.out.println("enter into rechargepaymentpage1 requestmapping");
		RechargePageValidator r=new RechargePageValidator();
				r.validate(acb, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("rechargecard2");
		}
		else
		{
		
		String cardid=acb.getFirstname();
		ses.setAttribute("rechcardid",cardid);
		
		System.out.println("the card is................."+cardid);
		
		String rechargeamount=acb.getMiddlename();
		ses.setAttribute("rechargeamount",rechargeamount);
		HttpSession hs=req.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("the amount is............"+rechargeamount);
		
		List li=userservice.checkusercard(cardid,username,password);
		
		System.out.println("The list size is.................."+li.size());
		
		if(li.size()>0){
			
			return new ModelAndView("paymentpage22");
		}
		else
		{
			return new ModelAndView("failurecardpage1");
		}
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::rechargepaymentpage1",e);
	}
		return null;
	}
	
	@RequestMapping(value = "/creditcard111", method = RequestMethod.GET)
	public ModelAndView creditcard111(@ModelAttribute("command")CardPaymentBean  acb, BindingResult result) {
		try{
		System.out.println("enter into creditcard111 in user controller");
		String credit="creditcard";
		ses.setAttribute("cardtype", credit);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::creditcard111",e);
	}
		return new ModelAndView("creditcard11");
	}
	
	@RequestMapping(value = "/debitcard111", method = RequestMethod.GET)
	public ModelAndView debitcard111(@ModelAttribute("command")CardPaymentBean  acb, BindingResult result) {
		try{
		System.out.println("enter into debitcard111 in user controller");
		String debit="debitcard";
		ses.setAttribute("cardtype",debit);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::debitcard111",e);
	}
		return new ModelAndView("debitcard11");
	}
	
	@RequestMapping(value = "/netbanking111", method = RequestMethod.GET)
	public ModelAndView netbanking111() {
try{}
catch (Exception e) {log.error(
		"KTMCard&Ticketing ::UserController ::netbanking111",e);
}
return new ModelAndView("netbanking11");
	}
	
	
	@RequestMapping(value = "/rechargesus1", method = RequestMethod.POST)
	public ModelAndView rechargesus1(@ModelAttribute("command")CardPaymentBean  cpb, BindingResult result) {
		try{
		System.out.println("enter into rechargesus1 in usercontroller");
		String cardtype=(String) ses.getAttribute("cardtype");
		System.out.println("The card type is.............."+cardtype);
		
		
		CardPaymentValidator r=new CardPaymentValidator();
		r.validate(cpb, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			
			if(cardtype.equals("debitcard"))
			{
				
				return new ModelAndView("debitcard11");
			}
			
			else
			{
				
				return new ModelAndView("creditcard11");
			}
		}
		
		else{	
		
		String rechargeamount=(String) ses.getAttribute("rechargeamount");
		System.out.println("The recharge amount is.............."+rechargeamount);
		String rechcard=(String) ses.getAttribute("rechcardid");
		System.out.println("The recharge card id is........."+rechcard);
		
		
		List li=userservice.getbalance(rechcard);
		System.out.println("the list size is.............."+li.size());
		ApplyCardModel acm=new ApplyCardModel();
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			 acm = (ApplyCardModel) iterator.next();
			String balance=acm.getBalance();
			System.out.println("The balance of card is.........."+balance);
			int bal = Integer.parseInt(balance);
			
			int updatedbalance=bal+Integer.parseInt(rechargeamount);
			String upbalance=Integer.toString(updatedbalance);
			ses.setAttribute("upbalance1",upbalance);
			System.out.println("The updated balance is............."+updatedbalance);
			userservice.updatebalance(updatedbalance,rechcard,rechargeamount);
			
			
			/*save recharge trnasactions*/
		/*	transcation number*/
			long min = 1000000000L; //10 digits inclusive
			long max = 10000000000L; //11s digits exclusive
			Random random = new Random();
			long number = min+((long)(random.nextDouble()*(max-min)));
			System.out.println("The 10 digit number transcation number  is.........."+number);
			String txid = Long.toString(number);
			ses.setAttribute("txid1",txid);
			
			/*reference id*/
			long min1 = 100000000L; //9 digits inclusive
			long max1 = 1000000000L; //10s digits exclusive
			Random random1 = new Random();
			long number1 = min1+((long)(random1.nextDouble()*(max1-min1)));
			System.out.println("The 10 digit number reference number is.........."+number1);
			String refid = Long.toString(number1);
			ses.setAttribute("refid1",refid);
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			String txdate=dateFormat.format(date);
			ses.setAttribute("txdate1",txdate);
			System.out.println("....The tx time is......."+txdate);
			
			UserRechargeTrasactionsModel urt=new UserRechargeTrasactionsModel();
			HttpSession hs=req.getSession(false);
			
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("username...."+username);
			System.out.println("password....."+password);
			
			urt.setCardid(rechcard);
			urt.setTopupid(refid);
			urt.setTxid(txid);
			urt.setBalance(upbalance);
			
			urt.setTopup(rechargeamount);
			urt.setDatetime(txdate);
			urt.setUsername(username);
			urt.setPassword(password);
			
			userservice.saveUserRechargetxmodel(urt);
			
			
		}
		
	/*	String refid=(String) ses.getAttribute("refid1");
		String upbalance=(String) ses.getAttribute("upbalance1");
		String txid=(String) ses.getAttribute("txid1");
		String txdate=(String) ses.getAttribute("txdate1");*/
		
		
		return new ModelAndView("rechargesus2");
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::rechargesus1",e);
		}
		return null;
	}
	
	
	
	@RequestMapping(value="/topuptransactions1",method= RequestMethod.GET)
	public ModelAndView topuptransactions1()
   {
   try{}
    catch (Exception e) {log.error(
		"KTMCard&Ticketing ::UserController ::topuptransactions1",e);
    }
      return new ModelAndView("topuptransactions2");
		
	}
	
	@RequestMapping(value = "/topuptxs", method = RequestMethod.GET)
	public void topups(@ModelAttribute("command")UserRechargeTrasactionsModel urtm, 
			BindingResult result,HttpServletResponse response,HttpSession ses,HttpServletRequest req) throws IOException {
		    try{
		System.out.println("enter into adcampsgrid request mapping");
		    PrintWriter out= response.getWriter();
		    HttpSession hs=req.getSession(false);
			
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("username...."+username);
			System.out.println("password....."+password);
		    
		    List camps=userservice.listoftransactions(username,password);
		    System.out.println("the list size is............."+camps);
		    
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"camps"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(camps,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
		  //  return array;
		    }
		    catch (Exception e) {log.error(
		    		"KTMCard&Ticketing ::UserController ::topuptxs",e);
		        }
			}

	/*view Balance.........*/
	@RequestMapping(value="/viewbalance1",method= RequestMethod.GET)
	public ModelAndView viewbalance1(@ModelAttribute("command")CardPaymentBean cpb,BindingResult result)
   {
		
    try{}
     catch (Exception e) {log.error(
		"KTMCard&Ticketing ::UserController ::viewbalance1",e);
    }
    return new ModelAndView("viewbalance2");
		
	}
	
	@RequestMapping(value="/availablebalance1",method= RequestMethod.POST)
	public ModelAndView availablebalance1(@ModelAttribute("command")CardPaymentBean cpb,BindingResult result)
   {
		try{
		System.out.println("enter into availablebalance1 requestmapping");
		ViewBalanceValidator r=new ViewBalanceValidator();
		r.validate(cpb, result);
		if(result.hasErrors()){
			System.out.println("error page.....");
			return new ModelAndView("viewbalance2");	
			
		}
		else{
		String balance;
	
		String cardid=cpb.getCardnumber();
		System.out.println("The card numer is.............."+cardid);
		HttpSession hs=req.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		
		System.out.println("username...."+username);
		System.out.println("password....."+password);
		List li=userservice.checkusercard(cardid,username,password);
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			ApplyCardModel acm = (ApplyCardModel) iterator.next();
			balance=acm.getBalance();
			System.out.println("The available balance is ..."+balance);
			ses.setAttribute("avbalance",balance);
		}
		
		System.out.println("The list size is.................."+li.size());
		if(li.size()>0)
		{
			
			return new ModelAndView("availablebalance2");	
		}
		else
		{
			return new ModelAndView("balancefailurepage2");	
			
		}
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::availablebalance1",e);
		    }
		return null;
   }

	
	/*Apply card process*/
	@RequestMapping(value = "/applycard", method = RequestMethod.GET)
	public ModelAndView applycard(@ModelAttribute("command")ApplyCardBean aplybn, BindingResult result) {
try{}
catch (Exception e) {log.error(
		"KTMCard&Ticketing ::UserController ::applycard",e);
    }
return new ModelAndView("applycard1");
	}
	
	
	@RequestMapping(value = "/applycardtopuppage", method = RequestMethod.POST)
	public ModelAndView applycardtopuppage(@ModelAttribute("command")ApplyCardBean acb, BindingResult result) throws IllegalAccessException, InvocationTargetException {
		try{
		System.out.println("enter into applycardtopuppage in controller");
		
		ApplyCardModel acm=new ApplyCardModel();
		
		ApplyCardValidator r=new ApplyCardValidator();
		r.validate(acb, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("applycard1");
		}
		else{
		BeanUtils.copyProperties(acm,acb);
		long min = 100000000000L; //12 digits inclusive
		long max = 1000000000000L; //13s digits exclusive
		Random random = new Random();
		long number = min+((long)(random.nextDouble()*(max-min)));
		System.out.println("The 12 digit number is.........."+number);
		String cardid = Long.toString(number);
		ses.setAttribute("cardid",cardid);
		System.out.println("111111111111111111111");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String regdate=dateFormat.format(date);
		System.out.println("....The logout time is......."+regdate);
		HttpSession hs=req.getSession(false);
		
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("username...."+username);
		System.out.println("password....."+password);
		
		acm.setCardid(cardid);
		acm.setUsername(username);
		acm.setPassword(password);
		acm.setRegisterdate(regdate);
		System.out.println("3333333333333333333");
		acm.setStatus("Pending");
		acm.setType("User");
		
		System.out.println("222222222222222222222221111111111");
	    userservice.saveApplyCard(acm);
		return new ModelAndView("applycardtopuppage1");
		}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::applycardtopuppage",e);
		    }
		return null;
	}
	

	@RequestMapping(value = "/paymentpage1", method = RequestMethod.POST)
public ModelAndView paymentpage(@ModelAttribute("command")ApplyCardBean acb, BindingResult result) {
		try{
		System.out.println("enter into paymentpage1 in user controller");
	String amount =acb.getCountry();
	ses.setAttribute("inttopup",amount);
	System.out.println("the amount is......."+amount);
	TopUpValidator r=new TopUpValidator();
	r.validate(acb, result);
	if(result.hasErrors()){
		System.out.println("error..page..");
		return new ModelAndView("applycardtopuppage1");
	}
	else
	{

	return new ModelAndView("paymentpage2");
	}
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::paymentpage1",e);
		    }
		return null;
}
	
	@RequestMapping(value = "/creditcard", method = RequestMethod.GET)
	public ModelAndView creditcard(@ModelAttribute("command")CardPaymentBean cpb, BindingResult result) {
	try{
		System.out.println("enter into creditcard in user controller");
	String credit="creditcard";
	ses.setAttribute("cardtype", credit);
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::UserController ::creditcard",e);
	    }
	
		return new ModelAndView("creditcard1");
				
	}
	
	@RequestMapping(value = "/debitcard", method = RequestMethod.GET)
	public ModelAndView debitcard(@ModelAttribute("command")CardPaymentBean acb, BindingResult result) {
		try{
		System.out.println("enter into debitcard in user controller");
		String debit="debitcard";
		ses.setAttribute("cardtype", debit);
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::UserController ::debitcard",e);
		    }
		return new ModelAndView("debitcard1");
	}
	
	@RequestMapping(value = "/netbanking", method = RequestMethod.GET)
	public ModelAndView netbanking() {
try{
	String netb="netbanking";
	ses.setAttribute("cardtype",netb);
}
catch (Exception e) {log.error(
		"KTMCard&Ticketing ::UserController ::netbanking",e);
    }
return new ModelAndView("netbanking1");
}
	
	
	@RequestMapping(value = "/aplpaymentsuccess1", method = RequestMethod.POST)
	public ModelAndView homepaymentsuccess(@ModelAttribute("command")CardPaymentBean  cpb, BindingResult result) {
		
		System.out.println("enter into aplpaymentsuccess1 in user controller");
		String cardtype=(String) ses.getAttribute("cardtype");
		System.out.println("The card type is.............."+cardtype);
	
		try{
		CardPaymentValidator r=new CardPaymentValidator();
		r.validate(cpb, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			
			if(cardtype.equals("debitcard")){
				
				return new ModelAndView("debitcard1");
			}
			
			else{
				
				return new ModelAndView("creditcard1");
			}
			
		}
		}catch(Exception e){}
		
		String intamount=(String) ses.getAttribute("inttopup");
		System.out.println("the intial amount is.........."+intamount);
		//Transaction id.........
		long min = 1000000000L; //10 digits inclusive
		long max = 10000000000L; //11s digits exclusive
		Random random = new Random();
		long number = min+((long)(random.nextDouble()*(max-min)));
		System.out.println("The 10 digit number transcation number  is................."+number);
		String txid = Long.toString(number);
		
		
		long min1 = 100000000L; //9 digits inclusive
		long max1 = 1000000000L; //10s digits exclusive
		Random random1 = new Random();
		long number1 = min1+((long)(random1.nextDouble()*(max1-min1)));
		System.out.println("The 10 digit number reference number is.........."+number1);
		String refid = Long.toString(number1);
		
		String cardid=(String) ses.getAttribute("cardid");
		System.out.println("the card id is....................."+cardid);
		String inttopup=(String) ses.getAttribute("inttopup");
		System.out.println("the topup amount is 2255555.............."+inttopup);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String txdate=dateFormat.format(date);
		System.out.println("....The logout time is......."+txdate);
		
		
		UserRechargeTrasactionsModel urtm=new UserRechargeTrasactionsModel();
		HttpSession hs=req.getSession(false);
		
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("username...."+username);
		System.out.println("password....."+password);
		
		urtm.setCardid(cardid);
		urtm.setTopupid(refid);
		urtm.setTxid(txid);
		urtm.setTopup(inttopup);
		urtm.setInttopup(inttopup);
		urtm.setBalance(inttopup);
		urtm.setDatetime(txdate);
		urtm.setUsername(username);
		urtm.setPassword(password);
		
		userservice.updatecardbalance(inttopup,cardid);
		userservice.saveUserRechargetxmodel(urtm);
		return new ModelAndView("aplpaymentsuccess2");
		
		
	}
	
/*CARD STATUS......*/
	
	@RequestMapping(value = "/cardstatus1", method = RequestMethod.GET)
	public ModelAndView cardstatus1() {
			try{	
			}
			catch (Exception e) {log.error(
		"KTMCard&Ticketing ::UserController ::cardstatus1",e);
			}
		return new ModelAndView("cardstatus2");
	}
	
	@RequestMapping(value = "/showcardstatus", method = RequestMethod.GET)
	public void showcardstatus(@ModelAttribute("command")ApplyCardModel acm, 
			BindingResult result,HttpServletResponse response,HttpSession ses,HttpServletRequest req) throws IOException {
		try{    
		System.out.println("enter into showcardstatus request mapping");
		    HttpSession hs=req.getSession(false);
		
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("username...."+username);
			System.out.println("password....."+password);
		    PrintWriter out= response.getWriter();
		    List camps=userservice.listofuserapplycards(username,password);
		    System.out.println("the list size is..........."+camps.size());
		    
			
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"camps"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(camps,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
		    //return array;
		      
			}
	
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::UserController ::showcardstatus",e);
	    }
}
}
