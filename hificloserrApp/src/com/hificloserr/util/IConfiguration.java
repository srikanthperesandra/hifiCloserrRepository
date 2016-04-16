/**
 * 
 */
package com.hificloserr.util;

/**
 * @author spl
 *
 */
public interface IConfiguration {

	public static final String PLACES_API =LoadProperties.getInstance().getProperty().getProperty("placesApi");
	public static final String HOST =LoadProperties.getInstance().getProperty().getProperty("dbHost");
	public static final String PORT =LoadProperties.getInstance().getProperty().getProperty("dbPort");
	public static final String DB =LoadProperties.getInstance().getProperty().getProperty("db");
	public static final String GROUP_TOPIC =LoadProperties.getInstance().getProperty().getProperty("groupChatTopic");
	public static final String BROKER_URI =LoadProperties.getInstance().getProperty().getProperty("brokerUri");
	public static final Boolean CLEAN_SESSION =Boolean.parseBoolean(LoadProperties.getInstance().getProperty().getProperty("cleanSession"));
	public static final String QOS =LoadProperties.getInstance().getProperty().getProperty("qos");
	public static final String CLIENT_ID_SUB =LoadProperties.getInstance().getProperty().getProperty("clientIdPrefixSubscribe");
	
	
}
