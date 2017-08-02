package com.ktmcard.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="KTM_Counter")
public class CounterModel implements Serializable{
	
		private static final long serialVersionUID = -723583058586873479L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
		private Integer id;
		
		@Column(name="username")
		private String username;
		
		@Column(name="password")
		private String password;
		
		@Column(name="conformpassword")
		private String conformpassword;
		
		@Column(name="stationname")
		private String stationname;
		
		@Column(name="stationcode")
		private String stationcode;
		
		@Column(name="city")
		private String city;
		
		
		@Column(name="pincode")
		private String pincode;
		
		@Column(name="type")
		private String type;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
		public String getConformpassword() {
			return conformpassword;
		}
		public void setConformpassword(String conformpassword) {
			this.conformpassword = conformpassword;
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
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
	
}
