package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbc_new;

public class test_connection {
	public static void main(String[] args) {
		int soghens=0, soghev=0, soghec=0, sl=0, i=0, tongGhe=0, tongThucAn = 0;
		int tenTA[]=null, soluongTA[]=null, num=0;
		
		Connection c = null;
		
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM xuatchieuhientai");
			
			
			while (result.next())
			{
				soghens = Integer.parseInt(result.getString("tongGheNS"));
				soghev = Integer.parseInt(result.getString("tongGheV"));
				soghec = Integer.parseInt(result.getString("tongGheC"));
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM doan_dagoi");
			
			while (result.next()) {
				int a = Integer.parseInt(result.getString("soLuong"));
				num++;
			}
			tenTA = new int[num];
			soluongTA = new int[num];
			ResultSet r = st.executeQuery("SELECT * FROM doan_dagoi");
			
			while (r.next()) {
				String tam = r.getString("tenThucAn");
				System.out.println(tam);
				int a = Integer.parseInt(r.getString("soLuong"));
				switch (tam) {
				case "Combo 2 Nước Lọc":{
					sl=2;
					break;
				}
				case "Bắp Phô Mai":{
					sl=1;
					break;
				}
				case "Bắp Caramel":{
					sl=1;
					break;
				}
				case "Coca-cola":{
					sl=2;
					break;
				}
				case "Soda":{
					sl=2;
					break;
				}
				case "Combo 2 Bắp Ngọt":{
					sl=1;
					break;
				}
				
				
				}
				tenTA[i]=sl;
				soluongTA[i]=a;
				i++;
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (int j =0; j<num;j++) {
//			if (tenTA[j]==1) {
//				tongThucAn += 69*soluongTA[j];
//			}else {
//				tongThucAn += 39*soluongTA[j];
//			}
//			System.out.println(soluongTA[j]);
		}
		tongGhe = soghens*85 + soghev*105 + soghec*190;
		System.out.println(tongGhe);
		
	}
}
