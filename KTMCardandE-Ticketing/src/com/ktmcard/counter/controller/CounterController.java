package com.ktmcard.counter.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktmcard.admin.bean.CounterBean;
import com.ktmcard.admin.bean.TrainsBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.TicketModel;
import com.ktmcard.admin.model.TrainsModel;
import com.ktmcard.admin.validator.CounterValidator;
import com.ktmcard.counter.bean.BookticketBean;
import com.ktmcard.counter.bean.ChangePassword;
import com.ktmcard.counter.service.ServiceCounter;
import com.ktmcard.counter.validator.Changepasswordvalidator;
import com.ktmcard.counter.validator.FindTrainsValidator;
import com.ktmcard.home.bean.ApplyCardBean;
import com.ktmcard.home.bean.Registration;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.validator.ApplyCardValidator;
import com.ktmcard.user.model.UserRechargeTrasactionsModel;

@Controller

public class CounterController {
	private Logger log = Logger.getLogger(CounterController.class);

	@Autowired
	private ServiceCounter servicecounter;	
	
	@Autowired
	private HttpServletRequest req;	
	
	@Autowired
	private HttpSession ses;	
	
	
	
	@RequestMapping(value = "/counterlogin", method = RequestMethod.GET)
	public ModelAndView welcome() {
try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::CounterController ::counterlogin",e);
	}
		return new ModelAndView("counterlogin1");
	}
@RequestMapping(value = "/counterhome", method = RequestMethod.GET)
public ModelAndView counterhome() {
	
	try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterhome",e);
}
	return new ModelAndView("counterhome1");
}
@RequestMapping(value = "/bookticket", method = RequestMethod.GET)
public ModelAndView bookticket(@ModelAttribute("command")BookticketBean bt, BindingResult result) {
try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::bookticket",e);
}
	return new ModelAndView("bookticket1");
}
@RequestMapping(value = "/booksearch", method = RequestMethod.GET)
public ModelAndView booksearch() {
try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::booksearch",e);
}
	return new ModelAndView("booksearch1");
}
@RequestMapping(value = "/conformtrain", method = RequestMethod.GET)
public ModelAndView conformtrain(@ModelAttribute("command")Registration reg, BindingResult result) {
try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::conformtrain",e);
}
	return new ModelAndView("conformtrain1");
}
@RequestMapping(value = "/conformticket", method = RequestMethod.GET)
public ModelAndView conformticket() {
try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::conformticket",e);
}
	return new ModelAndView("conformticket1");
}
@RequestMapping(value = "/payment", method = RequestMethod.GET)
public ModelAndView payment() {
try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::payment",e);
}
	return new ModelAndView("payment1");
}


@RequestMapping(value = "/counterapplycard", method = RequestMethod.GET)
public ModelAndView counterapplycard(@ModelAttribute("command")ApplyCardBean acb, BindingResult result) {
try {
		
	} catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterapplycard",e);
}	return new ModelAndView("counterapplycard1");
}

