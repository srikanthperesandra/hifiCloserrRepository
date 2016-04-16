/**
 * 
 */
package com.t3heag.hificloserr.realm.dbauth;

import java.util.List;

/**
 * @author spl
 *
 */
public class DBUser {

	private String username;
	private String password;
	private List<String> roles;
	
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
