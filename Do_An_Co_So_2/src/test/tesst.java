package test;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Time;

import dao.gheNSDAO;
import dao.xuatChieuDAO;
import database.jdbc_new;
import model.gheNS;
import model.xuatChieu;

public class tesst {
	
	private static xuatChieuDAO xchieu = new xuatChieuDAO();
	
	
	public static void main(String[] args) {
		
		int so;
		
//		gheNS[][] ns = new gheNSDAO().duyetGhe(798);
		for (int i =0; i< 2; i++) {
			for (int j = 0; j<8; j++) {
				so = (i==0 && j==0) ? 0 : 8*(i+1) - (8-j);
				System.out.println(so);
			}
		}		
		
//		int temp = xchieu.xuatXuatChieu();
//		
//		System.out.println("Quan");
//		System.out.println(temp);
		
		
//		Connection c = null;
//		int maXC = 312;
//		
//		try {
//			
//			c = jdbc_new.getConnection();
//			Statement st = c.createStatement();
//			String sql = "INSERT INTO hientai(maXCn)"
//					+ "\nVALUES \n(" + maXC +");";
//			
//			System.out.println(sql);
//			
//			int kq = st.executeUpdate(sql);
//
//			jdbc_new.closeConnection(c);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		xuatChieu xc[] = null;
//		xc = new xuatChieuDAO().duyetXC();
//		
//		System.out.println(xc[2].getTenNhanVien());
		
	}
}
