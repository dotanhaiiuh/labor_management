package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_ConnectDB.ConnectDB;
import class_Entity.NhanVien;
import class_Enum.LoaiNV;
import class_Enum.TrinhDo;

public class NhanVien_DAO
{
	public NhanVien_DAO() {}
	
	public ArrayList<NhanVien> getalltbNhanVien()
	{
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try 
		{
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from NHANVIEN";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) 
			{
				String maNV = rs.getString(1).trim();
				String hoNV = rs.getString(2).trim();
				String tenNV = rs.getString(3).trim();
				Date ngaySinh = rs.getDate(4);
				String diaChiThuongTru = rs.getString(5).trim();
				String soDienThoai = rs.getString(6).trim();
				String diaChiMail = rs.getString(7).trim();
				Date ngayVaoLam = rs.getDate(8);
				String trinhDo = rs.getString(9).trim();
				String maPB = rs.getString(10).trim();
				int soNgayCong = rs.getInt(11);
				String loaiNV = rs.getString(12).trim();
				float luong = rs.getFloat(13);
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, ngaySinh, diaChiThuongTru, soDienThoai, diaChiMail, ngayVaoLam, TrinhDo.valueOf(trinhDo), maPB, soNgayCong, LoaiNV.valueOf(loaiNV), luong);
				dsnv.add(nv);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMaNV(int id)
	{
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement statement =null;
		try 
		{
			String sql = "Select * from NHANVIEN where MaNV = ?";
			statement=con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next())
			{
				String maNV = rs.getString(1);;
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				String diaChiThuongTru = rs.getString(5);
				String soDienThoai = rs.getString(6);
				String diaChiMail = rs.getString(7);
				Date ngayVaoLam = rs.getDate(8);
				TrinhDo trinhDo = TrinhDo.valueOf((rs.getString(9)).toUpperCase());
				String maPB = rs.getString(10);
				int soNgayCong = rs.getInt(11);
				LoaiNV loaiNV = LoaiNV.valueOf(rs.getString(12).toUpperCase());
				float luong = rs.getFloat(13);
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, ngaySinh, diaChiThuongTru, soDienThoai, diaChiMail, ngayVaoLam, trinhDo, maPB, soNgayCong, loaiNV, luong);
				dsnv.add(nv);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				statement.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return dsnv;
	}

	public boolean create(NhanVien nv) 
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NHANVIEN(MaNV, HoNV, TenNV, NgaySinh, DiaChiThuongTru, SoDienThoai, DiaChiMail, NgayVaoLam, TrinhDo, MaPB, SoNgayCong, LoaiNV, Luong)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1,nv.getMaNV());
			stmt.setString(2,nv.getHoNV());
			stmt.setString(3,nv.getTenNV());
			stmt.setDate(4, new Date(nv.getNgaySinh().getTime()));
			stmt.setString(5,nv.getDiaChiThuongTru());
			stmt.setString(6,nv.getSoDienThoai());
			stmt.setString(7,nv.getDiaChiMail());
			stmt.setDate(8, new Date(nv.getNgayVaoLam().getTime()));
			stmt.setString(9, nv.getTrinhDo().toString());
			stmt.setString(10,nv.getMaPB());
			stmt.setInt(11,nv.getSoNgayCong());
			stmt.setString(12,nv.getLoaiNV().toString());
			stmt.setFloat(13,nv.getLuong());
			n = stmt.executeUpdate();	
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	
	public boolean update(NhanVien nv) 
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try
		{
			stmt = con.prepareStatement("UPDATE NHANVIEN SET HoNV=?, TenNV=?, NgaySinh=?,"
					+ "DiaChiThuongTru=?, SoDienThoai=?, DiaChiMail=?, NgayVaoLam=?,"
					+ "TrinhDo=?, MaPB=?, SoNgayCong=?, LoaiNV=?, Luong=? "
					+ "WHERE MaNV=?");	
			stmt.setString(1,nv.getHoNV());
			stmt.setString(2,nv.getTenNV());
			stmt.setDate(3, new Date(nv.getNgaySinh().getTime()));
			stmt.setString(4,nv.getDiaChiThuongTru());
			stmt.setString(5,nv.getSoDienThoai());
			stmt.setString(6,nv.getDiaChiMail());
			stmt.setDate(7, new Date(nv.getNgayVaoLam().getTime()));
			stmt.setString(8, nv.getTrinhDo().toString());
			stmt.setString(9,nv.getMaPB());
			stmt.setInt(10,nv.getSoNgayCong());
			stmt.setString(11,nv.getLoaiNV().toString());
			stmt.setFloat(12,nv.getLuong());
			stmt.setString(13,nv.getMaNV());
			n = stmt.executeUpdate();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	
	public boolean delete(String nv)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try 
		{
			stmt = con.prepareStatement("DELETE NHANVIEN WHERE MaNV=?");
			stmt.setString(1,nv);
			n = stmt.executeUpdate();	
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	
	public boolean updatephonenb(String pnb, String maNV)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try
		{
			stmt = con.prepareStatement("UPDATE NHANVIEN SET SoDienThoai=? WHERE MaNV=?");
			stmt.setString(1,pnb);
			stmt.setString(2,maNV);
			n = stmt.executeUpdate();	
		} 
		catch (SQLException e)
		{			
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	
	public boolean updatediachi(String diachi, String maNV) 
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try 
		{
			stmt = con.prepareStatement("UPDATE NHANVIEN SET DiaChiThuongTru=? WHERE MaNV=?");
			stmt.setString(1,diachi);
			stmt.setString(2,maNV);
			n = stmt.executeUpdate();	
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	
	public boolean updatemail(String mail, String maNV) 
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try 
		{
			stmt = con.prepareStatement("UPDATE NHANVIEN SET DiaChiMail=? WHERE MaNV=?");
			stmt.setString(1,mail);
			stmt.setString(2,maNV);
			n = stmt.executeUpdate();	
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
}

