/**
 * Implementation of the Dao Interface for managing User entities.
 * 
 * @author Grant Wagner
 */
package main.dao;

import java.util.List;

import main.bean.User;

public class UserDao implements Dao<User> {
	
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
	/**
	 * Updates a specific user's information.
	 * 
	 * @param	t		a user whose information is being updated.
	 * @param	params	the information that is used to update specific attributes.
	 */
	public void update(User t, String[] params) {
		t.setUserID(Long.parseLong(params[0]));
		t.setUsername(params[1]);
		t.setEmail(params[2]);
		t.setBusinessURL(params[3]);
		t.setPfpURL(params[4]);
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
