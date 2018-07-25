package com.hing.pojo;

import java.sql.Timestamp;

public class Item {
	private long TODO_ITEM_ID;//待办事项ID
	private String TODO_ITEM_TITLE;//待办事项标题
	private String TODO_ITEM_CONTENT;//内容
	private String PRIORITY;//待办事项优先级 LOW/MEDIUM/HIGH
	private Timestamp CREATION_DATE;//待办事项创建时间
	private Timestamp LAST_UPDATE_DATE;//待办事项最后修改时间
	private String COMMENTS;//待办事项备注
	private User user;//待办事项属主用户
	public long getTODO_ITEM_ID() {
		return TODO_ITEM_ID;
	}
	public void setTODO_ITEM_ID(long tODO_ITEM_ID) {
		TODO_ITEM_ID = tODO_ITEM_ID;
	}
	public String getTODO_ITEM_TITLE() {
		return TODO_ITEM_TITLE;
	}
	public void setTODO_ITEM_TITLE(String tODO_ITEM_TITLE) {
		TODO_ITEM_TITLE = tODO_ITEM_TITLE;
	}
	public String getTODO_ITEM_CONTENT() {
		return TODO_ITEM_CONTENT;
	}
	public void setTODO_ITEM_CONTENT(String tODO_ITEM_CONTENT) {
		TODO_ITEM_CONTENT = tODO_ITEM_CONTENT;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Item [TODO_ITEM_ID=" + TODO_ITEM_ID + ", TODO_ITEM_TITLE=" + TODO_ITEM_TITLE + ", TODO_ITEM_CONTENT="
				+ TODO_ITEM_CONTENT + ", PRIORITY=" + PRIORITY + ", CREATION_DATE=" + CREATION_DATE
				+ ", LAST_UPDATE_DATE=" + LAST_UPDATE_DATE + ", COMMENTS=" + COMMENTS + ", user=" + user + "]";
	}
	
}
