package dao;

import java.util.ArrayList;

public interface DAOinterface<T> {
	
	public int insert(T t);
	
	public int updateAll(T t);
	
	public int deleteAll();
	
	public ArrayList<T> selectAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
}
