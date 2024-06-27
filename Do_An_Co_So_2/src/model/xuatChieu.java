package model;

public class xuatChieu {
	
	private int maXC;
	private String tenPhim;
	private String nhanVien;
	private int soGheNS;
	private int soGheV;
	private int soGheC;
	
	
	public xuatChieu() {
		super();
	}

	public xuatChieu(int maXC, String tenPhim, String nhanVien, int soGheNS, int soGheV, int soGheC) {
		this.maXC = maXC;
		this.tenPhim = tenPhim;
		this.nhanVien = nhanVien;
		this.soGheNS = soGheNS;
		this.soGheV = soGheV;
		this.soGheC = soGheC;
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

	public String getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(String nhanVien) {
		this.nhanVien = nhanVien;
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
	
	
	
	
	
}
