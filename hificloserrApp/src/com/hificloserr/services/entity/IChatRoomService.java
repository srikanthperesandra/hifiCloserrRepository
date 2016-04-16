/**
 * 
 */
package com.hificloserr.services.entity;

import com.hificloserr.model.ChatHistory;
import com.hificloserr.model.GroupChatRoom;
import com.hificloserr.util.IStatus;
import com.mongodb.BasicDBObject;

/**
 * @author spl
 *
 */
public interface IChatRoomService {

	public IStatus addNewChatRoom(GroupChatRoom room);
	public IStatus getChatRoomsAroundArea(double lat,double lng, int area);
	public BasicDBObject findRoom(String placeId);
	public void saveConnversation(ChatHistory history);
}
