package com.hificloserr.common.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.hificloserr.services.entity.DBRecordExecutor;

public class FutureTaskHandler {


	private List<TaskCallBack> scheduledTasks = new ArrayList<TaskCallBack>();
	private ExecutorService service; 
	public FutureTaskHandler(){
		service=ThreadPoolManager.getFixedThreadPool();
	}
	
	
	public void submiTask(ICallBack callBack,DBRecordExecutor rec) throws InstantiationException, IllegalAccessException{
		
		scheduledTasks.add(new TaskCallBack(callBack, service.submit(rec)));
	}
	public void processTasks(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for(int i=0;i<scheduledTasks.size();i++){
					try{
					
						TaskCallBack taskCallBack = scheduledTasks.get(i);
						
					
							taskCallBack.getCallBack().handleMessage(taskCallBack.getTask().get());
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
				scheduledTasks.clear();
			}
		}).start();
	}
}
