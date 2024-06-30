package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import database.jdbc_new;
import model.gheC;

public class gheCDAO implements DAOinterface<gheC>{

	Connection c = null;
	
	public gheC[] duyetGhe(int maxc) {
		gheC[] ns = null;
		int tongSoGhe = 0;
		String tenGhe, hang;
		int cot, maXC,temp, trangThai, sta, dem;
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM ghecouple");
			
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
			
			ns = new gheC[tongSoGhe];
			
			ResultSet resul = st.executeQuery("SELECT * FROM ghecouple");
			
			tongSoGhe = 0;
			
			while (resul.next()) {
				if (sta > 0) {
					sta--;
					continue;
				}else {
					ns[tongSoGhe] = new gheC();
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
	
	
	@Override
	public int insert(gheC t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAll(gheC t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<gheC> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public gheC selectById(gheC t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<gheC> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
