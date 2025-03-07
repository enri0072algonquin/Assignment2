/**
 * Implementation of the Dao Interface for managing User entities.
 * 
 * @author Grant Wagner
 */
package main.dao;

import java.util.List;

import main.bean.User;

public class UserDao implements Dao<User> {

	//private static final String USERNAME; //username used to access MySQL database
	//private static final String PASSWORD; //password for MySQL database
	//private static final String CONN_STRING = "jdbc:mysql://localhost/[NAME OF DATABASE]"; //Connection string to Database
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

}
