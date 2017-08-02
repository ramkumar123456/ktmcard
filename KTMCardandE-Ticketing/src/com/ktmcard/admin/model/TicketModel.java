package com.ktmcard.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KTM_Ticket")
public class TicketModel implements Serializable{
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@Column(name="ticketnumber")
	private String ticketnumber;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="fare")
	private String fare;
	@Column(name="tktdate")
	private String tktdate;
	@Column(name="counterusername")
	private String counterusername;
	public String getCounterusername() {
		return counterusername;
	}
	public void setCounterusername(String counterusername) {
		this.counterusername = counterusername;
	}
	public String getTicketnumber() {
		return ticketnumber;
	}
	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
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
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getTktdate() {
		return tktdate;
	}
	public void setTktdate(String tktdate) {
		this.tktdate = tktdate;
	}
	
}
