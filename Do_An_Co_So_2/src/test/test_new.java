package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbc_new;

public class test_new {
    public static void main(String[] args) {
    	Connection c = null;
		String tam ="A3 A% ";
		int dem=0;
		
		int demm=0;
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			
			ResultSet r = st.executeQuery("SELECT * FROM doan_dagoi");
			
			while (r.next()) {
				int a = r.getInt("soLuong");
				demm++;
			}
			
			int cc=demm;
			while (r.next()) {
				cc--;
			
			}
			
			
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		System.out.println(demm);
		
		for (int j=0; j<tam.length(); j++) {
			if (tam.charAt(j)==' ') {
				dem++;
			}
		}
		System.out.println(dem);
		String t ="";
		for (int j=0; j<tam.length(); j++) {
			t +=tam.charAt(j);
			if (tam.charAt(j)==' ') {
				System.out.println(t);
				t="";
			}
		}
		
		
    	
    }
}
