package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.nhanVien;

public class nhanVienDAO implements DAOinterface<nhanVien>{
	
	private Connection c = null;
	
	public nhanVien[] duyetNV(){
		int sonv = 0;
		nhanVien nv[] = null;
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM nhanvien");
			
			while (result.next()) {
				String tam = result.getString("tenNhanVien");
				sonv++;
			}
			ResultSet resul = st.executeQuery("SELECT * FROM nhanvien");
			nv = new nhanVien[sonv];
			int i = 0;
			while (resul.next()) {
				nv[i] = new nhanVien();
				sonv--;
				int manv = resul.getInt("maNV");
				String tennv = resul.getString("tenNhanVien");
				nv[i].setHoVaTen(tennv);
				nv[i].setMaNV(manv);
				i++;
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return nv;
	}
	
	public String nvTrongCa() {
		String tennv = "";
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM xuatchieuhientai");

			while (result.next()) {
				tennv = result.getString("tenNhanVien");
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tennv;
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
