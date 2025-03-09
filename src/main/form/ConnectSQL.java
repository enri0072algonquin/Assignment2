/**
 * This class facilitates connecting to MySQL database.
 * 
 * @author Emilybeth Enriquez
 */
package main.form;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//emilybeth connection to sql
public class ConnectSQL {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "assign_2";
    private static final String CONN_STRING = "jdbc:mysql://127.0.0.1:3306/explore_db";

    public static void main(String[] args) {
      Connection conn =null;
      Statement stmt= null;
      ResultSet rs= null;
    	
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            
            try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD)) {
              stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              rs= stmt.executeQuery("SELECT* FROM users");
            	
              rs.last();
              System.out.println("Number of rows"+rs.getRow());
            	System.out.println("Logged in!");
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
    //testing again 
}
