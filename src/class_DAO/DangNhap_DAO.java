package class_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_ConnectDB.ConnectDB;
import class_Entity.DangNhap;

public class DangNhap_DAO {
	public DangNhap_DAO() {}
	
	public ArrayList<DangNhap> getalltabledangnhap() 
	{
		ArrayList<DangNhap> dsnv = new ArrayList<DangNhap>();
		try 
		{
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from THONGTINDANGNHAP";
			Statement statement = (Statement)con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) 
			{
				String maNV = rs.getString(1);
				String Pass = rs.getString(2);
				DangNhap nv = new DangNhap(maNV, Pass);	
				dsnv.add(nv);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dsnv;
	}
}
