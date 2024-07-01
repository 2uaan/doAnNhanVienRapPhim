package model;

import java.awt.Color;

public class color {
	public Color ghens = Color.LIGHT_GRAY;
	public Color ghev = new Color(225, 215, 0);
	public Color ghec = new Color(242, 99, 152);
	
	public Color trongSuot = new Color(0,0,0,0);
	public Color screenColor = new Color(16,13,8);
	
	public Color nauXam = new Color(86,73,76);
	public Color nauVang = new Color(214, 186, 115);
	
	public Color[] mau_decor_poster(int maPhim) {
		Color[] color = new Color[3];
			
		switch (maPhim) {
			case 111:{
				color[0] = new Color(228, 95, 12, 150);
				color[1] = new Color(87, 149, 65, 150);
				color[2] = Color.black;
				break;
			}
			case 112:{
				color[0] = new Color(246, 227, 58, 150);
				color[1] = new Color(178, 45, 42, 150);
				color[2] = Color.black;
				break;
			}
			case 113:{
				color[0] = new Color(242, 114, 22, 150);
				color[1] = new Color(11, 144, 160, 150);
				color[2] = Color.black;
				break;
			}
		}
		
		return color;
	}
	
	public Color mau_ten_ghe(String tenGhe) {
		Color col = null;
		
			switch (tenGhe) {
			case "NS":{
				col = ghens;
				break;
			}
			case "V":{
				col = ghev;
				break;
			}
			case "C":{
				col = ghec;
				break;
			}
		}
		
		return col;
	}
	
	public Color mau_ky_hieu(String ten) {
		Color color = null;
		
		switch (ten){
			
			case "Gần Màn Hình":{
				color = ghens;
				break;
			}
			case "Vip":{
				color = ghev;
				break;
			}
			case "Couple":{
				color = ghec;
				break;
			}
			case "Đã Bán":{
				color = Color.DARK_GRAY;
				break;
			}	
		}
		return color;
	}
}
