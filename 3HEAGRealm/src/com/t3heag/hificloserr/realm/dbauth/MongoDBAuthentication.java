/**
 * 
 */
package com.t3heag.hificloserr.realm.dbauth;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author spl
 *
 */
public class MongoDBAuthentication implements IDBAuthentication{

	
	private String usersCollection;
	private String dbUser;
	private String dbPassword;
	private String dbURL;
	
	public String getUsersCollection() {
		return usersCollection;
	}

	public void setUsersCollection(String usersCollection) {
		this.usersCollection = usersCollection;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public DBUser findUser(String username) {
		// TODO Auto-generated method stub
		
		String uri = getDbURL();
		String uriHostPort = uri.substring(uri.indexOf("//")+2,uri.lastIndexOf("/"));
		String host = uriHostPort.split(":")[0];
		String port = uriHostPort.split(":")[1];
		
		
		MongoClient client = new MongoClient(host, Integer.parseInt(port));
		MongoDatabase db = client.getDatabase(uri.substring(uri.lastIndexOf("/")+1));
		MongoCollection<org.bson.Document> collection=db.getCollection(usersCollection);
		Object object=collection.find(new org.bson.Document("username", username)).first();
		try{
			if(object!=null){
				DBUser user = new DBUser();
				Document dbObject = (Document)object;
				user.setUsername((String)dbObject.get("username"));
				user.setPassword((String)dbObject.get("password"));
				String csvRoles=(String)dbObject.get("roles");
				user.setRoles(new ArrayList<String>(Arrays.asList(csvRoles.split(","))));
				return user;
			}else 
				return null;
		}finally{
			client.close();
		}
	}

	
}
