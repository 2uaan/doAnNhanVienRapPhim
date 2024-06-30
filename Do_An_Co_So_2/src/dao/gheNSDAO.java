package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.gheNS;
import model.xuatChieu;

public class gheNSDAO implements DAOinterface<gheNS>{
	
	Connection c = null;
	
	public gheNS[] duyetGhe(int maxc) {
		gheNS[] ns = null;
		int tongSoGhe = 0;
		String tenGhe, hang;
		int cot, maXC,temp, trangThai, sta, dem;
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM ghens");
			
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
			

			
			ResultSet resul = st.executeQuery("SELECT * FROM ghens");
			
			tongSoGhe = 0;
			
			while (resul.next()) {
				if (sta > 0) {
					sta--;
					continue;
				}else {
					ns[tongSoGhe] = new gheNS();
					hang = resul.getString("hang");
					cot = resul.getInt("cot");
					tenGhe = resul.getString("tenGhe");
					maXC = resul.getInt("maXC");
					trangThai = resul.getInt("trangThai");
					
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
	
	@Override
	public int insert(gheNS t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(gheNS t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		
		int kq = 0;
		
		try {
			
			Connection c = jdbc_new.getConnection();
			
			Statement st = c.createStatement();
			
			String sql = "DELETE FROM ghens";
			
			kq = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}

	@Override
	public ArrayList<gheNS> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public gheNS selectById(gheNS t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<gheNS> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAll(gheNS t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
