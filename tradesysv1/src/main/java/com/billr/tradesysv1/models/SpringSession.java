package com.billr.tradesysv1.models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "spring_session", schema = "trade")
public class SpringSession {
	
//	CREATE TABLE SPRING_SESSION (
//			  PRIMARY_ID CHAR(36) NOT NULL,
//			  SESSION_ID CHAR(36) NOT NULL,
//			  CREATION_TIME BIGINT NOT NULL,
//			  LAST_ACCESS_TIME BIGINT NOT NULL,
//			  MAX_INACTIVE_INTERVAL INT NOT NULL,
//			  EXPIRY_TIME BIGINT NOT NULL,
//			  PRINCIPAL_NAME VARCHAR(100),
//			  CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
//			);

	@Id
	@Column(name = "PRIMARY_ID", nullable=false)
	private String PRIMARY_ID;	
	
	@Column(name = "SESSION_ID", nullable=false)
	private String SESSION_ID;
	@Column(name = "CREATION_TIME", nullable=false)
	private long CREATION_TIME;
	@Column(name = "LAST_ACCESS_TIME", nullable=false)
	private long LAST_ACCESS_TIME;
	@Column(name = "MAX_INACTIVE_INTERVAL", nullable=false)
	private int MAX_INACTIVE_INTERVAL;
	@Column(name = "EXPIRY_TIME", nullable=false)
	private long EXPIRY_TIME;
	@Column(name = "PRINCIPAL_NAME", nullable=true)
	private String PRINCIPAL_NAME;
	
	//private Date createDate;
	
	public SpringSession() {}
	
	public String getPRIMARY_ID() {
		return PRIMARY_ID;
	}

	public void setPRIMARY_ID(String pRIMARY_ID) {
		PRIMARY_ID = pRIMARY_ID;
	}

	public String getSESSION_ID() {
		return SESSION_ID;
	}

	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}

	public long getCREATION_TIME() {
		return CREATION_TIME;
	}
	
//    public Date getCREATION_TIME(){
//    	long millis = TimeUnit.MILLISECONDS.convert(CREATION_TIME, TimeUnit.NANOSECONDS);
//    	createDate = new Date(millis);
//        return this.createDate;
//    }

	public void setCREATION_TIME(long cREATION_TIME) {
		CREATION_TIME = cREATION_TIME;
	}

	public long getLAST_ACCESS_TIME() {
		return LAST_ACCESS_TIME;
	}

	public void setLAST_ACCESS_TIME(long lAST_ACCESS_TIME) {
		LAST_ACCESS_TIME = lAST_ACCESS_TIME;
	}

	public int getMAX_INACTIVE_INTERVAL() {
		return MAX_INACTIVE_INTERVAL;
	}


	public void setMAX_INACTIVE_INTERVAL(int mAX_INACTIVE_INTERVAL) {
		MAX_INACTIVE_INTERVAL = mAX_INACTIVE_INTERVAL;
	}

	public long getEXPIRY_TIME() {
		return EXPIRY_TIME;
	}

	public void setEXPIRY_TIME(long eXPIRY_TIME) {
		EXPIRY_TIME = eXPIRY_TIME;
	}

	public String getPRINCIPAL_NAME() {
		return PRINCIPAL_NAME;
	}

	public void setPRINCIPAL_NAME(String pRINCIPAL_NAME) {
		PRINCIPAL_NAME = pRINCIPAL_NAME;
	}
}

