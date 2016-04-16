package com.hificloserr.common.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolManager {

	private static ThreadPoolManager poolManager;
	private ExecutorService service;
	private ThreadPoolManager(){
		
	}
	
	public static ExecutorService getFixedThreadPool(){
		if(poolManager==null){
			int cores = Runtime.getRuntime().availableProcessors();
			poolManager = new ThreadPoolManager();
			poolManager.service = Executors.newFixedThreadPool(cores-2);
		}
		return poolManager.service;
	}
}
