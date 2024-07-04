package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.nhanVien;

public class nhanVienDAO{
	
	private Connection c = null;
	
	public nhanVien[] duyetNV(){
		int sonv = 0;
		nhanVien nv[] = null;
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT * FROM nhanvien";
			
			PreparedStatement pst = c.prepareStatement(sql);
			
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String tam = result.getString("tenNhanVien");
				sonv++;
			}
			
			result = pst.executeQuery();
			
			nv = new nhanVien[sonv];
			int i = 0;
			while (result.next()) {
				nv[i] = new nhanVien();
				sonv--;
				int manv = result.getInt("maNV");
				String tennv = result.getString("tenNhanVien");
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
			
			String sql = "SELECT * FROM xuatchieuhientai";
			
			PreparedStatement pst = c.prepareStatement(sql);
			
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				tennv = result.getString("tenNhanVien");
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tennv;
	}
	
	public int updateNV(nhanVien t) {
		
		try {
			
			c = jdbc_new.getConnection();
			
			String sql = "UPDATE xuatchieuhientai\n SET tenNhanVien = ?;";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getHoVaTen());
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	
}
