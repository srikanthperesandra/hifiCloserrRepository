package com.hificloserr.common.mqtt;

import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

import com.hificloserr.util.IConfiguration;
import com.hificloserr.util.LoggerUtil;

public class MQTTBrokerConnection {

	private static MQTTBrokerConnection connection;
	private static Logger logger = Logger.getLogger(MQTTBrokerConnection.class.getName());
	private MqttClient mqttClient;
	private MQTTBrokerConnection(){
		
	}
	
	public static synchronized MQTTBrokerConnection getInstance(){
		if(connection==null){
			connection = new MQTTBrokerConnection();
			try{
				connection.mqttClient = new MqttClient(IConfiguration.BROKER_URI, IConfiguration.CLIENT_ID_SUB+Thread.currentThread().getId());
				MqttConnectOptions options = new MqttConnectOptions();
				options.setCleanSession(IConfiguration.CLEAN_SESSION);
				connection.mqttClient.connect(options);
			}catch(Exception e){
				e.printStackTrace();
				logger.severe(LoggerUtil.toString(e));
			}
			
			
		}
		return connection;
	}
	
	public synchronized MqttClient getMqttClient(){
		return mqttClient;
	}
	
	
}
