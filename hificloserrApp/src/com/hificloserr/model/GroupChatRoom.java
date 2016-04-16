/**
 * 
 */
package com.hificloserr.model;

import com.mongodb.BasicDBObject;

/**
 * @author spl
 *
 */
public class GroupChatRoom extends BasicDBObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String placeId;
	private double lat;
	private double lng;
	private String vicinity;
	private String topic;
	private String roomType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		put(CollectionSchema.GroupChatRoom.NAME, this.name);
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
		put(CollectionSchema.GroupChatRoom.ID, this.placeId);
	}
	public double getLat() {
		return lat;
		
	}
	public void setLat(double lat) {
		this.lat = lat;
		put(CollectionSchema.GroupChatRoom.LAT, this.lat);
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
		put(CollectionSchema.GroupChatRoom.LNG, this.lng);
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
		put(CollectionSchema.GroupChatRoom.VICINITY, this.vicinity);
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
		put(CollectionSchema.GroupChatRoom.TOPIC, this.topic);
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
		put(CollectionSchema.GroupChatRoom.ROOM_TYPE, this.roomType);
	}
	
	

}
