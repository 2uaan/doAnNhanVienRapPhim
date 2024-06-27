package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.nhanVien;
import model.xuatChieu;

public class xuatChieuDAO implements DAOinterface<xuatChieu>{
	
	private Connection c = null;
	
	
	public String[] duyetTenPhim() {
		String[] tenP = new String[3]; 
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM xuatchieuhientai");
			int i = 0;
			while (result.next()) {
				tenP[i] = result.getString("tenPhim");
				i++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tenP;
	}
	
	public String catS(String str) {
		String st = "";
		for (int i = 0; i<5; i++) {
			st += str.charAt(i);
		}
		
		return st;
	}
	
	public String[] duyetGioChieu() {
		String[] gioC = new String[3]; 
		String sta = "", end = "";
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM xuatchieuhientai");
			int i = 0;
			while (result.next()) {
				sta = catS(result.getString("gioBatDau"));
				end = catS(result.getString("gioKetThuc"));
				gioC[i] = sta +" - "+ end;
				i++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return gioC;
	}
	
	
	@Override
	public int insert(xuatChieu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateNV(nhanVien t) {
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "UPDATE xuatchieuhientai\n SET nhanvien = '" + t.getHoVaTen() + "';";
			int kq = st.executeUpdate(sql);
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<xuatChieu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public xuatChieu selectById(xuatChieu t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<xuatChieu> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAll(xuatChieu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int luuXuatChieuDangChon(int maXC) {
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "INSERT INTO hientai(maXCn)"
					+ "\nVALUES (" + maXC +")";
			
			int kq = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return maXC;
	}
	
}
