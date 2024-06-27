package test;

import java.sql.Connection;
import java.sql.Statement;

import database.jdbc_new;

public class tesst {
	public static void main(String[] args) {
		
		Connection c = null;
		int maXC = 312;
		
		try {
			
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			String sql = "INSERT INTO hientai(maXCn)"
					+ "\nVALUES \n(" + maXC +");";
			
			System.out.println(sql);
			
			int kq = st.executeUpdate(sql);

			jdbc_new.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
