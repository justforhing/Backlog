package com.hing.pojo;

import java.sql.Timestamp;

public class User {
	private long USER_ID;//用户id
	private String USER_NAME;//用户名
	private String PASSWORD;//用户密码
	private String SEX;//用户性别 F/M
	private long AGE;//用户年龄 1-200
	private String PHONE_NUMBER;//用户电话号码
	private Timestamp CREATION_DATE;//创建用户日期 	
	private Timestamp LAST_UPDATE_DATE;//最后更新信息的日期
	private String COMMENTS;//备注
	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", PASSWORD=" + PASSWORD + ", SEX=" + SEX
				+ ", AGE=" + AGE + ", PHONE_NUMBER=" + PHONE_NUMBER + ", CREATION_DATE=" + CREATION_DATE
				+ ", LAST_UPDATE_DATE=" + LAST_UPDATE_DATE + ", COMMENTS=" + COMMENTS + "]";
	}
	public long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public long getAGE() {
		return AGE;
	}
	public void setAGE(long aGE) {
		AGE = aGE;
	}
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}
	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}
	public Timestamp getCREATION_DATE() {
		return CREATION_DATE;
	}
	public void setCREATION_DATE(Timestamp cREATION_DATE) {
		CREATION_DATE = cREATION_DATE;
	}
	public Timestamp getLAST_UPDATE_DATE() {
		return LAST_UPDATE_DATE;
	}
	public void setLAST_UPDATE_DATE(Timestamp lAST_UPDATE_DATE) {
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}
	public String getCOMMENTS() {
		return COMMENTS;
	}
	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}
	
}
