/**
 * 
 */
package com.hificloserr.services.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hificloserr.common.internal.CallBackHandler;
import com.hificloserr.common.internal.FutureTaskHandler;
import com.hificloserr.model.GroupChatRoom;
import com.hificloserr.util.IConfiguration;


/**
 * @author spl
 *
 */
public interface IChatRoomsFacade {

	public JSONArray start(double lat,double lng, int area);
	public static IChatRoomsFacade eINSTANCE= new IChatRoomsFacade() {
		
		@Override
		public JSONArray start(double lat, double lng,int area) {
			// TODO Auto-generated method stub
			
			IChatRoomService roomService=ChatRoomServiceFactory.getInstance();
			
			JSONArray result = new JSONArray();
			FutureTaskHandler handler = new FutureTaskHandler();
			try {
				JSONObject placesResult=new JSONObject((String)roomService.getChatRoomsAroundArea(lat, lng, area).getMessage());
				JSONArray arrayResults=placesResult.getJSONArray("results");
				//System.out.println(arrayResults.toString());
				//ExecutorService service = ThreadPoolManager.getFixedThreadPool();
				
				for(int i=0;i<arrayResults.length();i++){
					
					GroupChatRoom room = new GroupChatRoom();
					JSONObject place=arrayResults.getJSONObject(i);
					JSONObject location = place.getJSONObject("geometry").getJSONObject("location");
					room.setLat(location.getDouble("lat"));
					room.setLng(location.getDouble("lng"));
					room.setName(place.getString("name"));
					room.setPlaceId(place.getString("place_id"));
					room.setVicinity(place.getString("vicinity"));
					room.setTopic(IConfiguration.GROUP_TOPIC+place.getString("place_id"));
					room.setRoomType(place.getJSONArray("types").getString(0));
					handler.submiTask(new CallBackHandler(), new DBRecordExecutor(room,roomService));
					//handler.handleTask();
					//task.run();
					//System.out.println(room.toString());
					result.put(new JSONObject(room.toString()));
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			handler.processTasks();
			System.out.println("reached here first");
			return result;
		}
	};
}
