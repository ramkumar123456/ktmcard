package com.ktmcard.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;











import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktmcard.admin.model.CounterModel;
import com.ktmcard.admin.model.StationModel;
import com.ktmcard.admin.model.TrainsModel;
import com.ktmcard.home.model.ApplyCardModel;
import com.ktmcard.home.model.RegistrationModel;
import com.ktmcard.home.model.UserRole;
import com.ktmcard.home.model.Userslist;

@Repository("DaoAdmin")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoAdminImplementation implements DaoAdmin{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<RegistrationModel> loginlist(String username, String password) {

		return sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"' and password='"+password+"'").list();
	}
	
	public void updateadminprofile(RegistrationModel rm) {
		System.out.println("enter dao impln admin");
		System.out.println("id for reg..."+rm.getId());
		sessionFactory.getCurrentSession().saveOrUpdate(rm);
	}

	@Override
	public void changepassword(String username, String npd, String cnpd) {
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+npd+"',conformpassword='"+cnpd+"' where username='"+username+"'").executeUpdate();
		
	}

	@Override
	public void addcounters(CounterModel cm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(cm);
		
		//.........save to users list...
		
				Userslist ul=new Userslist();

				ul.setUsername(cm.getUsername());
				ul.setPassword(cm.getPassword());
				ul.setEnabled(false);
				ul.setStatus("Inactive");
				ul.setType(cm.getType());
				sessionFactory.getCurrentSession().save(ul);
				String Active="Active";
				String username=cm.getUsername();
				System.out.println(username);
				sessionFactory.getCurrentSession().createQuery("update Userslist set enabled='"+1+"',status = '"+Active+"' WHERE USERNAME='"+username+"'").executeUpdate();
				
				 //............save users role....
				
		        UserRole userrole=new UserRole();
		        userrole.setUsersListModel(ul);
		        if(cm.getType().equalsIgnoreCase("Counter"))
		         {
		        userrole.setRole("ROLE_Counter");
		         }
		        
		sessionFactory.getCurrentSession().merge(userrole);

		 System.out.println("Insertion over......");

	}

	@SuppressWarnings("unchecked")
	public List<CounterModel> getCounters() {
		// TODO Auto-generated method stub
		return (List<CounterModel>) 
				 sessionFactory.getCurrentSession().createCriteria(CounterModel.class).addOrder(Order.asc("id")).list();
	}
	@SuppressWarnings("unchecked")
	public List<CounterModel> getCounterId(Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From CounterModel where id='"+id+"'").list();
	}

	
	public void updateCounter(CounterModel cm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(cm);
	}

	@Override
	public void deleteCounter(String id) {
	
		sessionFactory.getCurrentSession().createQuery("DELETE FROM CounterModel WHERE  id = '"+id+"'").executeUpdate();
	}
	@Override
	public void adminupdateprofile(RegistrationModel rm) {
	
		sessionFactory.getCurrentSession().update(rm);
	}

	
	public List listoftotalrequstedcamps() {
		System.out.println("enter into DaoAdminImplementation listoftotalrequstedcamps");
		
		List li= sessionFactory.getCurrentSession().createCriteria(ApplyCardModel.class).list();
		System.out.println("The requested cards list size is............."+li.size());
		return li;
		
	}

	@Override
	public void deletecards(String id) {
	System.out.println("enter into admin dao implementatio deletecards");
	String query="DELETE ApplyCardModel WHERE acid='"+id+"'";
	sessionFactory.getCurrentSession().createQuery("DELETE ApplyCardModel WHERE acid='"+id+"'").executeUpdate();
		
	}

	@Override
	public void approvingcard(String acid) {
		System.out.println("enter into admin dao implementation approvingcard");
		
		String Query="UPDATE ApplyCardModel SET STATUS='Approved' WHERE ACID='"+acid+"'";

		sessionFactory.getCurrentSession().createQuery(Query).executeUpdate();
	}

	@Override
	public void rejectingcard(String acid) {
		String Query="UPDATE ApplyCardModel SET STATUS='Rejected' WHERE ACID='"+acid+"'";

		sessionFactory.getCurrentSession().createQuery(Query).executeUpdate();
		
	}
	
	@Override
	public void savestations(StationModel sm) {
		// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().save(sm);
		
	}
	@Override
	public List getStations() {
		// TODO Auto-generated method stub
		List li=sessionFactory.getCurrentSession().createQuery("from com.ktmcard.admin.model.StationModel").list();

		return li;
	}
	@Override
	public void savetraindetails(TrainsModel tm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(tm);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TrainsModel> getTrains() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(TrainsModel.class).addOrder(Order.asc("id")).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StationModel> getAllStations() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(StationModel.class).addOrder(Order.asc("id")).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StationModel> getStationId(String stationid) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From StationModel where stationid='"+stationid+"'").list();
	}
	
	@Override
	public void updateStations(StationModel sm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(sm);
	}
	@Override
	public void deleteStation(String id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM StationModel WHERE  id = '"+id+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TrainsModel> getTrainId(String id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From TrainsModel where trainid='"+id+"'").list();
	}

	
	
	@Override
	public List getapplycardstatuslist(String status1) {
		System.out.println("enter into DaoAdminImplementation getapplycardstatuslist");

		String query="FROM ApplyCardModel where STATUS like'%"+status1+"%'";
		List li= sessionFactory.getCurrentSession().createQuery(query).list();
		System.out.println("The requested cards list size is............."+li.size());
		return li;
	}

	@SuppressWarnings("unchecked")
	public List<CounterModel> searchStationCode(String data) {
		return sessionFactory.getCurrentSession().createQuery("From CounterModel where UPPER(stationname) like UPPER('%"+data+"%') or UPPER(stationcode) like UPPER('%"+data+"%')").list();
	}

	@SuppressWarnings("unchecked")
	public List<StationModel> searchStations(String value) {
		return sessionFactory.getCurrentSession().createQuery("From StationModel where UPPER(stationname) like UPPER('%"+value+"%') or UPPER(stationcode) like UPPER('%"+value+"%')").list();
	}

	@SuppressWarnings("unchecked")
	public List<TrainsModel> searchTrain(String tid) {
		return sessionFactory.getCurrentSession().createQuery("From TrainsModel where trainnumber='"+tid+"'").list();
	}

	@SuppressWarnings("unchecked")
	public List<CounterModel> usernameunique() {
		return  (List<CounterModel>) sessionFactory.getCurrentSession().createCriteria(CounterModel.class).list();
	}

	@Override
	public void deleteTrain(String id) {
		
	sessionFactory.getCurrentSession().createQuery("DELETE FROM TrainsModel WHERE  id = '"+id+"'").executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<StationModel> uniquestationslist() {
		return sessionFactory.getCurrentSession().createCriteria(StationModel.class).list();

	}

	@Override
	public void changepasswordlist(String username, String npd) {
		sessionFactory.getCurrentSession().createQuery("update Userslist set password='"+npd+"' where username='"+username+"'").executeUpdate();
		
	}

	@Override
	public List getStationsCode(String sname) {
		return sessionFactory.getCurrentSession().createQuery("select stationcode from StationModel where stationname='"+sname+"'").list();

	}

	
}
