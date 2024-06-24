package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

//import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class jdbc_new {
	public static Connection getConnection() {
		Connection c = null;
		
		
		try {
			// Đăng kí MySQL Driver với DriverManager
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			// Thong so
			String url = "jdbc:mySQL://localhost:3306/danhsachnv";
			String username = "root";
			String password = "";
			
			// Tao ket noi
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection (Connection c) {
		try {
			if (c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfor(Connection c) {
		try {
			if (c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