@RequestMapping(value = "/counterapplycardtopup", method = RequestMethod.POST)
public ModelAndView counterapplycardtopup(@ModelAttribute("command")ApplyCardBean acb, BindingResult result) throws IllegalAccessException, InvocationTargetException {
	try{
	ApplyCardValidator r=new ApplyCardValidator();
	r.validate(acb, result);
	if(result.hasErrors()){
		System.out.println("error..page..");
		return new ModelAndView("counterapplycard1");
	}
	else{
	System.out.println("enter into applycardtopuppage in controller");
	ApplyCardModel acm=new ApplyCardModel();
System.out.println("The first name is ..............."+acb.getFirstname());
System.out.println("The first name is ..............."+acb.getMiddlename());
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
	acm.setStatus("Approved");
	acm.setType("Counter");
	System.out.println("222222222222222222222221111111111");
	servicecounter.saveApplyCard(acm);
	
	return new ModelAndView("counterapplycardtopup1");
}
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterapplycardtopup",e);
}
	return null;	
}
@RequestMapping(value = "/counteraplycardsus1", method = RequestMethod.POST)
public ModelAndView counteraplycardsus1(@ModelAttribute("command")ApplyCardBean acb, BindingResult result) {
	try{
	System.out.println("enter intocounteraplycardsus1 in counter controller");
	String amount =acb.getCountry();
	ses.setAttribute("inttopup",amount);
	System.out.println("the amount is......."+amount);
	System.out.println("enter into aplpaymentsuccess1 in user controller");
	String intamount=(String) ses.getAttribute("inttopup");
	System.out.println("the intial amount is.........."+intamount);
	//Transaction id.........
	long min = 1000000000L; //10 digits inclusive
	long max = 10000000000L; //11s digits exclusive
	Random random = new Random();
	long number = min+((long)(random.nextDouble()*(max-min)));
	System.out.println("The 10 digit number transcation number  is.........."+number);
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
	
	servicecounter.updatecardbalance(inttopup,cardid);
	servicecounter.saveUserRechargetxmodel(urtm);
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counteraplycardsus1",e);
}
	return new ModelAndView("counteraplycardsus2");
}



@RequestMapping(value = "/cardpaymentsuccess", method = RequestMethod.GET)
public ModelAndView cardpaymentsuccess() {
	try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::cardpaymentsuccess",e);
}
	return new ModelAndView("cardpaymentsucc1");
}
@RequestMapping(value = "/tickets", method = RequestMethod.GET)
public ModelAndView tickets() {
try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::tickets",e);
}
	return new ModelAndView("tickets1");
}
@RequestMapping(value = "/cancelticket", method = RequestMethod.GET)
public ModelAndView cancelticket() {
try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::cancelticket",e);
}
	return new ModelAndView("cancelticket1");
}


//Update Profile
@RequestMapping(value = "/counterupdateprofile", method = RequestMethod.GET)
public ModelAndView counterupdateprofile(@ModelAttribute("command")CounterBean cb, BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
	try{
	CounterModel cm=null;
	HttpSession ses=request.getSession(false);
	String un=(String) ses.getAttribute("username");
	String pwd=(String) ses.getAttribute("password");
	List<CounterModel> li=servicecounter.loginlist(un,pwd);
	
	for (Iterator iterator = li.iterator(); iterator.hasNext();) {
		cm = (CounterModel) iterator.next();
	}
	BeanUtils.copyProperties(cb,cm);
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterupdateprofile",e);
}
	
	
	return new ModelAndView("counterupdateprofile1");
}
//Update profile success
@RequestMapping(value = "/updatecountersucc", method = RequestMethod.GET)
public ModelAndView updatecountersucc(@ModelAttribute("command")CounterBean cb, BindingResult result) throws IllegalAccessException, InvocationTargetException {
	try{
	CounterValidator r=new CounterValidator();
	r.validate(cb, result);
	if(result.hasErrors()){
		System.out.println("error..page..");
		return new ModelAndView("counterupdateprofile1");
	}
	else{
	CounterModel cm=new CounterModel();
	BeanUtils.copyProperties(cm,cb);
	servicecounter.updateCounter(cm);
	return new ModelAndView("updatecountersucc1");
	}
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::updatecountersucc",e);
}
	return null;
}
//Change password

@RequestMapping(value = "/counterchangepassword", method = RequestMethod.GET)
public ModelAndView counterchangepassword(@ModelAttribute("command")ChangePassword cb, BindingResult result) {
	try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterchangepassword",e);
}
	return new ModelAndView("counterchangepassword1");
}

