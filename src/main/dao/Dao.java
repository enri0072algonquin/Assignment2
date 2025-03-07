/**
 * Generic interface for all Data Access Objects. All CRUD operations are taken into account
 * for objects of type T.
 * 
 * @author Grant Wagner
 */

package main.dao;

import java.util.List;

public interface Dao<T> {
	
	public List<T> getAll();
	
	public T get(long id);
	
	public void update(T t, String[] params);
	
	public void save(T t);
	
	public void delete(T t);
}
