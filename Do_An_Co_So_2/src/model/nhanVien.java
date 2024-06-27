package model;

public class nhanVien {
	
	private nhanVien[] nv;
	private int maNV;
	private String hoVaTen;
	

	public nhanVien() {
		super();
	}


	public nhanVien(int maNV, String hoVaTen) {
		super();
		this.maNV = maNV;
		this.hoVaTen = hoVaTen;
	}


	public int getMaNV() {
		return maNV;
	}


	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}


	public String getHoVaTen() {
		return hoVaTen;
	}


	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	
	
	
}