//Change password success
@RequestMapping(value = "/counterchangepasswordsucc", method = RequestMethod.POST)
public ModelAndView counterchangepasswordsucc(@ModelAttribute("command")ChangePassword cb, BindingResult result,HttpServletRequest request) {
	try{
	Changepasswordvalidator r=new Changepasswordvalidator();
	r.validate(cb, result);
	if(result.hasErrors()){
		System.out.println("error..page..");
		return new ModelAndView("counterchangepassword1");
	}
	else{
	
	
	HttpSession ses=request.getSession(false);
	String un=(String) ses.getAttribute("username");
	String pwd=(String) ses.getAttribute("password");
	List<CounterModel> li=servicecounter.loginlist(un,pwd);
	Integer id=li.get(0).getId();
	String password=li.get(0).getPassword();
	String currentpassword=cb.getOldpassword();
	String newpassword=cb.getPassword();
	System.out.println("new password is "+newpassword);
	String confirmnewpwd=cb.getConformpassword();
	if(password.equals(currentpassword))
	{
		if(newpassword.equals(confirmnewpwd))
		{
			
			servicecounter.counterChangePassword(id,newpassword,confirmnewpwd);
			servicecounter.counterchangepasswordlist(un,newpassword);
			 return new ModelAndView("counterchpwdsuccess");
		}
	}

  return new ModelAndView("counterchpwdfail");
	
	}
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterchangepasswordsucc",e);
}
	return null;
	
}



@RequestMapping(value = "/counterlogout", method = RequestMethod.GET)
public ModelAndView counterlogout() {
	try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::counterlogout",e);
}
	return new ModelAndView("counterlogout1");
}
@RequestMapping(value = "/bookticketcounter", method = RequestMethod.GET)
public ModelAndView bookticketcounter() {
try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::bookticketcounter",e);
}
	return new ModelAndView("bookticketcounter");
}

@RequestMapping(value = "/printjourneytkt", method = RequestMethod.GET)
public ModelAndView printjourneytkt() {
try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::printjourneytkt",e);
}
	return new ModelAndView("printjourneytkt");
}


@RequestMapping(value = "/findtrainscounter", method = RequestMethod.GET)
public ModelAndView findtrainscounter(@ModelAttribute("command") TrainsBean tb) {
try{
		
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::findtrainscounter",e);
}
	return new ModelAndView("findtrainscounter");
}


@RequestMapping(value = "/findtraincountersucc", method = RequestMethod.GET)
public ModelAndView findtraincountersucc(@ModelAttribute("command") TrainsBean tb,BindingResult result,HttpServletRequest request) {
	try{
	FindTrainsValidator f=new FindTrainsValidator();
	f.validate(tb, result);
	if(result.hasErrors()){
		System.out.println("error..page..");
		return new ModelAndView("findtrainscounter");
	}
	else{
	System.out.println("coming to cccccnnnnnnnnnnnnttrrrrrrlllllll");
	String s=tb.getSource();
	System.out.println("coming to cccccnnnnnnnnnnnnttrrrrrrlllllll" +s);
	String d=tb.getDestination();
	request.getSession().setAttribute("source", s);
	request.getSession().setAttribute("destination", d);
	List li=servicecounter.gettrainsserach();
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
		return new ModelAndView("findtrainscounter");

	}
	request.getSession().setAttribute("trainslistt", lc);
	return new ModelAndView("findtrainscountersuccess");
	}
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::findtraincountersucc",e);
}
	return null;
}

@RequestMapping(value = "/journytkt", method = RequestMethod.GET)
public ModelAndView journytkt(@ModelAttribute("command") TrainsBean tb,HttpServletRequest request) {
	try{
	String y=request.getParameter("r");
	String k=request.getParameter("w");
	System.out.println("the fare iss:::::" +y);
	System.out.println("the trainnumbver is::::::" +k);
	String s=(String) request.getSession().getAttribute("source");
	String d=(String) request.getSession().getAttribute("destination");
	tb.setSource(s);
	tb.setDestination(d);
	tb.setBasefare(y);
	 Random randomGenerator = new Random();
	      int randomInt = randomGenerator.nextInt(100000000);
	      String rn=Integer.toString(randomInt);
	tb.setBtn(rn);
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::journytkt",e);
}
	return new ModelAndView("jurneyperformtkt");
}

