package model;

public class NhanVienModel {
	private String name;
	private String manv;
	private String matkhauNv;
	
	public NhanVienModel(String name, String manv) {
		super();
		this.name = name;
		this.manv = manv;
		this.matkhauNv = manv + manv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getMatkhauNv() {
		return matkhauNv;
	}

	public void setMatkhauNv(String matkhauNv) {
		this.matkhauNv = matkhauNv;
	}
	
	
	
	
}
