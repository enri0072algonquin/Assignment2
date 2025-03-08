/**
 * Implementation of the Dao Interface for managing Comment entities from MySQL database.
 * 
 * @author Grant Wagner
 */
package main.dao;

import java.util.List;

import main.bean.Comment;

public class CommentDao implements Dao<Comment> {

	public CommentDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Comment t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Comment t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Comment t) {
		// TODO Auto-generated method stub
		
	}

}
