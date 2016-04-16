/**
 * 
 */
package com.t3heag.hificloserr.realm.dbauth;

/**
 * @author spl
 *
 */
public interface IDBAuthentication {

	public static String MONGO_INSTANCE = "mongoDB";
	public static String COUCH_DB = "couchDB";
	
	public DBUser findUser(String username);
	public String getUsersCollection() ;

	public void setUsersCollection(String usersCollection);

	public String getDbUser() ;

	public void setDbUser(String dbUser);

	public String getDbPassword() ;

	public void setDbPassword(String dbPassword);

	public String getDbURL();

	public void setDbURL(String dbURL);
}
