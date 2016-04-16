package com.hificloserr.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.hificloserr.util.LoggerUtil;
/**
 * @author srikanth
 */
public class LoadProperties {

	private Properties properties = new Properties();
	private static LoadProperties loadProps;
	private Logger log = Logger.getLogger(LoadProperties.class.getName());
	private LoadProperties(){
		
	}
	
	public static LoadProperties getInstance(){
		if(loadProps == null){
			loadProps = new LoadProperties();
			loadProps.load();
		}
		return loadProps;
	}
	
	private void load() {
		try{
			InputStream in = LoadProperties.class.getClassLoader().getResourceAsStream(System.getProperty("config", "conf.properties"));
			properties.load(in);
		}catch(IOException e){
			log.severe(LoggerUtil.toString(e));
		}
	}
	
	public Properties getProperty(){
		return properties;
	}
}