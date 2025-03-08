/** 
 * This is a Java Bean class that stores user information.
 * 
 * @author Grant Wagner
 */
 
package main.bean;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Data Members
	 */
	private long userID; 			//ID unique to the User
	private String username;		//username unique to the User
	private String email;			//email unique to the user if we use it as sign in info
	private String businessURL;		//External business link
	private String pfpURL;			//Link to the User's profile picture
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getters
	 */
	public long getUserID() {
		return userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getBusinessURL() {
		return businessURL;
	}
	
	public String getPfpURL() {
		return pfpURL;
	}
	
	/**
	 * Setters
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBusinessURL(String businessURL) {
		this.businessURL = businessURL;
	}
	
	public void setPfpURL(String pfpURL) {
		this.pfpURL = pfpURL;
	}
}
