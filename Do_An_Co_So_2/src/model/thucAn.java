package model;

public class thucAn {
	private String maTA;
	private String tenMon;
	private int giaThanh;
	private String phanLoai;
	
	public thucAn() {
		super();
	}

	public thucAn(String maTA, String tenMon, int giaThanh, String phanLoai) {
		super();
		this.maTA = maTA;
		this.tenMon = tenMon;
		this.giaThanh = giaThanh;
		this.phanLoai = phanLoai;
	}

	public String getMaTA() {
		return maTA;
	}

	public void setMaTA(String maTA) {
		this.maTA = maTA;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public int getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(int giaThanh) {
		this.giaThanh = giaThanh;
	}

	public String getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}

	
}
