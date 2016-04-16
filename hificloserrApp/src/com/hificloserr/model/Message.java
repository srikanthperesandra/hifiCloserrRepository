package com.hificloserr.model;

import com.mongodb.BasicDBObject;

public class Message extends BasicDBObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String from;
	private String payload;
	private String timeStamp;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
		put("from", from);
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
		put("payload", payload);
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
		put("timestamp", timeStamp);
	}
}
