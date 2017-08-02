package com.ktmcard.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktmcard.admin.bean.CounterBean;
import com.ktmcard.admin.bean.StationBean;
import com.ktmcard.admin.bean.TrainsBean;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.StationModel;
import com.ktmcard.admin.model.TrainsModel;
import com.ktmcard.admin.service.ServiceAdmin;
import com.ktmcard.admin.validator.Changepasswordvalidator;
import com.ktmcard.admin.validator.CounterValidator;
import com.ktmcard.admin.validator.StationValidator;
import com.ktmcard.admin.validator.TrainValidator;
import com.ktmcard.home.bean.ApplyCardBean;
import com.ktmcard.home.bean.Registration;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.home.service.HomeService;
import com.ktmcard.home.validator.RegistrationValidator;

@Controller
public class AdminController {
	private Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	private ServiceAdmin serviceadmin;

	@Autowired
	private HomeService homeservice;
	@Autowired
	private HttpSession ses;

	@Autowired
	private HttpServletRequest req;

	// Index Page
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::index",e);
	}
		
		return new ModelAndView("index1");
	}
	
		
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public ModelAndView adminlogin() {
try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::adminlogin",e);
	}
		
		return new ModelAndView("adminlogin1");
	}
	
	//Admin home
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public ModelAndView adminhome() {
try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::adminhome",e);
	}
		
		return new ModelAndView("adminhome1");
	}
	
	//Counters
	@RequestMapping(value = "/counters", method = RequestMethod.GET)
	public ModelAndView counters() {
try {
			
		} catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::counters",e);
	}
		return new ModelAndView("counters1");
	}
	// Add counters
		@RequestMapping(value = "/addcounter", method = RequestMethod.GET)
		public ModelAndView addcounter(@ModelAttribute("command")CounterBean cb, BindingResult result) {
			try {
				cb.setType("Counter");
				
			} catch (Exception e) {log.error(
					"KTMCard&Ticketing ::AdminController ::addcounter",e);
		}
			return new ModelAndView("addcounter1");
		}
		
		
		@RequestMapping(value = "/addcountersucc", method = RequestMethod.POST)
		public ModelAndView addcountersucc(@ModelAttribute("command")CounterBean cb,BindingResult result,CounterModel cm,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
			try{
			CounterValidator r=new CounterValidator();
			r.validate(cb, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("addcounter1");
			}
			else{
			serviceadmin.addcounters(cm);
			return new ModelAndView("addcountersucc1");
			}
			}
			catch (Exception e) {log.error(
					"KTMCard&Ticketing ::AdminController ::addcountersucc",e);
		}
			return null;
		}
		//Unique user name in add counters
		
				@RequestMapping(value="/addcountre_userunique",method=RequestMethod.GET)
				public void usernameunique_counter(@ModelAttribute("command")Registration r,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
				{
					try{
					System.out.println("enter unique username....");
					PrintWriter out=response.getWriter();
					List<CounterModel> li=serviceadmin.usernameunique();
					System.out.println("list in unique.."+li.size());
					Iterator<CounterModel> i=li.iterator();
					String undb=null;
					while(i.hasNext()){
						
						CounterModel ul=(CounterModel) i.next();
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
							"KTMCard&Ticketing ::AdminController ::addcountre_userunique",e);
				}
				}
				
	// Counters grid 
	@RequestMapping(value="/CounterDisplayGrid", method = RequestMethod.GET)
	public void listEmployee(@ModelAttribute("command")CounterBean cb,BindingResult result,HttpServletResponse response) throws IOException {
		try{
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<CounterModel> li=serviceadmin.getCounters();
		System.out.println("list size is: "+li.size());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		//return array;
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::CounterDisplayGrid",e);
	}
	}
	
	@RequestMapping(value = "/requestedcards", method = RequestMethod.GET)
	public ModelAndView requestedcards() {
		try{
			
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::requestedcards",e);
	}
		System.out.println("enter into requestedcards in admin controller");
		return new ModelAndView("requestedcards1");
	}
	
	@RequestMapping(value = "/adrequsedcards", method = RequestMethod.GET)
	public void adrequsedcards(@ModelAttribute("command")ApplyCardModel acm, 
			BindingResult result,HttpServletResponse response,HttpSession ses,HttpServletRequest req) throws IOException {
		try{   
		System.out.println("enter into adcampsgrid request mapping");
		    PrintWriter out= response.getWriter();
		    List camps=serviceadmin.listoftotalrequstedcamps();
		  
			
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
				"KTMCard&Ticketing ::AdminController ::adrequsedcards",e);
	}
	}
	
	@RequestMapping(value = "/finding", method = RequestMethod.GET)
	public List finding(@ModelAttribute("command")ApplyCardBean acb, BindingResult result,HttpServletResponse res) throws IOException
	{
		try{
		System.out.println("enter into finding in admin controller");
		PrintWriter out= res.getWriter();
		String status=req.getParameter("value");
	String status1=status.toLowerCase();
	System.out.println("......The search status is..."+status1);
		
		List stlist =serviceadmin.getapplycardstatuslist(status1);
		System.out.println("the list size is.........."+stlist.size());
					
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"stlist"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			
			JSONArray array = JSONArray.fromObject(stlist,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
		    return array;
		}
		catch (Exception e) {log.error(
				"KTMCard&Ticketing ::AdminController ::finding",e);
	}
		return null;
	}

	
	@RequestMapping(value = "/deletecard999", method = RequestMethod.GET)
	public ModelAndView deletecard999(@ModelAttribute("command")ApplyCardBean acb, BindingResult result) {
		
		System.out.println("enter into deletecard999 requestmapping in admin controller");
		try{
			String id = req.getParameter("cid");
		
			
			System.out.println("THe ids length is...........//.......//.."+id);
			
			serviceadmin.deletecards(id);
			
			}catch(Exception e){log.error(
					"KTMCard&Ticketing ::AdminController ::deletecard999",e);
					}
		return new ModelAndView("requestedcards1");
	}
	
	
	@RequestMapping(value = "/approvecard999", method = RequestMethod.GET)
	public ModelAndView approvecard999() {
		try{
		System.out.println("enter into admincontroller approvecard999");
		String acid=req.getParameter("id");
		System.out.println("the selected card id is........."+acid);
		serviceadmin.approvingcard(acid);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::approvecard999",e);
				}
		return new ModelAndView("requestedcards1");
	}
	
	@RequestMapping(value = "/rejectcard999", method = RequestMethod.GET)
	public ModelAndView rejectcard999() {
		try{
		System.out.println("enter into admincontroller rejectcard999");
		String acid=req.getParameter("id");
		System.out.println("the selected card id is........."+acid);
		serviceadmin.rejectingcard(acid);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::rejectcard999",e);
				}
		return new ModelAndView("requestedcards1");
	}
	
	@RequestMapping(value = "/approvedcardsuccess", method = RequestMethod.GET)
	public ModelAndView approvedcardsuccess() {
		try{
			
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::approvedcardsuccess",e);
				}
		return new ModelAndView("approvedcardsuccess1");
	}
	@RequestMapping(value = "/rejectcardsuccess", method = RequestMethod.GET)
	public ModelAndView rejectcardsuccess() {
try{
			
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::rejectcardsuccess",e);
				}
		return new ModelAndView("rejectcardsuccess1");
	}
	// Update counter
		@RequestMapping(value = "/updatecounter", method = RequestMethod.GET)
		public ModelAndView updatecounter(@ModelAttribute("command")CounterBean cb, BindingResult result) throws IllegalAccessException, InvocationTargetException {
			try{
			
				CounterModel cm=null;
				List<CounterModel> li=serviceadmin.getCounterId(cb.getId());
				for (Iterator iterator = li.iterator(); iterator.hasNext();) {
					cm = (CounterModel) iterator.next();
					
				}
				BeanUtils.copyProperties(cb,cm);
			}
			catch(Exception e){log.error(
					"KTMCard&Ticketing ::AdminController ::updatecounter",e);
					}
				return new ModelAndView("updatecounter1");
		}
		
		@RequestMapping(value = "/updatecountersuccs", method = RequestMethod.POST)
		public ModelAndView updatecountersuccs(@ModelAttribute("command")CounterBean cb, BindingResult result)throws IllegalAccessException, InvocationTargetException {
			try{
			CounterValidator r=new CounterValidator();
			r.validate(cb, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("updatecounter1");
			}
			
			else{
			CounterModel cm=new CounterModel();
			BeanUtils.copyProperties(cm,cb);
			homeservice.updateCounter(cm);
			return new ModelAndView("updatecountersuccs1");
		}
			}
			catch(Exception e){log.error(
					"KTMCard&Ticketing ::AdminController ::updatecountersuccs",e);
					}
			return null;
		}
		
	
		
		// Delete counter
				@RequestMapping(value = "/deletecounter", method = RequestMethod.GET)
				public ModelAndView deletecounter(@ModelAttribute("command")CounterBean cb, BindingResult result,HttpServletRequest request) {
					try{
					String id=request.getParameter("id");
					serviceadmin.deleteCounter(id);
					}
					catch(Exception e){log.error(
							"KTMCard&Ticketing ::AdminController ::deletecounter",e);
							}
					return new ModelAndView("counters1");
				}
	
	//Search station code or station name
	
	@RequestMapping(value="/counter_searchstationcode" ,method = RequestMethod.GET)
	public void search(@ModelAttribute("command")  CounterBean cb,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IOException{
			try{
			String data=request.getParameter("stationdata");
			PrintWriter out=null;
			out=response.getWriter();
			//HttpSession ses=request.getSession();
			//ses.setAttribute("status", status);
			List<CounterModel> li1= serviceadmin.searchStationCode(data);
			System.out.println("the list is"+ li1.size());
			JSONArray array=null;
			 if(li1.size()>0)
			 {
				
				    JsonConfig jsonConfig = new JsonConfig();
					jsonConfig.setExcludes(new String[]{"li"});
					jsonConfig.setIgnoreDefaultExcludes(false);
					jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
					array = JSONArray.fromObject(li1,jsonConfig);
					System.out.println(array);
					out.print(array);
					out.flush();
				    out.close();
					//return array;
			 }
			 else
			 {
				 	JsonConfig jsonConfig = new JsonConfig();
					jsonConfig.setExcludes(new String[]{"li"});
					jsonConfig.setIgnoreDefaultExcludes(false);
					jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
					array = JSONArray.fromObject(li1,jsonConfig);
					System.out.println(array);
					out.print(array);
					out.flush();
				    out.close();
					//return array;
			 }
			}
			catch(Exception e){log.error(
					"KTMCard&Ticketing ::AdminController ::counter_searchstationcode",e);
					}
	}
	
	//Search station code or station name in stations grid
		@RequestMapping(value="/station_searchcode" ,method = RequestMethod.GET)
		public void searchstations(@ModelAttribute("command")  CounterBean cb,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IOException{
				try{
				String value=request.getParameter("searchdata");
				
				System.out.println("The value iss "+value);
				PrintWriter out=null;
				out=response.getWriter();
				//HttpSession ses=request.getSession();
				//ses.setAttribute("status", status);
				List<StationModel> li1= serviceadmin.searchStations(value);
				System.out.println("the list is"+ li1.size());
				JSONArray array=null;
				 if(li1.size()>0)
				 {
					
					    JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						array = JSONArray.fromObject(li1,jsonConfig);
						System.out.println(array);
						out.print(array);
						out.flush();
					    out.close();
						//return array;
				 }
				 else
				 {
					 	JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						array = JSONArray.fromObject(li1,jsonConfig);
						System.out.println(array);
						out.print(array);
						out.flush();
					    out.close();
						//return array;
				 }
				}
				catch(Exception e){log.error(
						"KTMCard&Ticketing ::AdminController ::station_searchcode",e);
						}
		}

	// Search trains in trains grid
		
		@RequestMapping(value="/trainidsearch" ,method = RequestMethod.GET)
		public void trainidsearch(@ModelAttribute("command")  CounterBean cb,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IOException{
				try{
				String tid=request.getParameter("tid");
				
				System.out.println("The value iss "+tid);
				PrintWriter out=null;
				out=response.getWriter();
				//HttpSession ses=request.getSession();
				//ses.setAttribute("status", status);
				List<TrainsModel> li1= serviceadmin.searchTrain(tid);
				System.out.println("the list is"+ li1.size());
				JSONArray array=null;
				 if(li1.size()>0)
				 {
					
					    JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						array = JSONArray.fromObject(li1,jsonConfig);
						System.out.println(array);
						out.print(array);
						out.flush();
					    out.close();
						//return array;
				 }
				 else
				 {
					 	JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						array = JSONArray.fromObject(li1,jsonConfig);
						System.out.println(array);
						out.print(array);
						out.flush();
					    out.close();
						//return array;
				 }
				}
				catch(Exception e){log.error(
						"KTMCard&Ticketing ::AdminController ::trainidsearch",e);
						}
		}	
	
	
	
	
	
 @RequestMapping(value = "/adminupdateprofile", method = RequestMethod.GET)
	public ModelAndView adminupdateprofile(@ModelAttribute("command")Registration reg, BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
	try{	
	 HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("in session un"+username);
		System.out.println("in session pwd"+password);
		RegistrationModel rm=null;
		List<RegistrationModel> li=serviceadmin.loginlist(username,password);
		System.out.println("list for login..."+li.size());
		Integer i=li.get(0).getId();
		String st=li.get(0).getStatus();
		String tp=li.get(0).getType();
		reg.setId(i);
		reg.setStatus(st);
		reg.setType(tp);
		System.out.println("id....in adminprofile"+i);
		//reg.setId(i);	
for (Iterator<RegistrationModel> iterator = li.iterator(); iterator.hasNext();) {
			rm = (RegistrationModel) iterator.next();
			System.out.println(rm.getId());
		}
		System.out.println(reg.getId());
		
		BeanUtils.copyProperties(reg,rm);
	}
	catch(Exception e){log.error(
			"KTMCard&Ticketing ::AdminController ::adminupdateprofile",e);
			}
		return new ModelAndView("adminupdateprofile1");
	}
	
	@RequestMapping(value = "/adminupdateprofilesucc", method = RequestMethod.POST)
	public ModelAndView adminupdateprofilesucc(@ModelAttribute("command")Registration reg, BindingResult result,RegistrationModel rm) throws IllegalAccessException, InvocationTargetException {
		try{
		//RegistrationModel rm=new RegistrationModel();
		System.out.println("The registration model is "+rm);
		BeanUtils.copyProperties(rm, reg);
		System.out.println(reg.getId());
		RegistrationValidator r=new RegistrationValidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("adminupdateprofile1");
		}
		serviceadmin.updateadminprofile(rm);
		//serviceadmin.adminupdateprofile(rm);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::adminupdateprofilesucc",e);
				}
		return new ModelAndView("updatecountersuccs1");
	}
	
	@RequestMapping(value = "/adminchangepassword", method = RequestMethod.GET)
	public ModelAndView adminchangepassword(@ModelAttribute("command")Registration reg, BindingResult result,HttpServletRequest request) {
		try{
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("username...."+username);
		System.out.println("password....."+password);
		List<RegistrationModel> li=serviceadmin.loginlist(username, password);
		System.out.println(li.size());
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::adminchangepassword",e);
				}
		
		return new ModelAndView("adminchangepassword1");
	}
	@RequestMapping(value = "/adminchangepwdsucc", method = RequestMethod.POST)
	public ModelAndView adminchangepwdsucc(@ModelAttribute("command")Registration reg, BindingResult result,HttpServletRequest request) {
		try{
		Changepasswordvalidator r=new Changepasswordvalidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("adminchangepassword1");
		}
		else{
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
		serviceadmin.changepassword(username,npd,cnpd);
		serviceadmin.changepasswordlist(username,npd);

		return new ModelAndView("updatecountersuccs1");

		}
		else {
			return new ModelAndView("adminchangepassworderror");
		}
		}
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::adminchangepwdsucc",e);
				}
		return null;
	}
	
	
	@RequestMapping(value = "/adminlogout", method = RequestMethod.GET)
	public ModelAndView adminlogout() {
try{
			
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::adminlogout",e);
				}
		return new ModelAndView("adminlogout1");
	}
	
	@RequestMapping(value = "/viewstations", method = RequestMethod.GET)
	public ModelAndView viewstations() {
try{
			
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::viewstations",e);
				}
		return new ModelAndView("viewstations");
	}
	// Station grid
	
	@RequestMapping(value="/stationsgrid", method = RequestMethod.GET)
	public void stationsgrid(@ModelAttribute("command")TrainsBean sb,BindingResult result,HttpServletResponse response) throws IOException {
		try{
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<StationModel> li=serviceadmin.getAllStations();
		System.out.println("list size is: "+li.size());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		//return array;
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::stationsgrid",e);
				}
	}
	@RequestMapping(value = "/addstation", method = RequestMethod.GET)
	public ModelAndView addstation(@ModelAttribute("command") StationBean sb) {
try{
			
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::addstation",e);
				}
		return new ModelAndView("addstation1");
	}
	@RequestMapping(value = "/addstationsave", method = RequestMethod.GET)
	public ModelAndView addstationsave(@ModelAttribute("command") StationBean sb,BindingResult result) throws InvocationTargetException, IllegalAccessException {
		try{
		StationValidator r=new StationValidator();
		r.validate(sb, result);
		if(result.hasErrors()){
			
			return new ModelAndView("addstation1");
		}
		else{
		
			StationModel sm=new StationModel();
			BeanUtils.copyProperties(sm, sb);
			serviceadmin.savestations(sm);
			return new ModelAndView("addstationsuccess");

		}
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::addstationsave",e);
				}
		return null;
	
	}

	
	@RequestMapping(value="/uniquestations",method=RequestMethod.GET)
	public void uniquestations(@ModelAttribute("command")StationBean sb,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		try{
		System.out.println("enter unique station name....");
		PrintWriter out=response.getWriter();
		List<StationModel> li=serviceadmin.uniquestationslist();
		System.out.println("list in unique.."+li.size());
		Iterator<StationModel> i=li.iterator();
		String undb=null;
		while(i.hasNext()){
			
			StationModel ul=(StationModel) i.next();
			System.out.println("size..."+ul.getStationname());
			if(undb==null){
				undb=ul.getStationname();
			}
			
			else{
				undb=undb+","+ul.getStationname();
			}
		}
		out.println(undb);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::uniquestations",e);
				}
		}
	
	@RequestMapping(value="/uniquestationcode",method=RequestMethod.GET)
	public void uniquestationcode(@ModelAttribute("command")StationBean sb,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		try{
		System.out.println("enter unique station name....");
		PrintWriter out=response.getWriter();
		List<StationModel> li=serviceadmin.uniquestationslist();
		System.out.println("list in unique.."+li.size());
		Iterator<StationModel> i=li.iterator();
		String undb=null;
		while(i.hasNext()){
			
			StationModel ul=(StationModel) i.next();
			System.out.println("size..."+ul.getStationcode());
			if(undb==null){
				undb=ul.getStationcode();
			}
			
			else{
				undb=undb+","+ul.getStationcode();
			}
		}
		out.println(undb);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::uniquestationcode",e);
				}
	}
	//update station
	@RequestMapping(value = "/editstation", method = RequestMethod.GET)
	public ModelAndView editstations(@ModelAttribute("command")StationBean sb,BindingResult result,HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
		try{
		System.out.println("Update Station running");
		StationModel sm=null;
		String id=request.getParameter("id");
		System.out.println("Id value is" +id);
		List<StationModel> li=serviceadmin.getStationId(id);
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			sm = (StationModel) iterator.next();
			
		}	
		
		BeanUtils.copyProperties(sb, sm);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::editstation",e);
				}
		return new ModelAndView("updatestation1");
	}
	

	@RequestMapping(value = "/updatestationsucc", method = RequestMethod.GET)
	public ModelAndView editstationsucc(@ModelAttribute("command") StationBean sb,BindingResult result) throws InvocationTargetException, IllegalAccessException {
			try{
		StationValidator r=new StationValidator();
		r.validate(sb, result);
		if(result.hasErrors()){
			
			return new ModelAndView("updatestation1");
		}
		else{
		StationModel sm=new StationModel();
		BeanUtils.copyProperties(sm,sb);
		serviceadmin.updateStations(sm);
		return new ModelAndView("updatestationsuccess1");
		}
			}
			catch(Exception e){log.error(
					"KTMCard&Ticketing ::AdminController ::updatestationsucc",e);
					}
			return null;	
	}
	
	// Delete Station
	
	@RequestMapping(value = "/deletestation", method = RequestMethod.GET)
	public ModelAndView deletecounter(@ModelAttribute("command")StationBean sb, BindingResult result,HttpServletRequest request) {
		try{
		String id=request.getParameter("id");
		serviceadmin.deleteStation(id);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::deletestation",e);
				}
		return new ModelAndView("deletestationsucc");
	}
	
	
	
	
	//view trains grid
	
	@RequestMapping(value="/viewtrainsgrid", method = RequestMethod.GET)
	public void listtrains(@ModelAttribute("command")TrainsBean sb,BindingResult result,HttpServletResponse response) throws IOException {
		try{
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<TrainsModel> li=serviceadmin.getTrains();
		System.out.println("list size is: "+li.size());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		//return array;
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::viewtrainsgrid",e);
				}
	}
	
	@RequestMapping(value = "/addtrains", method = RequestMethod.GET)
	public ModelAndView addtrains(@ModelAttribute("command") TrainsBean sb) throws InvocationTargetException, IllegalAccessException {
		try{
		}
		
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::addtrains",e);
				}
		return new ModelAndView("addtrains1");
	}
	
	//Update train
	
	
	@RequestMapping(value = "/edittrain", method = RequestMethod.GET)
	public ModelAndView edittrain(@ModelAttribute("command")TrainsBean sb,BindingResult result,HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
		try{
		System.out.println("Update Train running");
		TrainsModel sm=null;
		String id=request.getParameter("id");
		System.out.println("Id value is" +id);
		List<TrainsModel> li=serviceadmin.getTrainId(id);
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			sm = (TrainsModel) iterator.next();
			
			ses.setAttribute("nst",sm.getNumberofstops());
			System.out.println("The no of stops..................is........."+sm.getNumberofstops());
			
			String stations=sm.getStations();
			ses.setAttribute("stations",stations);
			System.out.println("the stations are .............."+stations);
			String atimes=sm.getArrivaltimes();
			ses.setAttribute("atimes",atimes);
			System.out.println("the atimes are............"+atimes);
			String at[]=atimes.split(",");
			for(int i=1;i<at.length;i++)
			{
				
				System.out.println("the arrival time length is.........."+atimes.length());
				
				System.out.println("The arrival split times are................::::::::::::::::"+at[i]);
				ses.setAttribute("at"+i,at[i]);
				
			}
			String dtimes=sm.getDeparturetimes();
			ses.setAttribute("dtimes",dtimes);
			System.out.println("the depature times are................"+dtimes);
			String at1=sm.getArrivaltime();
			System.out.println("the start time is..........."+at1);
			String et=sm.getDeparturetime();
			System.out.println("the end time depature time .............."+et);
			
			//distance
			String distances=sm.getDistancefromsource();
			ses.setAttribute("dis",distances);
			
			
			
		}	
		
		BeanUtils.copyProperties(sb, sm);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::edittrain",e);
				}
		return new ModelAndView("updatetrain1");
	}
	
	
	@RequestMapping(value = "/deletetrain", method = RequestMethod.GET)
	public ModelAndView deletetrain(@ModelAttribute("command")TrainsBean tb, BindingResult result,HttpServletRequest request) {
		try{
		String id=request.getParameter("id");
		System.out.println("id.."+id);
		serviceadmin.deleteTrain(id);
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::edittrain",e);
				}
		return new ModelAndView("deletetrainsucc");
	}
	
	
	@RequestMapping(value = "/ktm_Stations", method = RequestMethod.POST)
	public @ResponseBody void stations(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try{
			System.out.println("coming to controller::::::::::::::::::::");
		response.setContentType("text/html");
		PrintWriter out=null;
	
		 out = response.getWriter();
		
		List lc= serviceadmin.getStations();
		 JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"lc"});
			config.setIgnoreDefaultExcludes(false);
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray json=JSONArray.fromObject(lc, config);
			 out.print(json);		
		        out.flush();
		        out.close();
		}
		catch(Exception e){log.error(
				"KTMCard&Ticketing ::AdminController ::ktm_Stations",e);
				}
	}
	
	@RequestMapping(value = "/addtrainssavesave", method = RequestMethod.GET)
	public ModelAndView addtrainssavesave(@ModelAttribute("command") TrainsBean tb,BindingResult result,HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
		System.out.println("enter into addtrainssavesave........................................in admin controller");
		try{
		TrainValidator td=new TrainValidator();
		td.validate(tb, result);
		TrainsModel sm=null;
		String id=request.getParameter("id");
		
		String stops=null;
		String atimes=null;
		String dtimes=null;
		String dfss=null;

		if(tb.getNumberofstops()!=null && !tb.getNumberofstops().equals(""))
		{
		 if(tb.getNumberofstops()=="1")
		 {
			 stops=request.getParameter("stop1");
			 if(stops==null || stops.equals(""))
			 {
				 result.rejectValue("stations","stations.invalid","stop1 is required.");

			 }
			 atimes=request.getParameter("arrivaltime1");
			 if(atimes==null || atimes.equals(""))
			 {
				 result.rejectValue("arrivaltimes","arrivaltimes.invalid","Arrivaltime1 is required.");

			 }
			 dtimes=request.getParameter("departuretime1");
			 if(dtimes==null || dtimes.equals(""))
			 {
				 result.rejectValue("departuretimes","departuretimes.invalid","Departuretime1 is required.");

			 }
			 dfss=request.getParameter("departuretime1");
			 if(dfss==null ||dfss.equals(""))
			 {
				 result.rejectValue("distancefromsource","distancefromsource.invalid","Distancefromsource1 is required.");

			 }

		 }
		 else
		 {
		 for(int i=0;i<Integer.parseInt(tb.getNumberofstops());i++)
		 {
			 int k=i+1;
			 String p="";

			 String src=request.getParameter("stop"+i);
			 String arc=request.getParameter("arrivaltime"+i);
			 String drc=request.getParameter("departuretime"+i);
			 String dfs=request.getParameter("distance"+i);
			
			
			 if(request.getParameter("stop"+i).equals("") || request.getParameter("stop"+i)==null)
			 {
				 result.rejectValue("stations","stations.invalid","stop"+k+" is required.");

			 }
			 else if(request.getParameter("stop"+i).equals(tb.getSource())){
				 result.rejectValue("stations","stations.invalid","Stop"+k+" should not match with source value.");
				 
			 }
             else if(request.getParameter("stop"+i).equals(tb.getDestination())){
				 
            	   result.rejectValue("stations","stations.invalid","Stop"+k+" should not match with destination value");
			 }
			 else
			 {}
				 		
			 if(stops==null)
			 {
				 stops =src;
			 }
			 else
			 {
			 stops=stops+","+src;
			 }
			 
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("stop"+k)!=null && !request.getParameter("stop"+k).equals(""))
				 {
			 if(stops.contains(request.getParameter("stop"+k).substring(0,3)))
					 {
				 		result.rejectValue("stations", "stations.invalid","No two stops must be equal.");

					 }
				 }
			 }
			 
			 if(request.getParameter("arrivaltime"+i).equals("") || request.getParameter("arrivaltime"+i)==null)
			 {
				 result.rejectValue("arrivaltimes","arivaltimes.invalid","Arrivaltime"+k+" is required.");

			 }
			 else if(request.getParameter("arrivaltime"+i).equals(tb.getArrivaltime())){
				 result.rejectValue("arrivaltimes","arrivaltimes.invalid","Arrival time"+k+" should not match with ArrivalTime");
				 
			 }
             else if(request.getParameter("arrivaltime"+i).equals(tb.getDeparturetime())){
				 
            	   result.rejectValue("arrivaltimes","arrivaltimes.invalid","Arrival time"+k+" should not match with DepartureTime");
			 }
			 else
			 {}
				 		
			 if(atimes==null)
			 {
				 atimes =arc;
			 }
			 else
			 {
				 atimes=atimes+","+arc;
			 }
			
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("arrivaltime"+k)!=null && !request.getParameter("arrivaltime"+k).equals(""))
				 {
			 if(atimes.contains(request.getParameter("arrivaltime"+k)))
					 {
				 		result.rejectValue("arrivaltimes", "arrivaltimes.invalid","No two Arrival times equal.");

					 }
				 }
			 }
			 
			 
			 if(request.getParameter("departuretime"+i).equals("") || request.getParameter("departuretime"+i)==null)
			 {
				 result.rejectValue("departuretimes","departuretimes.invalid","departuretime"+k+" is required.");

			 }
			 else if(request.getParameter("departuretime"+i).equals(tb.getArrivaltime())){
				 result.rejectValue("departuretimes","departuretimes.invalid","Depature time"+k+" should not match with ArrivalTime");
				 
			 }
             else if(request.getParameter("departuretime"+i).equals(tb.getDeparturetime())){
				 
            	   result.rejectValue("departuretimes","departuretimes.invalid","Depature time"+k+" should not match with DepartureTime");
			 }
			 else
			 {}
				 		
			 if(dtimes==null)
			 {
				 dtimes =drc;
			 }
			 else
			 {
				 dtimes=dtimes+","+drc;
			 }
			 
			
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("departuretime"+k)!=null && !request.getParameter("departuretime"+k).equals(""))
				 {
			 if(dtimes.contains(request.getParameter("departuretime"+k)))
					 {
				 		result.rejectValue("departuretimes", "departuretimes.invalid","No two Depature times equal.");

					 }
				 }
			 }
			 
			 
			 if(request.getParameter("distance"+i).equals("") || request.getParameter("distance"+i)==null)
			 {
				 result.rejectValue("distancefromsource","distancefromsource.invalid","distancefromsource"+k+" is required.");

			 }
			 else
			 {}
				 		
			 if(dfss==null)
			 {
				 dfss =dfs;
			 }
			 else
			 {
				 dfss=dfss+","+dfs;
			 }
			 
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("distance"+k)!=null && !request.getParameter("distance"+k).equals(""))
				 {
					 
			 if((Integer.parseInt(request.getParameter("distance"+k)))<=(Integer.parseInt(request.getParameter("distance"+i))))
					 {
				 		result.rejectValue("distancefromsource", "distancefromsource.invalid","distancefromsource"+k+" is must be greter than distancefromsource"+i+"");

					 }
			 
				 }
			 }
		 }
		 //for loop ending
		 String j[]=atimes.split(",");
		 String o[]=dtimes.split(",");
		 System.out.println("the length of atimes is..........."+j.length);
		 System.out.println("the length of dtimes is..........."+o.length);
		 if((o.length>1)&&(j.length>1)&&(!tb.getArrivaltime().equals("")))
		 {
		 for(int i=0;i<j.length;i++){
			 for(int l=0;l<j.length;l++){
			 if(j[i].equals(o[l]))
			 {
				 
				 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(l+1)+" is not equal to arrivaltime"+(i+1)+"");
			 }
			 }
			 
		 }
		 System.out.println("111111111111111111111111111111111111");
		 
		 for(int m=0;m<j.length-1;m++)
		 {
			 System.out.println("enter into for loopp......");
			 String x[]=j[m].split(":");
			 String y[]=j[m+1].split(":");
			 String z[]=o[m].split(":");
			 
			if((Integer.parseInt(x[0])>Integer.parseInt(z[0]))||(Integer.parseInt(y[0])<Integer.parseInt(z[0])))
			{
				 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
			}
			
			else if((Integer.parseInt(x[0])==Integer.parseInt(z[0]))&&(Integer.parseInt(y[0])==Integer.parseInt(z[0])))
			{
				
				boolean a=Integer.parseInt(x[0])==Integer.parseInt(z[0]);
				boolean b=Integer.parseInt(y[0])==Integer.parseInt(z[0]);
				System.out.println("........a.....b........."+x[0]+".."+z[0]+".."+y[0]+"...."+a+".."+b);
					boolean a1=Integer.parseInt(x[1])>Integer.parseInt(z[1]);
					boolean b1=Integer.parseInt(y[1])<Integer.parseInt(z[1]);
				
					if(a1||b1)
					{
						System.out.println("......a1 ...b1............."+x[1]+".."+z[1]+".."+y[1]+"...."+a1+".."+b1);
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature times"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
					}
					}
			
			else if((Integer.parseInt(y[0])>Integer.parseInt(z[0]))&&((Integer.parseInt(x[0]))==(Integer.parseInt(z[0]))))
			{
				boolean b1=Integer.parseInt(y[1])<Integer.parseInt(z[1]);
				boolean a1=Integer.parseInt(x[1])>Integer.parseInt(z[1]);
				System.out.println(".............1111......."+a1);
				System.out.println("...................."+b1);
				
				if(a1)
				{
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature times1"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
				}	
				
					
			}
			
			else if((Integer.parseInt(y[0])==Integer.parseInt(z[0]))&&((Integer.parseInt(x[0]))<(Integer.parseInt(z[0]))))
			{
				boolean b1=Integer.parseInt(y[1])<Integer.parseInt(z[1]);
				boolean a1=Integer.parseInt(x[1])>Integer.parseInt(z[1]);
				System.out.println("............22222........"+a1);
				System.out.println("...................."+b1);
				
				if(b1)
				{
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature times2"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
				}		
				
					
			}
				  
		 }
		 //for loop ending
		 if(!(j[j.length-1].equals(null))&&!(o[j.length-1].equals(null))){
		 String x[]=j[j.length-1].split(":");
		 String z[]=o[j.length-1].split(":");
		
		 String de[]=tb.getArrivaltime().split(":");
		
		 if((Integer.parseInt(x[0])>Integer.parseInt(z[0])))
			{
			 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(j.length)+" must be greater than  arrivaltime"+(j.length)+" and less than DepatureTime");		
			}
			else{
				
				boolean a=(Integer.parseInt(x[0])==Integer.parseInt(z[0]));
				boolean b=Integer.parseInt(de[0])==Integer.parseInt(z[0]);
				System.out.println("............................."+a+".........."+b+"............");
				if(a||b)
				{
					if((Integer.parseInt(x[1])>Integer.parseInt(z[1])))
					{
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(j.length)+" must be greater than  arrivaltime"+(j.length)+" and less than DepatureTime");	
					}
				}	
				
				
			}
		  
		 }
		 
		 }
	
		 
		 }  
		}
		System.out.println("The stops are...................."+stops);
		System.out.println("The arrival times are...................."+atimes);
		System.out.println("The depature times are...................."+dtimes);
		System.out.println("The distances are...................."+dfss);
		
		
		
		if(result.hasErrors())
		{
			Map map=new HashMap();
			stops=tb.getSource()+","+stops+","+tb.getDestination();
			atimes=tb.getArrivaltime()+","+atimes+","+tb.getDeparturetime();
			dtimes=tb.getArrivaltime()+","+dtimes+","+tb.getDeparturetime();
			dfss="0"+","+dfss+","+tb.getDistancefromsource();
			/*map.put("stations",stops);
			map.put("arrivaltimes",atimes);
			map.put("depaturetimes",dtimes);
			map.put("distancefromsource",dfss);*/
			tb.setStations(stops);
			tb.setArrivaltimes(atimes);
			tb.setDeparturetimes(dtimes);
			tb.setDistancefromsource(dfss);
			map.put("command",tb);
			return new ModelAndView("addtrains1",map);
		}
		
		
		
		TrainsModel tm=new TrainsModel();
		String k=tb.getNumberofstops();
		System.out.println("the no.of.stops is:::::::" +k);
		int m=Integer.parseInt(k);
		System.out.println("the integer number isss::::::" +m);
		String st="";
		String at="";
		String dt="";
		String dis="";
		for(int i=0;i<m;i++)
		{
			String j=request.getParameter("stop"+i);
			if(st=="")
			{
			st=j;	
			}
			else
			{
				st=st+","+j;
			}
			
			System.out.println("the stations is:::::" +st);
			
			String a=request.getParameter("arrivaltime"+i);
			if(at=="")
			{
			at=a;	
			}
			else
			{
				at=at+","+a;
			}
			System.out.println("the arrival times is::::" +at);
			String d=request.getParameter("departuretime"+i);
			if(dt=="")
			{
			dt=d;	
			}
			else
			{
				dt=dt+","+d;
			}
			System.out.println("the departuretime times is::::" +dt);
			String ds=request.getParameter("distance"+i);
			if(dis=="")
			{
			dis=ds;	
			}
			else
			{
				dis=dis+","+ds;
			}
			System.out.println("the distance times is::::" +dis);
		}
		String ss=tb.getSource()+","+st+","+tb.getDestination();
		String ats=tb.getArrivaltime()+","+at+","+tb.getDeparturetime();
		String dts=tb.getArrivaltime()+","+dt+","+tb.getDeparturetime();
		String diss="0"+","+dis+","+tb.getTotalkms();
		BeanUtils.copyProperties(tm,tb);
		tm.setStations(ss);
		tm.setArrivaltimes(ats);
		tm.setDeparturetimes(dts);
		tm.setDistancefromsource(diss);
		serviceadmin.savetraindetails(tm);
		}catch(Exception e){System.out.println("the Exception is......................"+e);}
		
		return new ModelAndView("viewtrains1");
		}
	
	@RequestMapping(value = "/updatetrains1", method = RequestMethod.GET)
	public ModelAndView addtrainssavesave1(@ModelAttribute("command") TrainsBean tb,BindingResult result,HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
		System.out.println("enter into updatetrains........................................in admin controller");
		try{
		TrainValidator td=new TrainValidator();
		td.validate(tb, result);
		TrainsModel sm=null;
		String id=request.getParameter("id");
		
		String stops=null;
		String atimes=null;
		String dtimes=null;
		String dfss=null;

		if(tb.getNumberofstops()!=null && !tb.getNumberofstops().equals(""))
		{
		 if(tb.getNumberofstops()=="1")
		 {
			 stops=request.getParameter("stop1");
			 if(stops==null || stops.equals(""))
			 {
				 result.rejectValue("stations","stations.invalid","stop1 is required.");

			 }
			 atimes=request.getParameter("arrivaltime1");
			 if(atimes==null || atimes.equals(""))
			 {
				 result.rejectValue("arrivaltimes","arrivaltimes.invalid","Arrivaltime1 is required.");

			 }
			 dtimes=request.getParameter("departuretime1");
			 if(dtimes==null || dtimes.equals(""))
			 {
				 result.rejectValue("departuretimes","departuretimes.invalid","Departuretime1 is required.");

			 }
			 dfss=request.getParameter("departuretime1");
			 if(dfss==null ||dfss.equals(""))
			 {
				 result.rejectValue("distancefromsource","distancefromsource.invalid","Distancefromsource1 is required.");

			 }

		 }
		 else
		 {
		 for(int i=0;i<Integer.parseInt(tb.getNumberofstops());i++)
		 {
			 int k=i+1;
			 String p="";

			 String src=request.getParameter("stop"+i);
			 String arc=request.getParameter("arrivaltime"+i);
			 String drc=request.getParameter("departuretime"+i);
			 String dfs=request.getParameter("distance"+i);
			
			
			 if(request.getParameter("stop"+i).equals("") || request.getParameter("stop"+i)==null)
			 {
				 result.rejectValue("stations","stations.invalid","stop"+k+" is required.");

			 }
			 else if(request.getParameter("stop"+i).equals(tb.getSource())){
				 result.rejectValue("stations","stations.invalid","Stop"+k+" should not match with source value.");
				 
			 }
             else if(request.getParameter("stop"+i).equals(tb.getDestination())){
				 
            	   result.rejectValue("stations","stations.invalid","Stop"+k+" should not match with destination value");
			 }
			 else
			 {}
				 		
			 if(stops==null)
			 {
				 stops =src;
			 }
			 else
			 {
			 stops=stops+","+src;
			 }
			 
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("stop"+k)!=null && !request.getParameter("stop"+k).equals(""))
				 {
			 if(stops.contains(request.getParameter("stop"+k).substring(0,3)))
					 {
				 		result.rejectValue("stations", "stations.invalid","No two stops must be equal.");

					 }
				 }
			 }
			 
			 if(request.getParameter("arrivaltime"+i).equals("") || request.getParameter("arrivaltime"+i)==null)
			 {
				 result.rejectValue("arrivaltimes","arivaltimes.invalid","Arrivaltime"+k+" is required.");

			 }
			 else if(request.getParameter("arrivaltime"+i).equals(tb.getArrivaltime())){
				 result.rejectValue("arrivaltimes","arrivaltimes.invalid","Arrival time"+k+" should not match with ArrivalTime");
				 
			 }
             else if(request.getParameter("arrivaltime"+i).equals(tb.getDeparturetime())){
				 
            	   result.rejectValue("arrivaltimes","arrivaltimes.invalid","Arrival time"+k+" should not match with DepartureTime");
			 }
			 else
			 {}
				 		
			 if(atimes==null)
			 {
				 atimes =arc;
			 }
			 else
			 {
				 atimes=atimes+","+arc;
			 }
			
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("arrivaltime"+k)!=null && !request.getParameter("arrivaltime"+k).equals(""))
				 {
			 if(atimes.contains(request.getParameter("arrivaltime"+k)))
					 {
				 		result.rejectValue("arrivaltimes", "arrivaltimes.invalid","No two Arrival times equal.");

					 }
				 }
			 }
			 
			 
			 if(request.getParameter("departuretime"+i).equals("") || request.getParameter("departuretime"+i)==null)
			 {
				 result.rejectValue("departuretimes","departuretimes.invalid","departuretime"+k+" is required.");

			 }
			 else if(request.getParameter("departuretime"+i).equals(tb.getArrivaltime())){
				 result.rejectValue("departuretimes","departuretimes.invalid","Depature time"+k+" should not match with ArrivalTime");
				 
			 }
             else if(request.getParameter("departuretime"+i).equals(tb.getDeparturetime())){
				 
            	   result.rejectValue("departuretimes","departuretimes.invalid","Depature time"+k+" should not match with DepartureTime");
			 }
			 else
			 {}
				 		
			 if(dtimes==null)
			 {
				 dtimes =drc;
			 }
			 else
			 {
				 dtimes=dtimes+","+drc;
			 }
			 
			
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("departuretime"+k)!=null && !request.getParameter("departuretime"+k).equals(""))
				 {
			 if(dtimes.contains(request.getParameter("departuretime"+k)))
					 {
				 		result.rejectValue("departuretimes", "departuretimes.invalid","No two Depature times equal.");

					 }
				 }
			 }
			 
			 
			 if(request.getParameter("distance"+i).equals("") || request.getParameter("distance"+i)==null)
			 {
				 result.rejectValue("distancefromsource","distancefromsource.invalid","distancefromsource"+k+" is required.");

			 }
			 else
			 {}
				 		
			 if(dfss==null)
			 {
				 dfss =dfs;
			 }
			 else
			 {
				 dfss=dfss+","+dfs;
			 }
			 
			 if(stops!=null && !stops.equals(""))
			 {
				 if(request.getParameter("distance"+k)!=null && !request.getParameter("distance"+k).equals(""))
				 {
					 
			 if((Integer.parseInt(request.getParameter("distance"+k)))<=(Integer.parseInt(request.getParameter("distance"+i))))
					 {
				 		result.rejectValue("distancefromsource", "distancefromsource.invalid","distancefromsource"+k+" is must be greter than distancefromsource"+i+"");

					 }
			 
				 }
			 }
		 }
		 //for loop ending
		 String j[]=atimes.split(",");
		 String o[]=dtimes.split(",");
		 System.out.println("the length of atimes is..........."+j.length);
		 System.out.println("the length of dtimes is..........."+o.length);
		 if((o.length>1)&&(j.length>1)&&(!tb.getArrivaltime().equals("")))
		 {
		 for(int i=0;i<j.length;i++){
			 for(int l=0;l<j.length;l++){
			 if(j[i].equals(o[l]))
			 {
				 
				 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(l+1)+" is not equal to arrivaltime"+(i+1)+"");
			 }
			 }
			 
		 }
		 System.out.println("111111111111111111111111111111111111");
		 
		 for(int m=0;m<j.length-1;m++)
		 {
			 System.out.println("enter into for loopp......");
			 String x[]=j[m].split(":");
			 String y[]=j[m+1].split(":");
			 String z[]=o[m].split(":");
			 
			if((Integer.parseInt(x[0])>Integer.parseInt(z[0]))||(Integer.parseInt(y[0])<Integer.parseInt(z[0])))
			{
				 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
			}
			
			else if((Integer.parseInt(x[0])==Integer.parseInt(z[0]))&&(Integer.parseInt(y[0])==Integer.parseInt(z[0])))
			{
				
				boolean a=Integer.parseInt(x[0])==Integer.parseInt(z[0]);
				boolean b=Integer.parseInt(y[0])==Integer.parseInt(z[0]);
				System.out.println("........a.....b........."+x[0]+".."+z[0]+".."+y[0]+"...."+a+".."+b);
					boolean a1=Integer.parseInt(x[1])>Integer.parseInt(z[1]);
					boolean b1=Integer.parseInt(y[1])<Integer.parseInt(z[1]);
				
					if(a1||b1)
					{
						System.out.println("......a1 ...b1............."+x[1]+".."+z[1]+".."+y[1]+"...."+a1+".."+b1);
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature times"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
					}
					}
			
			else if((Integer.parseInt(y[0])>Integer.parseInt(z[0]))&&((Integer.parseInt(x[0]))==(Integer.parseInt(z[0]))))
			{
				boolean b1=Integer.parseInt(y[1])<Integer.parseInt(z[1]);
				boolean a1=Integer.parseInt(x[1])>Integer.parseInt(z[1]);
				System.out.println(".............1111......."+a1);
				System.out.println("...................."+b1);
				
				if(a1)
				{
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature times1"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
				}	
				
					
			}
			
			else if((Integer.parseInt(y[0])==Integer.parseInt(z[0]))&&((Integer.parseInt(x[0]))<(Integer.parseInt(z[0]))))
			{
				boolean b1=Integer.parseInt(y[1])<Integer.parseInt(z[1]);
				boolean a1=Integer.parseInt(x[1])>Integer.parseInt(z[1]);
				System.out.println("............22222........"+a1);
				System.out.println("...................."+b1);
				
				if(b1)
				{
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature times2"+(m+1)+" must between arrivaltime"+(m+1)+" and arrivaltime"+(m+2)+"");	
				}		
				
					
			}
				  
		 }
		 //for loop ending
		 if(!(j[j.length-1].equals(null))&&!(o[j.length-1].equals(null))){
		 String x[]=j[j.length-1].split(":");
		 String z[]=o[j.length-1].split(":");
		
		 String de[]=tb.getArrivaltime().split(":");
		
		 if((Integer.parseInt(x[0])>Integer.parseInt(z[0])))
			{
			 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(j.length)+" must be greater than  arrivaltime"+(j.length)+" and less than DepatureTime");		
			}
			else{
				
				boolean a=(Integer.parseInt(x[0])==Integer.parseInt(z[0]));
				boolean b=Integer.parseInt(de[0])==Integer.parseInt(z[0]);
				System.out.println("............................."+a+".........."+b+"............");
				if(a||b)
				{
					if((Integer.parseInt(x[1])>Integer.parseInt(z[1])))
					{
					 result.rejectValue("departuretimes", "departuretimes.invalid","depature time"+(j.length)+" must be greater than  arrivaltime"+(j.length)+" and less than DepatureTime");	
					}
				}	
				
				
			}
		  
		 }
		 
		 }
	
		 
		 }  
		}
		System.out.println("The stops are...................."+stops);
		System.out.println("The arrival times are...................."+atimes);
		System.out.println("The depature times are...................."+dtimes);
		System.out.println("The distances are...................."+dfss);
		
		
		
		if(result.hasErrors())
		{
			Map map=new HashMap();
			stops=tb.getSource()+","+stops+","+tb.getDestination();
			atimes=tb.getArrivaltime()+","+atimes+","+tb.getDeparturetime();
			dtimes=tb.getArrivaltime()+","+dtimes+","+tb.getDeparturetime();
			dfss="0"+","+dfss+","+tb.getDistancefromsource();
			/*map.put("stations",stops);
			map.put("arrivaltimes",atimes);
			map.put("depaturetimes",dtimes);
			map.put("distancefromsource",dfss);*/
			tb.setStations(stops);
			tb.setArrivaltimes(atimes);
			tb.setDeparturetimes(dtimes);
			tb.setDistancefromsource(dfss);
			map.put("command",tb);
			return new ModelAndView("updatetrain1",map);
		}
		
		
		
		TrainsModel tm=new TrainsModel();
		String k=tb.getNumberofstops();
		System.out.println("the no.of.stops is:::::::" +k);
		int m=Integer.parseInt(k);
		System.out.println("the integer number isss::::::" +m);
		String st="";
		String at="";
		String dt="";
		String dis="";
		for(int i=0;i<m;i++)
		{
			String j=request.getParameter("stop"+i);
			if(st=="")
			{
			st=j;	
			}
			else
			{
				st=st+","+j;
			}
			
			System.out.println("the stations is:::::" +st);
			
			String a=request.getParameter("arrivaltime"+i);
			if(at=="")
			{
			at=a;	
			}
			else
			{
				at=at+","+a;
			}
			System.out.println("the arrival times is::::" +at);
			String d=request.getParameter("departuretime"+i);
			if(dt=="")
			{
			dt=d;	
			}
			else
			{
				dt=dt+","+d;
			}
			System.out.println("the departuretime times is::::" +dt);
			String ds=request.getParameter("distance"+i);
			if(dis=="")
			{
			dis=ds;	
			}
			else
			{
				dis=dis+","+ds;
			}
			System.out.println("the distance times is::::" +dis);
		}
		String ss=tb.getSource()+","+st+","+tb.getDestination();
		String ats=tb.getArrivaltime()+","+at+","+tb.getDeparturetime();
		String dts=tb.getArrivaltime()+","+dt+","+tb.getDeparturetime();
		String diss="0"+","+dis+","+tb.getTotalkms();
		BeanUtils.copyProperties(tm,tb);
		tm.setStations(ss);
		tm.setArrivaltimes(ats);
		tm.setDeparturetimes(dts);
		tm.setDistancefromsource(diss);
		serviceadmin.savetraindetails(tm);
		}catch(Exception e){System.out.println("the Exception is......................"+e);}
		
		return new ModelAndView("viewtrains1");
		}
	
	@RequestMapping(value = "/viewtrains", method = RequestMethod.GET)
	public ModelAndView viewtrains(@ModelAttribute("command") TrainsBean sb) throws InvocationTargetException, IllegalAccessException {
			try{
				                   
			}
			catch(Exception e){log.error(
					"KTMCard&Ticketing ::AdminController ::viewtrains",e);
					}
		return new ModelAndView("viewtrains1");
	}
	
	@RequestMapping(value = "/ktm_StationsCode", method = RequestMethod.GET)
	public @ResponseBody void stationscode(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try{
		System.out.println("coming to controller::::::::::::::::::::");
		response.setContentType("text/html");
		PrintWriter out=null;
		String ps=null;
		out=response.getWriter();	
		String sname=request.getParameter("stationname");
		System.out.println("Station name is............. "+sname);
		 out = response.getWriter();
		
		List li= serviceadmin.getStationsCode(sname);
		Iterator itr = li.iterator();
		System.out.println(li.size());
		if(li.size()>0)
		{
		
			while(itr.hasNext())
			{
				ps = (String) itr.next();
			
				out.println(ps);
				
			}
			
		}
		

	}
	catch(Exception e){log.error(
			"KTMCard&Ticketing ::AdminController ::ktm_StationsCode",e);
			}
	}
}

