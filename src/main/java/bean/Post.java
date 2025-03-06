/** 
 * This is a Java Bean class that stores information related to user created posts.
 * 
 * @author Grant Wagner
 */
package bean;


public class Post {
	
	/**
	 * Data Members
	 */
	private long postID, userID; 
	private String title, description, businessURL, mediaURL;
	private int clickCount;
	
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
