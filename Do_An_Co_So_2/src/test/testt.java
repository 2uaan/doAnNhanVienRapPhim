package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbc_new;
import model.nhanVien;

public class testt {
	
	public static void main(String[] args) {
		
//		nhanVien nVien[] = null;
//		int sonv = 1;
//		Connection c = null;
//		
//		try {
//			c = jdbc_new.getConnection();
//			Statement st = c.createStatement();
//			ResultSet result = st.executeQuery("SELECT * FROM nhanvien");
//			
//			while (result.next()) {
//				String tam = result.getString("hoVaTen");
//				sonv++;
//			}
//			ResultSet resul = st.executeQuery("SELECT * FROM nhanvien");
//			nVien = new nhanVien[sonv];
//			int i = 0;
//			while (resul.next()) {
//				nVien[i] = new nhanVien();
//				sonv--;
//				int manv = resul.getInt("maNV");
//				String tennv = resul.getString("hoVaTen");
//				nVien[i].setHoVaTen(tennv);
//				nVien[i].setMaNV(manv);
//				i++;
//			}
//			
//			jdbc_new.closeConnection(c);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		System.out.println(nVien[2].getHoVaTen());
	
	
	
		
		try {
			Connection c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "INSERT INTO ghens(hang, cot, tenGhe, maXC, trangThai)\nVALUES";
			
			for (int i =0; i<2; i++) {
				char ch = (i==0) ? 'A':'B';
				for (int j=0; j<8; j++) {
					if (j == 7 && i==1) sql += "\n('" + ch + "', " + (int)(j+1) + ", '" + ch+(int)(j+1) + "', " + 798 + ", " + 1 + ");";
					else sql += "\n('" + ch + "', " + (int)(j+1) + ", '" + ch+(int)(j+1) + "', " + 798 + ", " + 1 + "),";
					
				}
			}
			
			
			
			int kq = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
//		try {
//			Connection c = jdbc_new.getConnection();
//			Statement st = c.createStatement();
//			String sql = "INSERT INTO xuatchieuhientai(maXC, tenPhim, nhanvien, tongGheNS, tongGheV, tongGheC, gioBatDau, gioKetThuc)\nVALUES"
//					+ "\n(312, 'Inside Out 2', null, 16, 16, 8, '16:30', '18:10'),"
//					+ "\n(465, 'Deadpool & Wolverine', null, 16, 16, 8, '18:30', '21:00'),"
//					+ "\n(798, 'Godzilla x Kong: The New Empire', null, 16, 16, 8, '21:20', '23:30');";
//			
//			System.out.println(sql);
//			
//			int kq = st.executeUpdate(sql);
//			
//			jdbc_new.closeConnection(c);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		nhanVien t = new nhanVien(234, "Minh Quan");
//		
//		Connection c = null;
//		
//		try {
//			
//			c = jdbc_new.getConnection();
//			
//			Statement st = c.createStatement();
//			
//			String sql = "UPDATE xuatchieuhientai\n SET nhanvien = '" + t.getHoVaTen() + "';";
//			
//			int kq = st.executeUpdate(sql);
//			
//			jdbc_new.closeConnection(c);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}
	
}
