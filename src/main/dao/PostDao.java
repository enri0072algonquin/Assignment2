/**
 * Implementation of the Dao Interface for managing Post entities from the MySQL database.
 * 
 * @author Grant Wagner
 */
package main.dao;

import java.util.List;

import main.bean.Post;

public class PostDao implements Dao<Post> {

	public PostDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Post t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Post t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Post t) {
		// TODO Auto-generated method stub
		
	}

}
