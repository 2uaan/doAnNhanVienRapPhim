package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.jdbc_new;
import model.thucAn;

public class thucAnDAO{

	private Connection c = null;
	
	public thucAn[] duyet_do_an() {
		thucAn[] doan = null;
		String tenMon, phanLoai, maTA;
		int giaThanh, sl;
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT * FROM thucan\nWHERE phanLoai = 'doan'";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			sl = 0;
			while (result.next()) {
				String temp = result.getString("tenMon");
				sl++;
			}
			doan = new thucAn[sl];
			result = pst.executeQuery();
			sl=0;
			while (result.next()) {
				doan[sl] =  new thucAn();
				maTA = result.getString("maTA");
				tenMon = result.getString("tenMon");
				giaThanh = result.getInt("giaThanh");
				phanLoai = result.getString("phanLoai");
				
				doan[sl].setMaTA(maTA);
				doan[sl].setTenMon(tenMon);
				doan[sl].setGiaThanh(giaThanh);
				doan[sl].setPhanLoai(phanLoai);
				sl++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return doan;
	}
	
	public thucAn[] duyet_nuoc_uong() {
		thucAn[] nuoc = null;
		
		String tenMon, phanLoai, maTA;
		int giaThanh, sl;
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT * FROM thucan\nWHERE phanLoai = 'nuoc'";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			sl = 0;
			while (result.next()) {
				String temp = result.getString("tenMon");
				sl++;
			}
			nuoc = new thucAn[sl];
			result = pst.executeQuery();
			sl=0;
			while (result.next()) {
				nuoc[sl] =  new thucAn();

				maTA = result.getString("maTA");
				tenMon = result.getString("tenMon");
				giaThanh = result.getInt("giaThanh");
				phanLoai = result.getString("phanLoai");
				
				nuoc[sl].setMaTA(maTA);
				nuoc[sl].setTenMon(tenMon);
				nuoc[sl].setGiaThanh(giaThanh);
				nuoc[sl].setPhanLoai(phanLoai);
				sl++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return nuoc;
	}
	
	public thucAn[] duyet_tat_ca_thuc_an() {
		thucAn[] ta= new thucAn[duyet_so_luong_thuc_an()];
		thucAn[] fo = duyet_do_an();
		thucAn[] dr = duyet_nuoc_uong();
		int dem = 0;
		
		for (thucAn phtu : fo) {
		    ta[dem] = phtu;
		    dem++;
		}
		for (thucAn phtu : dr) {
			ta[dem] = phtu;
		    dem++;
		}
		
		
		return ta;
	}
	
	public String cat_ky_tu_cuoi(String str) {
		String strr = "";
		
		for (int i =0; i<str.length()-1; i++) {
			strr += str.charAt(i);
		}
		
		return strr;
	}
	
	public void luu_thuc_an_order(String[][] luu) {
		
		try {
			
			c = jdbc_new.getConnection();
			String sql = "UPDATE hientai\nSET";
			for (int i = 0; i < luu.length; i++) {
				sql +="\n " + luu[i][0] + " = " + luu[i][1] + ",";
			}
			
			sql = cat_ky_tu_cuoi(sql) + ";";
			
			PreparedStatement pst = c.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public int[] duyet_so_luong_tung_loai() {
		int sl[] = new int[duyet_so_luong_thuc_an()];
		String[] maTA = new String[duyet_so_luong_thuc_an()];
		
		try {
			
			c= jdbc_new.getConnection();
			String sql = "SELECT * FROM  thucan";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			int i =0;
			while(result.next()) {
				String temp = result.getString("maTA");
				maTA[i] = temp;
				i++;
			}
			
			sql = "SELECT * FROM hientai";
			pst = c.prepareStatement(sql);
			result = pst.executeQuery();
			
			while(result.next()) {
				for (i=0; i<maTA.length; i++) {
					int so = result.getInt(maTA[i]);
					sl[i] = so;
				}
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		return sl;
	}
	
	public int duyet_so_luong_thuc_an() {
		int soluong=0;
		
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT * FROM  thucan";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				String temp = result.getString("tenMon");
				soluong++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return soluong;
	}
}
