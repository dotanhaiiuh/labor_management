package class_Entity;

import java.util.Date;

import class_Enum.LoaiNV;
import class_Enum.TrinhDo;

public class NhanVien 
{
	 private String maNV;
	 private String hoNV;
	 private String tenNV;
	 private Date ngaySinh;
	 private String diaChiThuongTru;
	 private String soDienThoai;
	 private String diaChiMail;
	 private java.util.Date ngayVaoLam;
	 private TrinhDo trinhDo;
	 private String maPB;
	 private int soNgayCong;
	 private LoaiNV loaiNV;
	 private float luong;
	 
	 public String getMaNV() {
		return maNV;
	 }
	 
	 public void setMaNV(String maNV) {
		this.maNV = maNV;
	 }
	 
	 public String getHoNV() {
		return hoNV;
	 }
	 
	 public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	 }
	 
	 public String getTenNV() {
		return tenNV;
	 }
	 
	 public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	 }
	 
	 public Date getNgaySinh() {
		return ngaySinh;
	 }
	 
	 public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	 }
	 
	 public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	 }
	 
	 public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	 }
	 
	 public String getSoDienThoai() {
		return soDienThoai;
	 }
	 
	 public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	 }
	
	 public String getDiaChiMail() {
		return diaChiMail;
	 }
	
	 public void setDiaChiMail(String diaChiMail) {
		this.diaChiMail = diaChiMail;
	 }
	 
	 public Date getNgayVaoLam() {
		return ngayVaoLam;
	 }
	 
	 public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	 }
	 
	 public TrinhDo getTrinhDo() {
		return trinhDo;
	 }
	 
	 public void setTrinhDo(TrinhDo trinhDo) {
		this.trinhDo = trinhDo;
	 }
	 
	 public String getMaPB() {
		return maPB;
	 }
	 
	 public void setMaPB(String maPB) {
		this.maPB = maPB;
	 }
	 
	 public int getSoNgayCong() {
		return soNgayCong;
	 }
	 
	 public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	 }
	 
	 public LoaiNV getLoaiNV() {
		return loaiNV;
	 }
	 
	 public void setLoaiNV(LoaiNV loaiNV) {
		this.loaiNV = loaiNV;
	 }
	
	 public float getLuong() {
		return luong;
	 }
	
	 public void setLuong(float luong) {
		this.luong = luong;
	 }
	 
	 public NhanVien() {}
	 
	 public NhanVien(String maNV, String hoNV, String tenNV, Date ngaySinh, String diaChiThuongTru, String soDienThoai,
			String diaChiMail, Date ngayVaoLam, TrinhDo trinhDo, String maPB, int soNgayCong, LoaiNV loaiNV, float luong) 
	 {
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.diaChiThuongTru = diaChiThuongTru;
		this.soDienThoai = soDienThoai;
		this.diaChiMail = diaChiMail;
		this.ngayVaoLam = ngayVaoLam;
		this.trinhDo = trinhDo;
		this.maPB = maPB;
		this.soNgayCong = soNgayCong;
		this.loaiNV = loaiNV;
		this.luong = luong;
	}
}
