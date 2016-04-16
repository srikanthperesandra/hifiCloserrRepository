package com.hificloserr.model;

import com.mongodb.BasicDBObject;

public class ChatHistory extends BasicDBObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupId;
	private Message message;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
		put(CollectionSchema.ChatHistory.GROUPID,groupId);
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
		put(CollectionSchema.ChatHistory.MESSAGE,message);
	}
}
