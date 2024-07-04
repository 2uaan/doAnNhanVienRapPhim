package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import database.jdbc_new;
import model.gheC;
import model.gheNS;

public class gheCDAO{

	Connection c = null;
	
	public gheC[] duyetGhe(int maxc) {
		gheC[] C = null;
		int tongSoGhe = 0;
		String tenGhe, hang;
		int cot, maXC,temp, trangThai, sta, dem;
		try {
			
			c = jdbc_new.getConnection();
			String sql = "SELECT * FROM ghec";

			PreparedStatement pst = c.prepareStatement(sql);		
					
			ResultSet result = pst.executeQuery();
			
			tongSoGhe=0;
			sta = 0;
			dem = 0;
			
			while (result.next()) {
				temp = result.getInt("maXC");
				if (temp == maxc) {
					if (tongSoGhe == 0) {
						sta = dem;
					}
					tongSoGhe++;
				}
				dem++;
			}
			
			C = new gheC[tongSoGhe];
			
			result = pst.executeQuery();
			
			tongSoGhe = 0;
			

			while (result.next()) {
				if (sta > 0) {
					sta--;
					continue;
				}else {
					C[tongSoGhe] = new gheC();
					hang = result.getString("hang");
					cot = result.getInt("cot");
					tenGhe = result.getString("tenGhe");
					maXC = result.getInt("maXC");
					trangThai = result.getInt("trangThai");
					
					C[tongSoGhe].setHang(hang.charAt(0));
					C[tongSoGhe].setCot(cot);
					C[tongSoGhe].setTenGhe(tenGhe);
					C[tongSoGhe].setMaXC(maXC);
					C[tongSoGhe].setTrangThai(trangThai);
					tongSoGhe++;
				}
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return C;
	}
	
	public String cat_ky_tu_cuoi(String str) {
		String strr = "";
		
		for (int i =0; i<str.length()-1; i++) {
			strr += str.charAt(i);
		}
		
		return strr;
	}
	
	public void duyet_gheC_dang_chon(gheC[] cou, int maXC, boolean[] checkC) {
//		ns = null;
		boolean check = false;
		
		for (int i =0; i< checkC.length; i++) {
			if (checkC[i] == false) {
				check = true;
			}
		}
		
		if (check) {
			try {
				c = jdbc_new.getConnection();
				Statement st = c.createStatement();
				String sql = "INSERT INTO ghedangduocchon\nVALUES";
				for (int i = 0; i<cou.length; i++) {
					if (!checkC[i]) {
						
						sql += "\n(" +maXC+",'" + cou[i].getTenGhe() + "','C'),";
						
					}
				}
				sql = cat_ky_tu_cuoi(sql) + ";";
				
				int kq = st.executeUpdate(sql);
				jdbc_new.closeConnection(c);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	public void luu_so_ghe_da_chon(int soGhe) {
		
		try {
			
			c = jdbc_new.getConnection();
			String sql = "UPDATE hientai\nSET"
					+ "\nsoGheNS = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, soGhe);
			
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
