/**
 * 
 */
package com.hificloserr.model;

/**
 * @author spl
 *
 */
public class CollectionSchema {

	public static class GroupChatRoom{
		public static String COLLECTION_NAME="chatGroups";
		public static String NAME ="name";
		public static String ID ="placeId";
		public static String LAT ="lat";
		public static String LNG ="lng";
		public static String VICINITY ="vicinity";
		public static String TOPIC ="topic";
		public static String ROOM_TYPE="roomType";
	}
	public static class ChatHistory{
		public static String COLLECTION_NAME="chatHistory";
		public static String GROUPID="groupId";
		public static String MESSAGE="message";
		
	}
}