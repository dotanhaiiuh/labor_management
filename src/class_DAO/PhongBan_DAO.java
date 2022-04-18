package class_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_ConnectDB.ConnectDB;
import class_Entity.PhongBan;

public class PhongBan_DAO 
{
	public PhongBan_DAO() {}
	
	public ArrayList<PhongBan> getalltbPhongBan() 
	{
		ArrayList<PhongBan> dspb = new ArrayList<PhongBan>();
		try 
		{
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PHONGBAN";
			Statement statement = (Statement)con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next())
			{
				String maPB = rs.getString(1);
				String tenPB = rs.getString(2);
				PhongBan pb = new PhongBan(maPB, tenPB);	
				dspb.add(pb);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return dspb;
	}
}
