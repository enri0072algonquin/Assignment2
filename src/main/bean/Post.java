/** 
 * This is a Java Bean class that stores information related to user created posts.
 * 
 * @author Grant Wagner
 */
package main.bean;


public class Post {
	
	/**
	 * Data Members
	 */
	private long postID;			//Unique ID to Post
	private long userID; 			//Unique ID of User who created the Post
	private String title;			//A text String that should describe the post at a glance
	private String description;		//A block of text that gives greater context to the Post
	private String businessURL;		//An external, related business link
	private String mediaURL;		//A link to the featured picture or video media
	private int clickCount;			//A total count of how many times the Post has been clicked by Users
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter Functions
	 */
	
	public long getPostID() {
		return postID;
	}
	
	public long getUserID() {
		return userID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getBusinessURL() {
		return businessURL;
	}
	
	public String getMediaURL() {
		return mediaURL;
	}
	
	public int getClickCount() {
		return clickCount;
	}
	
	
	/**
	 * Setter Functions
	 */
	
	public void setPostID(long postID) {
		this.postID = postID;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setBusinessURL(String businessURL) {
		this.businessURL = businessURL;
	}
	
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
}
