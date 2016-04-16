/**
 * 
 */
package com.t3heag.hificloserr.realm.dbauth;

/**
 * @author spl
 *
 */
public class DBAuthentication implements IDBAuthentication {

	/* (non-Javadoc)
	 * @see com.t3heag.hificloserr.realm.IDBAuthentication#findUser()
	 */
	
	
	private IDBAuthentication authentication;
	
	public DBAuthentication(String type){
		
		if(MONGO_INSTANCE.equals(type))
			authentication = new MongoDBAuthentication();
		else if(COUCH_DB.equals(type))
			authentication = new CouchDBAuthentication();
		else{
			
		}
	}
	
	public DBUser findUser(String username) {
		// TODO Auto-generated method stub
		return authentication.findUser(username);
	}

	
	public String getUsersCollection() {
		return authentication.getUsersCollection();
	}

	public void setUsersCollection(String usersCollection) {
		authentication.setUsersCollection(usersCollection);
	}

	public String getDbUser() {
		return authentication.getDbUser();
	}

	public void setDbUser(String dbUser) {
		authentication.setDbUser(dbUser);
	}

	public String getDbPassword() {
		return authentication.getDbPassword();
	}

	public void setDbPassword(String dbPassword) {
		authentication.setDbPassword(dbPassword);
	}

	public String getDbURL() {
		return authentication.getDbURL();
	}

	public void setDbURL(String dbURL) {
		authentication.setDbURL(dbURL);
	}
}
