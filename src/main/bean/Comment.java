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
	
	private long commentID;			//A unique ID for the Comment
	private long userID;			//The ID for the User who wrote the Comment
	private long parentID;			//For replies, the ID of the parent Comment
	private String body;			//The Comment's text
	
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
