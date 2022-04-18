package class_Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CongTrinh {
	private String maCT;
	private String tenCT;
	private String diaDiem;
	private Date ngayCapGP;
	private Date ngayKhoiCong;
	private Date ngayHTDuKien;
	private float tongChiPhi;
	
	public String getMaCT() {
		return maCT;
	}
	
	public void setMaCT(String maCT) 
	{
		if(maCT == null)
		{
			this.maCT="NULL";
		}
		else
		{
			this.maCT = maCT;
		}
	}
	
	public String getTenCT()
	{
		return tenCT;
	}
	
	public void setTenCT(String tenCT) 
	{
		if(tenCT == null)
		{
			this.tenCT="NULL";
		}
		else
		{
			this.tenCT = tenCT;
		}
	}
	
	public String getDiaDiem() {
		return diaDiem;
	}
	
	public void setDiaDiem(String diaDiem) 
	{
		if(diaDiem == null)
		{
			this.diaDiem="NULL";
		}
		else
		{
			this.diaDiem = diaDiem;
		}
	}
	
	public Date getNgayCapGP() {
		return ngayCapGP;
	}
	
	public void setNgayCapGP(Date ngayCapGP) throws ParseException
	{
		if(ngayCapGP == null)
		{
			this.ngayCapGP= new SimpleDateFormat("dd-MM-yyyy").parse("00-00-0000");
		}
		else
		{
			this.ngayCapGP = ngayCapGP;
		}
	}
	
	public Date getNgayKhoiCong() {
		return ngayKhoiCong;
	}
	
	public void setNgayKhoiCong(Date ngayKhoiCong) throws ParseException
	{
		if(ngayKhoiCong == null)
		{
			this.ngayKhoiCong= new SimpleDateFormat("dd-MM-yyyy").parse("00-00-0000");
		}
		else
		{
			this.ngayKhoiCong = ngayKhoiCong;
		}
	}
	public Date getNgayHTDuKien() 
	{
		return ngayHTDuKien;
	}
	
	public void setNgayHTDuKien(Date ngayHTDuKien) throws ParseException
	{
		if(ngayHTDuKien == null)
		{
			this.ngayHTDuKien= new SimpleDateFormat("dd-MM-yyyy").parse("00-00-0000");
		}
		else
		{
			this.ngayHTDuKien = ngayHTDuKien;
		}
	}
	
	public float getTongChiPhi() 
	{
		return tongChiPhi;
	}
	
	public void setTongChiPhi(float tongChiPhi) 
	{
		if(tongChiPhi < 0 || String.valueOf(tongChiPhi) == null)
		{
			this.tongChiPhi=0;
		}
		else
		{
			this.tongChiPhi = tongChiPhi;
		}
	}
	
	public CongTrinh() {}
	
	public CongTrinh(String maCT, String tenCT, String diaDiem, Date ngayCapGP2, Date ngayKhoiCong2, Date ngayHTDuKien2,
			float tongChiPhi)
	{
		this.maCT = maCT;
		this.tenCT = tenCT;
		this.diaDiem = diaDiem;
		this.ngayCapGP =  ngayCapGP2;
		this.ngayKhoiCong = ngayKhoiCong2;
		this.ngayHTDuKien = ngayHTDuKien2;
		this.tongChiPhi = tongChiPhi;
	}
}
