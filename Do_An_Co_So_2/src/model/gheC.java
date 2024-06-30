package model;

public class gheC {
	
	private char hang;
	private int cot;
	private String tenGhe;
	private int maXC;
	private int trangThai;
	
	
	
	public gheC() {
		super();
	}



	public gheC(char hang, int cot, String tenGhe, int maXC, int trangThai) {
		super();
		this.hang = hang;
		this.cot = cot;
		this.tenGhe = tenGhe;
		this.maXC = maXC;
		this.trangThai = trangThai;
	}



	public char getHang() {
		return hang;
	}



	public void setHang(char hang) {
		this.hang = hang;
	}



	public int getCot() {
		return cot;
	}



	public void setCot(int cot) {
		this.cot = cot;
	}



	public String getTenGhe() {
		return tenGhe;
	}



	public void setTenGhe(String tenGhe) {
		this.tenGhe = tenGhe;
	}



	public int getMaXC() {
		return maXC;
	}



	public void setMaXC(int maXC) {
		this.maXC = maXC;
	}



	public int getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
}
