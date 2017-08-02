package com.ktmcard.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.dao.DaoAdmin;
import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.StationModel;
import com.ktmcard.admin.model.TrainsModel;
import com.ktmcard.home.model.RegistrationModel;


@Service("ServiceAdmin")
@Transactional
public class ServiceAdminImplementation implements ServiceAdmin{
	@Autowired
	private DaoAdmin daoadmin;

	
	public List<RegistrationModel> loginlist(String username, String password) {
		return daoadmin.loginlist(username,password);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateadminprofile(RegistrationModel rm) {
		
		daoadmin.updateadminprofile(rm);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void changepassword(String username, String npd, String cnpd) {
		daoadmin.changepassword(username,npd,cnpd);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public void addcounters(CounterModel cm) {
		// TODO Auto-generated method stub
		daoadmin.addcounters(cm);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CounterModel> getCounters() {
		// TODO Auto-generated method stub
		return daoadmin.getCounters();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CounterModel> getCounterId(Integer id) {
		// TODO Auto-generated method stub
		return daoadmin.getCounterId(id);
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateCounter(CounterModel cm) {
		// TODO Auto-generated method stub
		daoadmin.updateCounter(cm);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCounter(String id) {
		// TODO Auto-generated method stub
		daoadmin.deleteCounter(id);
	}

	@Override
	public void adminupdateprofile(RegistrationModel rm) {
		// TODO Auto-generated method stub
		daoadmin.adminupdateprofile(rm);
	}
	
	
	@Override
	public List listoftotalrequstedcamps() {
		System.out.println("enter into ServiceAdminImplementation listoftotalrequstedcamps");
		
		return daoadmin.listoftotalrequstedcamps() ;
		
	}


	@Override
	public void deletecards(String id) {
	System.out.println("enter into deletecards in service admin implementations");
	daoadmin.deletecards(id);
		
	}


	@Override
	public void approvingcard(String acid) {
		System.out.println("enter into approvingcard in service admin implementations");
		daoadmin.approvingcard(acid);
	}


	@Override
	public void rejectingcard(String acid) {
		System.out.println("enter into approvingcard in service admin implementations");
		daoadmin.rejectingcard(acid);	
		
	}

	
	@Override
	@Transactional
	public void savestations(StationModel sm) {
		// TODO Auto-generated method stub
	daoadmin.savestations(sm);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List getStations() {
		// TODO Auto-generated method stub
		return daoadmin.getStations();
	}

	@Override
	@Transactional
	public void savetraindetails(TrainsModel tm) {
		// TODO Auto-generated method stub
		daoadmin.savetraindetails(tm);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List<TrainsModel> getTrains() {
		// TODO Auto-generated method stub
		return daoadmin.getTrains();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List<StationModel> getAllStations() {
		// TODO Auto-generated method stub
		return daoadmin.getAllStations();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List<StationModel> getStationId(String stationid) {
		// TODO Auto-generated method stub
		return daoadmin.getStationId(stationid);
	}

	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void updateStations(StationModel sm) {
		// TODO Auto-generated method stub
		daoadmin.updateStations(sm);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void deleteStation(String id) {
		// TODO Auto-generated method stub
		daoadmin.deleteStation(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List<TrainsModel> getTrainId(String id) {
		// TODO Auto-generated method stub
		return daoadmin.getTrainId(id);
	}

	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List getapplycardstatuslist(String status1) {
		System.out.println("enter into getapplycardstatuslist in service admin implementations");
		return daoadmin.getapplycardstatuslist(status1);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List<CounterModel> searchStationCode(String data) {
		// TODO Auto-generated method stub
		return daoadmin.searchStationCode(data);
	}

	@Override
	public List<StationModel> searchStations(String value) {
		// TODO Auto-generated method stub
		return daoadmin.searchStations(value);
	}

	@Override
	public List<TrainsModel> searchTrain(String tid) {
		// TODO Auto-generated method stub
		return daoadmin.searchTrain(tid);
	}

	@Override
	public List<CounterModel> usernameunique() {
		// TODO Auto-generated method stub
		return daoadmin.usernameunique();
	}

	@Override
	public void deleteTrain(String id) {
		daoadmin.deleteTrain(id);
	}

	@Override
	public List<StationModel> uniquestationslist() {
		return daoadmin.uniquestationslist();
	}

	@Override
	public void changepasswordlist(String username, String npd) {
		daoadmin.changepasswordlist(username,npd);		
	}

	@Override
	public List getStationsCode(String sname) {
		// TODO Auto-generated method stub
		return daoadmin.getStationsCode(sname);
	}
}
