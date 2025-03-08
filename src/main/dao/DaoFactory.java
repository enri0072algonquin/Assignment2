/**
 * There should only a single instance of this class. This class manages all of the needed DAO classes.
 * Manages the main connection to the database.
 * 
 * @author Grant Wagner
 */
package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	
	private static final String USERNAME = "root";
    private static final String PASSWORD = "assign_2";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/explore_db";
    
    /**
     * Creates a connection to the MySQL database.
     * 
     * @return Connection to the MySQL database
     * @throws ClassNotFoundException 
     */
	public static Connection createConnection() throws ClassNotFoundException {
		//Connect to database
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //return connection
	    return conn;
	}
	
	/**
	 * Closes a connection to the database.
	 * 
	 * @param conn	Connection to the database
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates and returns a UserDao object to manage User entities from MySQL database.
	 * 
	 * @return	UserDao object that is used to manage User entities/objects from database
	 */
	public UserDao getUserDao() {
		//UserDao implements Dao
		return new UserDao();
	}

	/**
	 * Creates and returns a PostDao object to manage Post entities from MySQL database.
	 * 
	 * @return PostDao object that is used to manage Post Entities
	 */
	public PostDao getPostDao() {
		//PostDao implements Dao
		return new PostDao();
	}
	
	/**
	 * Creates and returns a CommentDao object to manage Comment entities from MySQL database.
	 * 
	 * @return CommentDao object that is used to manage Post Entities
	 */
	public CommentDao getCommentDao() {
		//CommentDao implements Dao
		return new CommentDao();
	}
	
}
