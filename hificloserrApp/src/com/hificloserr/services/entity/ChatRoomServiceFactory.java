/**
 * 
 */
package com.hificloserr.services.entity;

/**
 * @author spl
 *
 */
public abstract class ChatRoomServiceFactory {

	public static IChatRoomService getInstance(){
		return new ChatRoomServiceImpl();
	}
}
