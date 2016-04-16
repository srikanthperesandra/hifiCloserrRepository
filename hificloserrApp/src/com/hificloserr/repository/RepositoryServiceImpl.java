/**
 * 
 */
package com.hificloserr.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author spl
 *
 */
public class RepositoryServiceImpl implements IRepositoryService{

	private MongoClient mongoClient;
	private MongoDatabase mongoDataBase;
	private String db;
	private String host;
	private int port;
	
	public  RepositoryServiceImpl(String host,int port, String db) {
		// TODO Auto-generated constructor stub
		
		this.db = db;
		this.host = host;
		this.port = port;
	}
	@Override
	public synchronized MongoClient connect() {
		// TODO Auto-generated method stub
		mongoClient = new MongoClient(host,port);
		mongoDataBase = mongoClient.getDatabase(db);
		return mongoClient;
	}
	@Override
	public synchronized MongoDatabase getDBInstance() {
		// TODO Auto-generated method stub
		return mongoDataBase;
	}
	@Override
	public synchronized MongoCollection<BasicDBObject> getCollection(String name) {
		// TODO Auto-generated method stub
		return mongoDataBase.getCollection(name,BasicDBObject.class);
	}
	@Override
	public synchronized void disconnect() {
		// TODO Auto-generated method stub
		mongoClient.close();
	}
	
	
}
