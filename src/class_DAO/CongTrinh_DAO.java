                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          package class_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_ConnectDB.ConnectDB;
import class_Entity.CongTrinh;

public class CongTrinh_DAO
{
	public CongTrinh_DAO() {}
	
	public ArrayList<CongTrinh> getalltbCongTrinh() 
	{
		ArrayList<CongTrinh> dsnv = new ArrayList<CongTrinh>();
		try 
		{
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from CONGTRINH";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) 
			{
				String maCT = rs.getString(1);;
				String tenCT = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayCapGP = rs.getDate(4);
				Date ngayKhoiCong = rs.getDate(5);
				Date ngayHTDuKien = rs.getDate(6);
				float tongChiPhi = rs.getFloat(7);
				CongTrinh nv = new CongTrinh(maCT, tenCT, diaDiem, ngayCapGP, ngayKhoiCong, ngayHTDuKien, tongChiPhi);	 		
				dsnv.add(nv);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public ArrayList<CongTrinh> getNhanVienTheoMaCT(int id) 
	{
		ArrayList<CongTrinh> dsnv = new ArrayList<CongTrinh>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement statement =null;
		try 
		{
			String sql = "Select * from CONGTRINH where MaCT = ?";
			statement=con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next())
			{
				String maCT = rs.getString(1);;
				String tenCT = rs.getString(2);
				String diaDiem = rs.getString(3);
				Date ngayCapGP = rs.getDate(4);
				Date ngayKhoiCong = rs.getDate(5);
				Date ngayHTDuKien = rs.getDate(6);
				float tongChiPhi = rs.getFloat(7);
				CongTrinh nv = new CongTrinh(maCT, tenCT, diaDiem, ngayCapGP, ngayKhoiCong, ngayHTDuKien, tongChiPhi);			
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

	public boolean create(CongTrinh nv) 
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try 
		{
			stmt = con.prepareStatement("insert into CONGTRINH(MaCT, TenCT, DiaDiem, NgayCapGP, NgayKC, NgayHTDuKien, TongChiPhiDuKien)"
					+ "values(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1,nv.getMaCT());
			stmt.setString(2,nv.getTenCT());
			stmt.setString(3,nv.getDiaDiem());
			stmt.setDate(4, new Date(nv.getNgayCapGP().getTime()));
			stmt.setDate(5, new Date(nv.getNgayKhoiCong().getTime()));
			stmt.setDate(6, new Date(nv.getNgayHTDuKien().getTime()));
			stmt.setFloat(7, nv.getTongChiPhi());
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
	
	public boolean update(CongTrinh nv)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try 
		{
			stmt = con.prepareStatement("UPDATE CONGTRINH SET TenCT=?, DiaDiem=?, NgayCapGP=?, "
					+ "NgayKC=?, NgayHTDuKien=?, TongChiPhiDuKien=? "
					+ "WHERE MaCT=?");
			stmt.setString(1, nv.getTenCT());
			stmt.setString(2, nv.getDiaDiem());
			stmt.setDate(3, new Date(nv.getNgayCapGP().getTime()));
			stmt.setDate(4, new Date(nv.getNgayKhoiCong().getTime()));
			stmt.setDate(5, new Date(nv.getNgayHTDuKien().getTime()));
			stmt.setFloat(6, nv.getTongChiPhi());
			stmt.setString(7, nv.getMaCT());
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
			stmt = con.prepareStatement("DELETE CONGTRINH WHERE MaCT=?");
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
}

