package com.hificloserr.common.internal;

import java.util.concurrent.Future;

import com.hificloserr.util.IStatus;

public class TaskCallBack {

	private ICallBack callBack;
	private Future<IStatus> task;
	
	
	public TaskCallBack(ICallBack call,Future<IStatus> task){
		callBack = call;
		this.task = task;
	}
	public ICallBack getCallBack() {
		return callBack;
	}
	public void setCallBack(ICallBack callBack) {
		this.callBack = callBack;
	}
	public Future<?> getTask() {
		return task;
	}
	public void setTask(Future<IStatus> task) {
		this.task = task;
	}
	
}
