package com.ktmcard.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="KTM_RechargeTransaction")
public class UserRechargeTrasactionsModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Id
	@Column(name = "URTID")
	private String urtid;
	private String cardid;
	private String topup;
	private String inttopup;
	private String datetime;
	private String balance;
	private String username;
	private String password;
	private String txid;
	private String topupid;
	
	
	
	
	public String getUrtid() {
		return urtid;
	}
	public void setUrtid(String urtid) {
		this.urtid = urtid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTopup() {
		return topup;
	}
	public void setTopup(String topup) {
		this.topup = topup;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public String getTopupid() {
		return topupid;
	}
	public void setTopupid(String topupid) {
		this.topupid = topupid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getInttopup() {
		return inttopup;
	}
	public void setInttopup(String inttopup) {
		this.inttopup = inttopup;
	}
	
	
	

}
