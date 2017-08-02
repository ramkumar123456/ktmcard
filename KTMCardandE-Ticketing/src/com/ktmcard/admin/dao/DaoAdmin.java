package com.ktmcard.admin.dao;

import java.util.List;

import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.StationModel;
import com.ktmcard.admin.model.TrainsModel;
import com.ktmcard.home.model.RegistrationModel;

public interface DaoAdmin {

	List<RegistrationModel> loginlist(String username, String password);

	public void updateadminprofile(RegistrationModel rm);

	public void changepassword(String username, String npd, String cnpd);

	void addcounters(CounterModel cm);

	List<CounterModel> getCounters();
	public List<CounterModel> getCounterId(Integer id);


	public void updateCounter(CounterModel cm);

	void deleteCounter(String id);

	void adminupdateprofile(RegistrationModel rm);
	
	
	public List listoftotalrequstedcamps();

	public void deletecards(String id);

	public void approvingcard(String acid);

	public void rejectingcard(String acid);
	
	void savestations(StationModel sm);

	List getStations();

	void savetraindetails(TrainsModel tm);

	List<TrainsModel> getTrains();

	List<StationModel> getAllStations();
	List<StationModel> getStationId(String stationid);

	

	void updateStations(StationModel sm);

	void deleteStation(String id);

	List<TrainsModel> getTrainId(String id);

	

	List getapplycardstatuslist(String status1);

	List<CounterModel> searchStationCode(String data);

	List<StationModel> searchStations(String value);

	List<TrainsModel> searchTrain(String tid);

	List<CounterModel> usernameunique();

	public void deleteTrain(String id);

	List<StationModel> uniquestationslist();

	void changepasswordlist(String username, String npd);

	List getStationsCode(String sname);
	
}
