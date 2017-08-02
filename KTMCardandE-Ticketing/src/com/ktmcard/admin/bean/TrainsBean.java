package com.ktmcard.admin.bean;

public class TrainsBean {

	private String trainid;
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	private String trainnumber;
	private String source;
	private String destination;
	private String arrivaltime;
	private String departuretime;
	private String numberofstops;
	private String stations;
	private String arrivaltimes;
	private String departuretimes;
	private String availabledays;
	private String basefare;
	private String distancefromsource;
	private String totalkms;
	private String btn;
	private String tktdate;
	private String totamnt;
	private String tottkts;
	private String totkmss;
	private String cardid;
	
	public String getTotamnt() {
		return totamnt;
	}
	public void setTotamnt(String totamnt) {
		this.totamnt = totamnt;
	}
	public String getTottkts() {
		return tottkts;
	}
	public void setTottkts(String tottkts) {
		this.tottkts = tottkts;
	}
	public String getTktdate() {
		return tktdate;
	}
	public void setTktdate(String tktdate) {
		this.tktdate = tktdate;
	}
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
	public String getDistancefromsource() {
		return distancefromsource;
	}
	public void setDistancefromsource(String distancefromsource) {
		this.distancefromsource = distancefromsource;
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
		
		numberofstops=numberofstops.trim().replaceAll(" ", "");
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
	public String getBasefare() {
		return basefare;
	}
	public void setBasefare(String basefare) {
		this.basefare = basefare;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTotkmss() {
		return totkmss;
	}
	public void setTotkmss(String totkmss) {
		this.totkmss = totkmss;
	}
	
	
	
}
