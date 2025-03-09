/**
 * Implementation of the Dao Interface for managing Comment entities from MySQL database.
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

import main.bean.Comment;

public class CommentDao implements Dao<Comment> {

	@Override
	public List<Comment> getAll() {
		//Initialize Variables
				Connection conn = null;
			    Statement stmt = null;
			    ResultSet rs = null;
			    List<Comment> comments = new ArrayList<>();
				
				//Create connection to database
				try {
					conn = DaoFactory.createConnection();
				} catch (ClassNotFoundException e) {
					System.err.println("ClassNotFoundException occurred: " + e.getMessage());
				}
				
				/**
				 * Try creating and executing a SQL statement to get a list of all Comments.
				 */
				try {
					stmt = (Statement) conn.createStatement();
					rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM comments");
					
					//Check if the resulting set is not null before proceeding
					if (rs != null) {
						rs.beforeFirst(); //Index goes before first so that the while loop will work
						
						while (rs.next()) { //
							//Create a temporary Comment object
							Comment tmp = new Comment();
							
							//Assign all of the Comment's attributes from the MySQL table
							tmp.setUserID(Long.parseLong(rs.getString("user_id")));
							tmp.setCommentID(Long.parseLong(rs.getString("comment_id")));
							//tmp.setParentID(Long.parseLong(rs.getString("parent_id"))); //Not yet implemented in database
							tmp.setBody(rs.getString("body"));
							
							
							//add the tmp Comment to the comments ArrayList
							comments.add(tmp);
						}
					}
				} catch (SQLException e) {
					System.err.println("SQLException occurred: " + e.getMessage());
				}
				
				//close connection
				DaoFactory.closeConnection(conn);
				
				//return users list
				return comments;
	}

	@Override
	public Comment get(long id) {
		//Initialize Variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
			    
		//Create new User object
		Comment tmp = new Comment();
		tmp.setCommentID(id);
				
		//Create connection to database
		try {
			conn = DaoFactory.createConnection();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException occurred: " + e.getMessage());
		}
				
		/**
		 * Try creating and executing a SQL statement to a specific user.
		 */
		try {
			stmt = (Statement) conn.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM comments WHERE comment_id=" + id);
					
			//Check if the resulting set is not null before proceeding
			if (rs != null) {
				//Assign all of the User's attributes from the MySQL table
				tmp.setUserID(rs.getLong("user_id"));
				//tmp.setParentID(rs.getLong("user_id"));//Not yet implemented in database
				tmp.setBody(rs.getString("body"));
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
	public void update(Comment t, String[] params) {
		//Set the passed User object's attributes with the passed params
		
		//Updates value where not null
		if (params[0] != null) {
			t.setBody(params[0]);
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
			//Write SQL query to Update a specific Comment by commentID
			String query = "UPDATE comments SET body = ? WHERE comment_id = ?";
			ps = conn.prepareStatement(query);
					
			//In query, replace "?" with specific value
			ps.setString(1, t.getBody());
			
			ps.setLong(2, t.getUserID());
					
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
	public void save(Comment t) {
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
			//Write SQL query to Insert the comment into the Table
			String query = "INSERT INTO comments (comment_id, user_id, post_id, body) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setLong(1, t.getCommentID());
			ps.setLong(2, t.getUserID());
			ps.setLong(3, t.getPostID());
			ps.setString(4, t.getBody());
						
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
	public void delete(Comment t) {
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
			//Write SQL query to Delete a specific comment by commentID
			String query = "DELETE FROM comments WHERE comment_id = ?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, t.getCommentID());
					
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
