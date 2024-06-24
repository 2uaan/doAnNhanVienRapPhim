package model;

public class xuatChieuModel {
	String time;
	String tenPhim;
	boolean tinhTrang;
	public xuatChieuModel(String time, String tenPhim, boolean tinhTrang) {
		super();
		this.time = time;
		this.tenPhim = tenPhim;
		this.tinhTrang = tinhTrang;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
