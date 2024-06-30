package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.gheNS;
import model.gheV;

public class gheVDAO implements DAOinterface<gheV>{

	
	Connection c = null;
	
	public gheV[] duyetGhe(int maxc) {
		gheV[] v = null;
		int tongSoGhe = 0;
		String tenGhe, hang;
		int cot, maXC,temp, trangThai, sta, dem;
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM ghevip");
			
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
			
			v = new gheV[tongSoGhe];
			
			ResultSet resul = st.executeQuery("SELECT * FROM ghevip");
			
			tongSoGhe = 0;
			
			while (resul.next()) {
				if (sta > 0) {
					sta--;
					continue;
				}else {
					v[tongSoGhe] = new gheV();
					hang = resul.getString("hang");
					cot = resul.getInt("cot");
					tenGhe = resul.getString("tenGhe");
					maXC = resul.getInt("maXC");
					trangThai = resul.getInt("trangThai");
					
					v[tongSoGhe].setHang(hang.charAt(0));
					v[tongSoGhe].setCot(cot);
					v[tongSoGhe].setTenGhe(tenGhe);
					v[tongSoGhe].setMaXC(maXC);
					v[tongSoGhe].setTrangThai(trangThai);
					tongSoGhe++;
				}
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return v;
	}
	
	
	@Override
	public int insert(gheV t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAll(gheV t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<gheV> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public gheV selectById(gheV t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<gheV> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
