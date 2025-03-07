/** 
 * This is a Java Bean class that stores information related to user created comments
 * that correspond to a specific post.
 * 
 * @author Grant Wagner
 */

package main.bean;

public class Comment {

	/**
	 * Data Members
	 */
	
	private long commentID, userID, parentID;
	private String body;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getters
	 */
	
	public long getCommentID() {
		return commentID;
	}
	
	public long getUserID() {
		return userID;
	}
	
	public long getParentID() {
		return parentID;
	}
	
	public String getBody() {
		return body;
	}
	
	/**
	 * Setters
	 */
	
	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public void setParentID(long parentID) {
		this.parentID = parentID;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

}
