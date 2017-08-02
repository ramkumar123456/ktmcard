package com.ktmcard.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KTM_Train")
public class TrainsModel implements Serializable{
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trainid")
	private String trainid;
	@Column(name="trainnumber")
	private String trainnumber;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="arrivaltime")
	private String arrivaltime;
	@Column(name="departuretime")
	private String departuretime;
	@Column(name="numberofstops")
	private String numberofstops;
	@Column(name="stations")
	private String stations;
	@Column(name="arrivaltimes")
	private String arrivaltimes;
	@Column(name="distancefromsource")
	private String distancefromsource;
	@Column(name="basefare")
	private String basefare;
	@Column(name="totalkms")
	private String totalkms;
	@Column(name="btn")
	private String btn;
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}
	public String getTotalkms() {
		return totalkms;
	}
	public void setTotalkms(String totalkms) {
		this.totalkms = totalkms;
	}
	public String getBasefare() {
		return basefare;
	}
	public void setBasefare(String basefare) {
		this.basefare = basefare;
	}
	public String getDistancefromsource() {
		return distancefromsource;
	}
	public void setDistancefromsource(String distancefromsource) {
		this.distancefromsource = distancefromsource;
	}
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	public String getTrainnumber() {
		return trainnumber;
	}
	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public String getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}
	public String getNumberofstops() {
		return numberofstops;
	}
	public void setNumberofstops(String numberofstops) {
		this.numberofstops = numberofstops;
	}
	public String getStations() {
		return stations;
	}
	public void setStations(String stations) {
		this.stations = stations;
	}
	public String getArrivaltimes() {
		return arrivaltimes;
	}
	public void setArrivaltimes(String arrivaltimes) {
		this.arrivaltimes = arrivaltimes;
	}
	public String getDeparturetimes() {
		return departuretimes;
	}
	public void setDeparturetimes(String departuretimes) {
		this.departuretimes = departuretimes;
	}
	public String getAvailabledays() {
		return availabledays;
	}
	public void setAvailabledays(String availabledays) {
		this.availabledays = availabledays;
	}
	@Column(name="departuretimes")
	private String departuretimes;
	@Column(name="availabledays")
	private String availabledays;
}
