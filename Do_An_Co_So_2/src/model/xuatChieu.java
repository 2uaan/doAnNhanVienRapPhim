package model;

import java.sql.Time;

public class xuatChieu {
	
	private int maXC;
	private String tenPhim;
	private int maPhim;
	private String tenNhanVien;
	private int soGheNS;
	private int soGheV;
	private int soGheC;
	private String gioBatDau;
	private String gioKetThuc;
	private String ngayThang;
	
	public xuatChieu() {
		super();
	}

	public xuatChieu(int maXC, String tenPhim, int maPhim, String tenNhanVien, int soGheNS, int soGheV, int soGheC,
			String gioBatDau, String gioKetThuc, String ngayThang) {
		super();
		this.maXC = maXC;
		this.tenPhim = tenPhim;
		this.maPhim = maPhim;
		this.tenNhanVien = tenNhanVien;
		this.soGheNS = soGheNS;
		this.soGheV = soGheV;
		this.soGheC = soGheC;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.ngayThang = ngayThang;
	}

	public int getMaXC() {
		return maXC;
	}

	public void setMaXC(int maXC) {
		this.maXC = maXC;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public int getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(int maPhim) {
		this.maPhim = maPhim;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public int getSoGheNS() {
		return soGheNS;
	}

	public void setSoGheNS(int soGheNS) {
		this.soGheNS = soGheNS;
	}

	public int getSoGheV() {
		return soGheV;
	}

	public void setSoGheV(int soGheV) {
		this.soGheV = soGheV;
	}

	public int getSoGheC() {
		return soGheC;
	}

	public void setSoGheC(int soGheC) {
		this.soGheC = soGheC;
	}

	public String getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	public String getNgayThang() {
		return ngayThang;
	}

	public void setNgayThang(String ngayThang) {
		this.ngayThang = ngayThang;
	}
	
	

	
}
