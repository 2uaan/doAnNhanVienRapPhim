package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.gheNS;

public class gheNSDAO implements DAOinterface<gheNS>{
	
	@Override
	public int insert(gheNS t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(gheNS t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		
		int kq = 0;
		
		try {
			
			Connection c = jdbc_new.getConnection();
			
			Statement st = c.createStatement();
			
			String sql = "DELETE FROM ghens";
			
			kq = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}

	@Override
	public ArrayList<gheNS> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public gheNS selectById(gheNS t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<gheNS> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAll(gheNS t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
