package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import database.jdbc_new;
import model.nhanVien;
import model.xuatChieu;

public class xuatChieuDAO implements DAOinterface<xuatChieu>{

	@Override
	public int insert(xuatChieu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateNV(nhanVien t) {
		
		Connection c = null;
		
		try {
			
			c = jdbc_new.getConnection();
			
			Statement st = c.createStatement();
			
			String sql = "UPDATE xuatchieuhientai\n SET nhanvien = '" + t.getHoVaTen() + "';";
			
			int kq = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<xuatChieu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public xuatChieu selectById(xuatChieu t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<xuatChieu> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAll(xuatChieu t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
