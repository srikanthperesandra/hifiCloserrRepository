/**
 * 
 */
package com.hificloserr.services.entity;

import com.hificloserr.model.ChatHistory;
import com.hificloserr.model.CollectionSchema;
import com.hificloserr.model.GroupChatRoom;
import com.hificloserr.repository.IRepositoryService;
import com.hificloserr.repository.RepositoryConnectionFactory;
import com.hificloserr.util.APIReader;
import com.hificloserr.util.IConfiguration;
import com.hificloserr.util.IStatus;
import com.hificloserr.util.LoggerUtil;
import com.hificloserr.util.Status;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

/**
 * @author spl
 *
 */
public class ChatRoomServiceImpl implements IChatRoomService{

	@Override
	public IStatus addNewChatRoom(GroupChatRoom room) {
		// TODO Auto-generated method stub
		try{
			IRepositoryService repository=RepositoryConnectionFactory.getInstance(IConfiguration.HOST, Integer.parseInt(IConfiguration.PORT), IConfiguration.DB);
			//repository.connect();
			MongoCollection<BasicDBObject> collection=repository.getCollection(CollectionSchema.GroupChatRoom.COLLECTION_NAME);
			collection.insertOne(room);
			//repository.disconnect();
			return new Status(IStatus.OK, "successfully Added "+room.getPlaceId(), null);
		}catch(Exception e){
			e.printStackTrace();
			return new Status(IStatus.ERROR, LoggerUtil.toString(e), e);
		}
		
	}

	@Override
	public IStatus getChatRoomsAroundArea(double lat, double lng, int area) {
		// TODO Auto-generated method stub
		
		try{
			String placesApi=IConfiguration.PLACES_API;
			String URL =String.format(placesApi, lat,lng,area);
			System.out.println(URL);
			IStatus result=APIReader.invokeService(URL, "GET", null, null, null, null);
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
			return new Status(IStatus.ERROR, LoggerUtil.toString(e), e);
		}
	}

	@Override
	public BasicDBObject findRoom(String placeId) {
		// TODO Auto-generated method stub
		
		IRepositoryService repository=RepositoryConnectionFactory.getInstance(IConfiguration.HOST, Integer.parseInt(IConfiguration.PORT), IConfiguration.DB);
		//repository.connect();
		MongoCollection<BasicDBObject> collection=repository.getCollection(CollectionSchema.GroupChatRoom.COLLECTION_NAME);
		//repository.disconnect();
		BasicDBObject obj=collection.find(new BasicDBObject(CollectionSchema.GroupChatRoom.ID, placeId)).first();
		return obj;
		
	}

	@Override
	public void saveConnversation(ChatHistory history) {
		// TODO Auto-generated method stub

		IRepositoryService repository=RepositoryConnectionFactory.getInstance(IConfiguration.HOST, Integer.parseInt(IConfiguration.PORT), IConfiguration.DB);
		//repository.connect();
		MongoCollection<BasicDBObject> collection=repository.getCollection(CollectionSchema.ChatHistory.COLLECTION_NAME);
		collection.insertOne(history);
		
		
	}

	
}
