package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.nhanVien;

public class nhanVienDAO implements DAOinterface<nhanVien>{

	public int duyetNV(){
		Connection c = null;
		int sonv = 1;
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM nhanvien");
			
			while (result.next()) {
				String tam = result.getString("hoVaTen");
				sonv++;
			}
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
	
	@Override
	public int insert(nhanVien t) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<nhanVien> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public nhanVien selectById(nhanVien t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<nhanVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updateAll(nhanVien t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
