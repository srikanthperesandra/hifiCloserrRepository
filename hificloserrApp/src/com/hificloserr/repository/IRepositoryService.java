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
public interface IRepositoryService {

	public MongoClient connect();
	public MongoDatabase getDBInstance();
	public MongoCollection<BasicDBObject> getCollection(String name);
	public void disconnect();
}
