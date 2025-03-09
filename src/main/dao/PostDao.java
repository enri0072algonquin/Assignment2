/**
 * Implementation of the Dao Interface for managing Post entities from the MySQL database.
 * 
 * @author Grant Wagner
 */
package main.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.bean.Post;

public class PostDao implements Dao<Post> {

	/**
	 * Returns a list of all Posts in the database.
	 * 
	 * @return List<Post> 
	 */
	@Override
	public List<Post> getAll() {
		//Initialize Variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Post> posts = new ArrayList<>();
				
		//Create connection to database
		try {
			conn = DaoFactory.createConnection();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
				
		/**
		 * Try creating and executing a SQL statement to get a list of all Users.
		 */
		try {
			stmt = (Statement) conn.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM posts");
				
			//Check if the resulting set is not null before proceeding
			if (rs != null) {
				rs.beforeFirst(); //Index goes before first so that the while loop will work
					
				while (rs.next()) { //
				//Create a temporary Post object
				Post tmp = new Post();
						
				//Assign all of the User's attributes from the MySQL table
				tmp.setPostID(Long.parseLong(rs.getString("post_id")));
				tmp.setUserID(Long.parseLong(rs.getString("user_id")));
				tmp.setDescription(rs.getString("description"));
				tmp.setMediaURL(rs.getString("image_url"));
				
				//add the tmp Post to the posts ArrayList
				posts.add(tmp);
				}
			}
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
				
		//close connection
		DaoFactory.closeConnection(conn);
				
		//return posts list
		return posts;
	}

	@Override
	public Post get(long id) {
		//Initialize Variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
			    
		//Create new Post object
		Post tmp = new Post();
		tmp.setPostID(id);
				
		//Create connection to database
		try {
			conn = DaoFactory.createConnection();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
				
		/**
		 * Try creating and executing a SQL statement to get a specific post.
		 */
		try {
			stmt = (Statement) conn.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM posts WHERE post_id=" + id);
				
			//Check if the resulting set is not null before proceeding
			if (rs != null) {
				//Assign all of the User's attributes from the MySQL table
				tmp.setUserID(Long.parseLong(rs.getString("user_id")));
				tmp.setDescription(rs.getString("description"));
				tmp.setMediaURL(rs.getString("image_url"));
			}
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
				
		//close connection
		DaoFactory.closeConnection(conn);
				
		//return the specific user
		return tmp;
	}

	@Override
	public void update(Post t, String[] params) {
		//Set the passed User object's attributes with the passed params
		//params[0] = title
		//params[1] = description
		//params[2] = media url

		//Updates values where not null
		if (params[0] != null) {
			t.setTitle(params[0]);
		}
		if (params[1] != null) {
			t.setDescription(params[1]);
		}
		if (params[2] != null) {
			t.setMediaURL(params[2]);
		}
				
		//Initialize Connection Variables
		Connection conn = null;
		PreparedStatement ps = null;
						
		//Create connection to database
		try {
			conn = DaoFactory.createConnection();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
				
		try {
			//Write SQL query to Update a specific post by postID
			String query = "UPDATE posts SET title = ?, description = ?, image_url = ? WHERE post_id = ?";
			ps = conn.prepareStatement(query);
				
			//In query, replace "?" with specific values
			ps.setString(1, t.getTitle());
			ps.setString(2, t.getDescription());
			ps.setString(3, t.getMediaURL());
				
			ps.setLong(4, t.getPostID());
					
			//Execute Query and commit changes to database
			ps.executeUpdate();
			conn.commit();
					
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
				
		//close connection
		DaoFactory.closeConnection(conn);
	}

	@Override
	public void save(Post t) {
		//Initialize Connection Variables
		Connection conn = null;
		PreparedStatement ps = null;
								
		//Create connection to database using DaoFactory
		try {
			conn = DaoFactory.createConnection();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
						
		try {
			//Write SQL query to Insert the user into the Table
			String query = "INSERT INTO posts (post_id, user_id, title, description, image_url) VALUES (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setLong(1, t.getPostID());
			ps.setLong(2, t.getUserID());
			ps.setString(3, t.getTitle());
			ps.setString(4, t.getDescription());
			ps.setString(5, t.getMediaURL());
						
			//Execute Query and commit changes to database
			ps.executeUpdate();
			conn.commit(); 
							
			} catch (SQLException e) {
				System.err.println("SQLException occurred: " + e.getMessage());
			}
						
		//close connection
		DaoFactory.closeConnection(conn);		
	}

	@Override
	public void delete(Post t) {
		//Initialize Connection Variables
		Connection conn = null;
		PreparedStatement ps = null;
						
		//Create connection to database using DaoFactory
		try {
			conn = DaoFactory.createConnection();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
				
		try {
			//Write SQL query to delete a specific post by postID
			String query = "DELETE FROM posts WHERE post_id = ?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, t.getPostID());
					
			//Execute Query and commit the update to the database.
			ps.executeUpdate();
			conn.commit(); 
					
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
				
		//close connection
		DaoFactory.closeConnection(conn);
	}
}
