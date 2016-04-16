/**
 * 
 */
package com.t3heag.hificloserr.realm.dbauth;

/**
 * @author spl
 *
 */
public abstract class DBAuthFactory {

	
	public static IDBAuthentication createInstance(String type){
		return new DBAuthentication(type);
	}
}
