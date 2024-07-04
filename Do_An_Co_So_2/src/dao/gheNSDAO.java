package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.gheNS;
import model.xuatChieu;

public class gheNSDAO{
	
	Connection c = null;
	
	public gheNS[] duyetGhe(int maxc) {
		gheNS[] ns = null;
		int tongSoGhe = 0;
		String tenGhe, hang;
		int cot, maXC,temp, trangThai, sta, dem;
		try {
			
			c = jdbc_new.getConnection();
			
			String sql = "SELECT * FROM ghens";

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
			
			ns = new gheNS[tongSoGhe];
			
			result = pst.executeQuery();
			
			tongSoGhe = 0;
			
			while (result.next()) {
				if (sta > 0) {
					sta--;
					continue;
				}else {
					ns[tongSoGhe] = new gheNS();
					hang = result.getString("hang");
					cot = result.getInt("cot");
					tenGhe = result.getString("tenGhe");
					maXC = result.getInt("maXC");
					trangThai = result.getInt("trangThai");
					
					ns[tongSoGhe].setHang(hang.charAt(0));
					ns[tongSoGhe].setCot(cot);
					ns[tongSoGhe].setTenGhe(tenGhe);
					ns[tongSoGhe].setMaXC(maXC);
					ns[tongSoGhe].setTrangThai(trangThai);
					tongSoGhe++;
				}
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ns;
	}
	
	public void updateTrangThaiGhe(gheNS[] ns, boolean[] checkns) {
		boolean check =  false;
		for (int i =0; i< checkns.length; i++) {
			if (checkns[i] == false) {
				check = true;
			}
		}
		
		if (check) {
			
		}
	}
	
	public String cat_ky_tu_cuoi(String str) {
		String strr = "";
		
		for (int i =0; i<str.length()-1; i++) {
			strr += str.charAt(i);
		}
		
		return strr;
	}
	
	
	public void duyet_gheNS_dang_chon(gheNS[] ns, int maXC, boolean[] checkNS) {

		boolean check = false;
		
		for (int i =0; i< checkNS.length; i++) {
			if (checkNS[i] == false) {
				check = true;
			}
		}
		
		if (check) {
			try {
				c = jdbc_new.getConnection();
				Statement st = c.createStatement();
				String sql = "INSERT INTO ghedangduocchon\nVALUES";
				for (int i = 0; i<ns.length; i++) {
					if (!checkNS[i]) {
						
						sql += "\n(" +maXC+",'" + ns[i].getTenGhe() + "','NS'),";
						
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
