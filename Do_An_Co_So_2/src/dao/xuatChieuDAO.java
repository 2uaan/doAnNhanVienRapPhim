package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			String sql =  "SELECT * FROM xuatChieuHienTai";

			PreparedStatement pst = c.prepareStatement(sql);
			
			ResultSet result = pst.executeQuery();
			soXC = 0;
			while (result.next()) {
				temp = result.getString("tenPhim");
				soXC++;
			}
			
			xc = new xuatChieu[soXC];
			
			result = pst.executeQuery();
			
			soXC=0;
			while (result.next()) {
				xc[soXC] = new xuatChieu();
				maXC = result.getInt("maXC");
				maPhim = result.getInt("maPhim");
				soGheNS = result.getInt("tongGheNS");
				soGheV = result.getInt("tongGheV");
				soGheC = result.getInt("tongGheC");
				tenPhim = result.getString("tenPhim");
				tenNhanVien = result.getString("tenNhanVien");
				gioBatDau = result.getString("gioBatDau");
				gioKetThuc = result.getString("gioKetThuc");
				ngayThang = result.getString("ngayThang");
				
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
			
			String sql = "SELECT * FROM phimDangChieu";
			
			PreparedStatement pst = c.prepareStatement(sql);
			
			ResultSet result = pst.executeQuery();
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
			String sql = "SELECT * FROM xuatchieuhientai";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
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


	public void luuXuatChieuDangChon(xuatChieu xc) {
		
		try {
			
			c = jdbc_new.getConnection();
			
			String sql = "INSERT INTO hientai(maXCn)"
					+ "\nVALUES (?)";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, xc.getMaXC());
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void xoaXuatChieuDangChon() {
		
		try {
			
			c = jdbc_new.getConnection();
			
			String sql = "DELETE FROM hientai";
			
			PreparedStatement pst = c.prepareStatement(sql);
			
			int kq = pst.executeUpdate();
			
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
			
			String sql = "SELECT * FROM hientai";
			
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
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
			String sql = "DELETE FROM ghedangduocchon";
			PreparedStatement pst = c.prepareStatement(sql);
			
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public int duyet_so_ghe_dang_chon() {
		int soluong = 0;
		
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT *FROM ghedangduocchon";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				String temp = result.getString("tenGhe");
				soluong++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return soluong;
	}
	
	public String doi_sang_gia_tien(int giaThanh) {
		
		String temp = "";
		
		while(giaThanh > 1000) {
			String t = giaThanh +"";
			temp = "."+t.substring(t.length()-3, t.length()) + temp;
			giaThanh /= 1000;
		}
		
		temp = giaThanh + temp;
		
		temp += "đ";

		
		return temp;
	}
	
	public String[][] duyet_ghe_dang_chon(){
		String ghe[][] = new String[duyet_so_ghe_dang_chon()][3];
		
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT * FROM ghedangduocchon";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			int dem  =0;
			while(result.next()) {
				String ten = result.getString("tenGhe");
				String loai = result.getString("loaiGhe");
				int giaBan = 0;
				String sql2 = "SELECT * FROM loaighe";
				PreparedStatement pst2 =c.prepareStatement(sql2);
				ResultSet result2 = pst2.executeQuery();
				
				while(result2.next()) {
					if (loai.equals(result2.getString("loai"))) giaBan = result2.getInt("giaBan"); 
				}
				
				ghe[dem][0] = ten;
				ghe[dem][1] = loai;
				ghe[dem][2] = giaBan+"";
				dem++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ghe;
	}
	
}
