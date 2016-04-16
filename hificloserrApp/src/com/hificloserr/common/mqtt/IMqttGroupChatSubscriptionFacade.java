/**
 * 
 */
package com.hificloserr.common.mqtt;

import java.sql.Timestamp;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import com.hificloserr.model.Message;
import com.hificloserr.services.entity.ChatRoomServiceFactory;
import com.hificloserr.util.IConfiguration;

/**
 * @author srikanth
 *
 */
public interface IMqttGroupChatSubscriptionFacade {

	public void start();
	public static IMqttGroupChatSubscriptionFacade eINSTANCE = new IMqttGroupChatSubscriptionFacade() {

		@Override
		public void start() {
			// TODO Auto-generated method stub
				MqttClient client=MQTTBrokerConnection.getInstance().getMqttClient();
				client.setCallback(new MqttCallback() {
					
					@Override
					public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("topic="+arg0);
						try{
						String groupId =arg0.substring(arg0.lastIndexOf("/")+1);
						String message = new String(arg1.getPayload());
						JSONObject object = new JSONObject(message);
						JSONObject chatPayload=object.getJSONObject("message");
						com.hificloserr.model.ChatHistory history = new com.hificloserr.model.ChatHistory();
						history.setGroupId(groupId);
						Message chatMessage = new Message();
						chatMessage.setFrom(chatPayload.getString("from"));
						chatMessage.setPayload(chatPayload.getString("payload"));
						chatMessage.setTimeStamp(new Timestamp(System.currentTimeMillis()).toString());
						history.setMessage(chatMessage);
						ChatRoomServiceFactory.getInstance().saveConnversation(history);
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}
					
					@Override
					public void deliveryComplete(IMqttDeliveryToken arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void connectionLost(Throwable arg0) {
						// TODO Auto-generated method stub
						System.out.println(arg0.getMessage());
					}
				});
				
				
				try {
					client.subscribe(IConfiguration.GROUP_TOPIC+"+",Integer.parseInt(IConfiguration.QOS));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	
	}; 
	
}
