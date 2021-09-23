package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import Model.SourcingTeam;

public class SourcingTeamDAO {
	public boolean validate1(SourcingTeam sourcingteam) throws SQLException, ClassNotFoundException
	{
		String rl = sourcingteam.getRl();
		ConnectionManager conn = new ConnectionManager();
		Connection con = conn.establishConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select registration_link from requirements.registration1");
	//    ResultSet rs =st.executeQuery("select *from registration_Link from requirements.registration ")	;
		while (rs.next())
		{
			if(rl.equals(rs.getString("registration_link"))==true)
			{
				conn.closeConnection();
				return true;
			}
		}
		conn.closeConnection();
		return false;
		
		
	}

}
