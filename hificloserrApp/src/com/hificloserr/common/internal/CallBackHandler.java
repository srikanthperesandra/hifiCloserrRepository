package com.hificloserr.common.internal;

import java.util.logging.Logger;

import com.hificloserr.util.IStatus;

public class CallBackHandler implements ICallBack{

	private static Logger log = Logger.getLogger(CallBackHandler.class.getName());
	public void handleMessage(Object o){
		//System.out.println(o);
		if(o instanceof IStatus){
			IStatus result = (IStatus)o;
			//System.out.println("reached callback");
			if(result.isOk())
				log.info(result.getMessage().toString());
			else
				log.severe(result.getMessage().toString());
		}
			
	}
}
