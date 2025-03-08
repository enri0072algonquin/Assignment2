/**
 * Implementation of the Dao Interface for managing User entities.
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

import main.bean.User;

public class UserDao implements Dao<User> {

	@Override
	/**
	 * Returns a list of all Users in the database.
	 * 
	 * @return List<Users> 
	 */
	public List<User> getAll() {
		//Initialize Variables
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    List<User> users = new ArrayList<>();
		
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
			stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM USERS");
			
			//Check if the resulting set is not null before proceeding
			if (rs != null) {
				rs.beforeFirst(); //Index goes before first so that the while loop will work
				
				while (rs.next()) { //
					//Create a temporary User object
					User tmp = new User();
					
					//Assign all of the User's attributes from the MySQL table
					tmp.setUserID(Long.parseLong(rs.getString("userid")));
					tmp.setUsername(rs.getString("username"));
					tmp.setEmail(rs.getString("email"));
					tmp.setBusinessURL(rs.getString("businessurl"));
					tmp.setPfpURL(rs.getString("businessurl"));
					
					//add the tmp User to the users ArrayList
					users.add(tmp);
				}
			}
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
		
		//close connection
		DaoFactory.closeConnection(conn);
		
		//return users list
		return users;
	}

	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Updates the information in a User object. Then updates the MySQL database using the new information.
	 * 
	 * @param	t		a user whose information is being updated.
	 * @param	params	the information that is used to update specific attributes.
	 */
	public void update(User t, String[] params) {
		//Set the passed User object's attributes with the passed params
		//params[0] = username
		//params[1] = email
		//params[2] = businessURL
		//params[3] = pfpPicture

		t.setUsername(params[0]);
		t.setEmail(params[1]);
		t.setBusinessURL(params[2]);
		t.setPfpURL(params[3]);
		
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
			//Write SQL query to Update a specific user by userID
			String query = "UPDATE users SET username = ?, email = ?, businessurl = ?, pfpurl = ? WHERE userid = ?";
			ps = conn.prepareStatement(query);
			
			//In query, replace "?" with specific values
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getEmail());
			ps.setString(3, t.getBusinessURL());
			ps.setString(4, t.getPfpURL());
			
			ps.setLong(5, t.getUserID());
			
			ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
		
		//close connection
		DaoFactory.closeConnection(conn);
	}

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
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
			//Write SQL query to Update a specific user by userID
			String query = "DELETE FROM users WHERE userid = ?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, t.getUserID());
			
			ps.executeUpdate();
			conn.commit(); 
			
		} catch (SQLException e) {
			System.err.println("SQLException occurred: " + e.getMessage());
		}
		
		//close connection
		DaoFactory.closeConnection(conn);
	}

}
