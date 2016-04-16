/**
 * 
 */
package com.t3heag.hificloserr.realms;

import java.security.Principal;

import org.apache.catalina.realm.DataSourceRealm;
import org.apache.catalina.realm.GenericPrincipal;

import com.t3heag.hificloserr.realm.dbauth.DBAuthFactory;
import com.t3heag.hificloserr.realm.dbauth.DBUser;
import com.t3heag.hificloserr.realm.dbauth.IDBAuthentication;

/**
 * @author spl
 *
 */
public class MongoRealm extends DataSourceRealm {

	private DBUser user;
	
	
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return MongoRealm.class.getName();
	}

	

	@Override
	protected synchronized Principal getPrincipal(String username) {
		// TODO Auto-generated method stub
		System.out.println("Realm ="+MongoRealm.class.getName());
		if(user!=null)
			return new GenericPrincipal(user.getUsername(),user.getPassword(),user.getRoles());
		else
			return null;
	}



	@Override
	public Principal authenticate(String username, String credentials) {
		// TODO Auto-generated method stub
		System.out.println("reached here "+getObjectName().getKeyProperty("userCredCol")+username);
		user = fetchUser(username);
		System.out.println(user.getRoles().toString());
		if(user!=null){
			if(credentials.equals(user.getPassword())){
				return new GenericPrincipal(username,credentials, user.getRoles());
			}else
				return null;
		}
		
		return null;
	}

	
	private DBUser fetchUser (String username){
		IDBAuthentication auth=DBAuthFactory.createInstance(IDBAuthentication.MONGO_INSTANCE);
		
		auth.setDbURL(super.getDataSourceName());
		auth.setDbPassword(super.getUserCredCol());
		auth.setDbUser(super.getUserNameCol());
		auth.setUsersCollection(super.getUserTable());
		DBUser user=auth.findUser(username);
		return user;
	}
	

}
