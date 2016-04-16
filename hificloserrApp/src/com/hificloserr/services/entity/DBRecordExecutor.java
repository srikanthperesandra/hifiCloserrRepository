/**
 * 
 */
package com.hificloserr.services.entity;


import java.util.concurrent.Callable;
import java.util.logging.Logger;

import com.hificloserr.model.GroupChatRoom;
import com.hificloserr.util.IStatus;
import com.hificloserr.util.Status;
import com.mongodb.BasicDBObject;

/**
 * @author spl
 *
 */
public class DBRecordExecutor implements Callable<IStatus>{

	private Logger logger = Logger.getLogger(DBRecordExecutor.class.getName());
	private GroupChatRoom room;
	private IChatRoomService roomService;
	public DBRecordExecutor(GroupChatRoom room,IChatRoomService chatRoomService) {
		// TODO Auto-generated constructor stub
		
		this.room = room;
		this.roomService = chatRoomService;
	}
	
	@Override
	public IStatus call() throws Exception {
		// TODO Auto-generated method stub
		
		IStatus result = null;
		
		BasicDBObject foundObject = roomService.findRoom(room.getPlaceId());
		
		if(foundObject==null){
			roomService.addNewChatRoom(room);
			result =new Status(IStatus.OK,room.getPlaceId()+"is inserted", null);
			logger.info(result.getMessage().toString());
			return result;
		}else{
			result = new Status(IStatus.OK, room.getPlaceId()+"is found not inserted", null);
			logger.info(result.getMessage().toString());
			return result;
		}
	}
	
}
