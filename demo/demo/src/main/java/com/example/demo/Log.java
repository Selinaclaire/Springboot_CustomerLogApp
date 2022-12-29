package com.example.demo;

import jakarta.persistence.Entity;

@Entity
public class Log {
	
	@jakarta.persistence.Id
	private String id;
	private String name;
	private String logtype;
	private String date;
	private String time;
	
	public Log() {}
	public Log(String id, String name, String logtype, String date, String time) {
		super();
		this.id = id;
		this.name = name;
		this.logtype = logtype;
		this.date = date;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogtype() {
		return logtype;
	}
	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
