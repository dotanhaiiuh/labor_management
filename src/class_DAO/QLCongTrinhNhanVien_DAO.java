package class_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_ConnectDB.ConnectDB;
import class_Entity.QLCongTrinhNhanVien;

public class QLCongTrinhNhanVien_DAO 
{
	public QLCongTrinhNhanVien_DAO() {}
	
	public ArrayList<QLCongTrinhNhanVien> getalltableCTNV()
	{
		ArrayList<QLCongTrinhNhanVien> dsnvct = new ArrayList<QLCongTrinhNhanVien>();
		try 
		{
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from QUANLYNHANVIENCONGTRINH";
			Statement statement = (Statement)con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) 
			{
				String maNV = rs.getString(1).trim();
				String maCT = rs.getString(2).trim();
				QLCongTrinhNhanVien nvct = new QLCongTrinhNhanVien(maNV, maCT);	
				dsnvct.add(nvct);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dsnvct;
	}
}
