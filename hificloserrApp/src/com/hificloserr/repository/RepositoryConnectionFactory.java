/**
 * 
 */
package com.hificloserr.repository;

/**
 * @author spl
 *
 */
public class RepositoryConnectionFactory {

	private static RepositoryConnectionFactory instance;
	private IRepositoryService repositoryService;
	private RepositoryConnectionFactory(){
		
	}
	public static synchronized IRepositoryService getInstance(String host,int port,String db){
		if(instance==null){
			instance=new RepositoryConnectionFactory();
			instance.repositoryService = new RepositoryServiceImpl(host, port, db);
			instance.repositoryService.connect();
		}
		
		return instance.repositoryService;
	}
	
}
