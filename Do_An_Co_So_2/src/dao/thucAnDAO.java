package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.jdbc_new;
import model.thucAn;

public class thucAnDAO{

	private Connection c = null;
	
	public thucAn[] duyet_do_an() {
		thucAn[] doan = null;
		String tenMon, phanLoai;
		int giaThanh, sl;
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM thucan\nWHERE phanLoai = 'doan'");
			
			sl = 0;
			while (result.next()) {
				String temp = result.getString("tenMon");
				sl++;
			}
			doan = new thucAn[sl];
			result = st.executeQuery("SELECT * FROM thucan\nWHERE phanLoai = 'doan'");
			sl=0;
			while (result.next()) {
				doan[sl] =  new thucAn();
				tenMon = result.getString("tenMon");
				giaThanh = result.getInt("giaThanh");
				phanLoai = result.getString("phanLoai");
				
				doan[sl].setTenMon(tenMon);
				doan[sl].setGiaThanh(giaThanh);
				doan[sl].setPhanLoai(phanLoai);
				sl++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return doan;
	}
	
	public thucAn[] duyet_nuoc_uong() {
		thucAn[] nuoc = null;
		
		String tenMon, phanLoai;
		int giaThanh, sl;
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM thucan\nWHERE phanLoai = 'nuoc'");
			
			sl = 0;
			while (result.next()) {
				String temp = result.getString("tenMon");
				sl++;
			}
			nuoc = new thucAn[sl];
			result = st.executeQuery("SELECT * FROM thucan\nWHERE phanLoai = 'nuoc'");
			sl=0;
			while (result.next()) {
				nuoc[sl] =  new thucAn();
				tenMon = result.getString("tenMon");
				giaThanh = result.getInt("giaThanh");
				phanLoai = result.getString("phanLoai");
				
				nuoc[sl].setTenMon(tenMon);
				nuoc[sl].setGiaThanh(giaThanh);
				nuoc[sl].setPhanLoai(phanLoai);
				sl++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return nuoc;
	}
	
}
