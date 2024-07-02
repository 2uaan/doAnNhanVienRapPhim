package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.nhanVien;
import model.xuatChieu;

public class xuatChieuDAO{
	
	private Connection c = null;
	
	
	public xuatChieu[] duyetXC() {
		xuatChieu xc[] = null;
		String temp, tenPhim, tenNhanVien, gioBatDau, gioKetThuc, ngayThang;
		int soXC, maXC, maPhim, soGheNS, soGheC, soGheV;
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM xuatChieuHienTai");
			soXC = 0;
			while (result.next()) {
				temp = result.getString("tenPhim");
				soXC++;
			}
			
			xc = new xuatChieu[soXC];
			soXC=0;
			ResultSet resul = st.executeQuery("SELECT * FROM xuatChieuHienTai");
			while (resul.next()) {
				xc[soXC] = new xuatChieu();
				maXC = resul.getInt("maXC");
				maPhim = resul.getInt("maPhim");
				soGheNS = resul.getInt("tongGheNS");
				soGheV = resul.getInt("tongGheV");
				soGheC = resul.getInt("tongGheC");
				tenPhim = resul.getString("tenPhim");
				tenNhanVien = resul.getString("tenNhanVien");
				gioBatDau = resul.getString("gioBatDau");
				gioKetThuc = resul.getString("gioKetThuc");
				ngayThang = resul.getString("ngayThang");
				
				xc[soXC].setMaXC(maXC);
				xc[soXC].setTenPhim(tenPhim);
				xc[soXC].setMaPhim(maPhim);
				xc[soXC].setSoGheC(soGheC);
				xc[soXC].setSoGheNS(soGheNS);
				xc[soXC].setSoGheV(soGheV);
				xc[soXC].setTenNhanVien(tenNhanVien);
				xc[soXC].setGioBatDau(gioBatDau);
				xc[soXC].setGioKetThuc(gioKetThuc);
				xc[soXC].setNgayThang(ngayThang);
				
				soXC++;
				
				
			}
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return xc;
	}
	
	public String[] duyetTenPhim() {
		String[] tenP = new String[3]; 
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM phimDangChieu");
			int i = 0;
			while (result.next()) {
				tenP[i] = result.getString("tenPhim");
				i++;
			}
			jdbc_new.closeConnection(c);
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
	
	
	public int updateNV(nhanVien t) {
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "UPDATE xuatchieuhientai\n SET tenNhanVien = '" + t.getHoVaTen() + "';";
			int kq = st.executeUpdate(sql);
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}


	public void luuXuatChieuDangChon(int maXC) {
		
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
		
	}
	
	public void xoaXuatChieuDangChon() {
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "DELETE FROM hientai";
			
			int kq = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public int[] xuatXuatChieu() {
		xuatChieu xc[] = duyetXC();
		int maXC =0 ;
		int maPhim = 0;
		int ma[] = new int[2];
		try {
			
			c = jdbc_new.getConnection();
			
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM hientai");
			
			while (result.next()) {
				maXC = Integer.parseInt(result.getString("maXCn"));
			}
			
			for (int i = 0; i< xc.length; i++) {
				if (xc[i].getMaXC() == maXC) {
					maPhim = xc[i].getMaPhim();
				}
			}
			
			ma[0] = maXC;
			ma[1] = maPhim;
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ma;
	}
	
	public void xoaGheDangChon() {
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "DELETE FROM ghedangduocchon";
			
			System.out.println(sql);
			
			int kq = st.executeUpdate(sql);
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
