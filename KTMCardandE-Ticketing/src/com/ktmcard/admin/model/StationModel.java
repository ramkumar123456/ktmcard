package com.ktmcard.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="KTM_Station")
public class StationModel implements Serializable {
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stationid")
	private String stationid;
	@Column(name="stationname")
	private String stationname;
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getStationcode() {
		return stationcode;
	}
	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}
	@Column(name="stationcode")
	private String stationcode;
	
	
	
}