@RequestMapping(value = "/confrmticketcounter", method = RequestMethod.GET)
public @ResponseBody String confrmticketcounter(TrainsBean tb,HttpServletRequest request)
{
	try{
	String s=(String) request.getSession().getAttribute("source");
	String d=(String) request.getSession().getAttribute("destination");
	System.out.println("the sssssssssssssssrceeeeeeeee is::::::" +s);
	System.out.println("the dstnnnnnnnnnnnnnnnnnnnnnnnnnnn is::::::" +d);
	String sn=request.getParameter("numr");
	String fr=request.getParameter("fr");
	TicketModel tm=new TicketModel();
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
	servicecounter.savetktdetails(tm);
	return s;
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::confrmticketcounter",e);
}
	return null;
}

@RequestMapping(value = "/tktscount", method = RequestMethod.GET)
public ModelAndView tktscount(@ModelAttribute("command") TrainsBean tb) {
	try{}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::tktscount",e);
}
	return new ModelAndView("tktscount");
}

@RequestMapping(value = "/tktscountfind", method = RequestMethod.GET)
public ModelAndView tktscountfind(@ModelAttribute("command") TrainsBean tb,HttpServletRequest request) {
	try{
	String a=request.getParameter("dts");
	System.out.println("the getting date issss::::::::::::::::::"+a);
	String un=(String) request.getSession().getAttribute("username");
	String k="";
	String amnt="";
	int i=0;
	int q=0;
	List li=servicecounter.gettktsdetails(a,un);
	System.out.println("the list size isssss::::::" +li.size());
	for (Iterator iterator = li.iterator(); iterator.hasNext();) {
		TicketModel tm = (TicketModel) iterator.next();
		if(q==0)
		{
			q=Integer.parseInt(tm.getFare());
		}
		else
		{
			q=q+Integer.parseInt(tm.getFare());
		}
		System.out.println("the amount of fare isssss:::::::" +q);
	}
	amnt=Integer.toString(q);

	int m=li.size();
	String h=Integer.toString(m);
	tb.setTottkts(h);
	tb.setTotamnt(amnt);
	tb.setTktdate(a);
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::tktscountfind",e);
}
	return new ModelAndView("tktscountfind");
}

@RequestMapping(value = "/trainstopdetails", method = RequestMethod.GET)
public ModelAndView trainstopdetails(@ModelAttribute("command") TrainsBean tb,HttpServletRequest request) {
	try{
	String a=request.getParameter("r");
	System.out.println("the train number issss:::::" +a);
	List li=servicecounter.gettarinstopdetails(a);
	String st="";
	String at="";
	String dt="";
	String dfs="";
	List lc=new ArrayList();

	for (Iterator iterator = li.iterator(); iterator.hasNext();) {
		TrainsModel ob = (TrainsModel) iterator.next();
		st=ob.getStations();
		at=ob.getArrivaltimes();
		dt=ob.getDeparturetimes();
		dfs=ob.getDistancefromsource();
	}
	System.out.println("the station isss:::::::" +st);
	String m[]=st.split(",");
	String n[]=at.split(",");
	String o[]=dt.split(",");
	String p[]=dfs.split(",");
	int k=m.length;
	System.out.println("the length issss::::::::" +k);
	
	for(int i=0;i<k;i++)
	{
		TrainsModel tm=new TrainsModel();
		tm.setStations(m[i]);
		tm.setArrivaltimes(n[i]);
		tm.setDeparturetimes(o[i]);
		tm.setDistancefromsource(p[i]);
		System.out.println("the stations are:::::::::::::" +m[i]);
		lc.add(tm);
	}

	request.getSession().setAttribute("trnstops", lc);
	return new ModelAndView("trainsstopdetails");
	}
	catch (Exception e) {log.error(
			"KTMCard&Ticketing ::CounterController ::trainstopdetails",e);
}
	return null;
}

}
