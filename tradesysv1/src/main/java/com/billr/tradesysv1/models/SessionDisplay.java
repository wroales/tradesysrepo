package com.billr.tradesysv1.models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// This is a Helper Class to enable Simpler display to browser
// of currently logged in User information

public class SessionDisplay {
		
	private String SESSION_ID;
	private String PRINCIPAL_NAME;
	private long CREATION_TIME;
	private long EXPIRY_TIME;

	private Date expireDate;
	private Date createDate;
	private String connectTime;
	
	public String getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(String connectTime) {
		this.connectTime = connectTime;
	}
	
	public SessionDisplay() {}

	public String getSESSION_ID() {
		return SESSION_ID;
	}


	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}


	public String getPRINCIPAL_NAME() {
		return PRINCIPAL_NAME;
	}


	public void setPRINCIPAL_NAME(String pRINCIPAL_NAME) {
		PRINCIPAL_NAME = pRINCIPAL_NAME;
	}


//	public long getCREATION_TIME() {
//		return CREATION_TIME;
//	}

	public Date getCREATION_TIME(){
		long millis = TimeUnit.MILLISECONDS.convert(CREATION_TIME, TimeUnit.MILLISECONDS);
		createDate = new Date(millis);
	    return this.createDate;
	}

	public void setCREATION_TIME(long cREATION_TIME) {
		CREATION_TIME = cREATION_TIME;
	}


//	public long getEXPIRY_TIME() {
//		return EXPIRY_TIME;
//	}

	public Date getEXPIRY_TIME(){
		long millis = TimeUnit.MILLISECONDS.convert(EXPIRY_TIME, TimeUnit.MILLISECONDS);
		expireDate = new Date(millis);
	    return this.expireDate;
	}
	
	public void setEXPIRY_TIME(long eXPIRY_TIME) {
		EXPIRY_TIME = eXPIRY_TIME;
	}
	
	public Date getexpireDate() {
		return expireDate;
	}
	
	public void setexpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
 
	public Date getcreateDate() {
		return createDate;
	}

	public void setcreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}

