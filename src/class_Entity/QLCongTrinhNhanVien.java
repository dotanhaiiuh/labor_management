package class_Entity;

public class QLCongTrinhNhanVien
{
	private String maNV;
	private String maCT;
	
	public String getMaNV() {
		return maNV;
	}
	
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	public String getMaCT() {
		return maCT;
	}
	
	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}
	
	public QLCongTrinhNhanVien() {}
	
	public QLCongTrinhNhanVien(String maNV, String maCT) {
		this.maNV = maNV;
		this.maCT = maCT;
	}
}
