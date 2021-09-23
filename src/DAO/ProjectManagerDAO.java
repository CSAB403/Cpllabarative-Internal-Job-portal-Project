package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectionManager.ConnectionManager;
import Model.ProjectManager;

public class ProjectManagerDAO {
	public void addDetails(ProjectManager projectmanager) throws SQLException, ClassNotFoundException
	{
		String sector1=projectmanager.getSector1();
		String sector2=projectmanager.getSector2();
		int rjmfsct1=projectmanager.getRjmfsct1();
		int rjmfsct2=projectmanager.getRjmfsctr2();
		ConnectionManager conn= new ConnectionManager();
		Connection con = conn.establishConnection();
		String sql = "insert into requirements.projectMamager(sector1,sector2,rjmfsct1 ,rjmfsct2)values(?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "softwareEnginners");
		ps.setString(2, "MechanicalEngineers");
		ps.setInt(3, 155);
		ps.setInt(4, 155);
		ps.executeUpdate();
		conn.closeConnection();


		
	}

}
