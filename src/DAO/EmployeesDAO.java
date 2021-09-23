package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import Model.Employees;

public class EmployeesDAO {
	public void addDetails1(Employees employees) throws SQLException, ClassNotFoundException {
		 String  First_name = employees.getFirst_name();
		 
		  String  Last_name = employees.getLast_name();
		 
		 String  University_name = employees.getUniversity_name();
		 
		  String  college_name = employees.getCollege_name();

		  int  passed_out_year = employees.getPassed_out_year();

		  String  branch_name = employees.getBranch_name();
		  
		  String e_mail = employees.getE_mail();
		 
		  String  gap = employees.getGap();
		  ConnectionManager conn = new ConnectionManager();
		  Connection con = conn.establishConnection();
		  Statement st = con.createStatement();
		  String sql = "insert into  requirements.Employee(First_name,Last_name,University_name,College_name,passed_out_year,branch_name,gap,e_mail)values(?,?,?,?,?,?,?,?)";
		  PreparedStatement ps =  con.prepareStatement(sql);
		  ps.setString(1, First_name);
		  ps.setString(2, Last_name);
		  ps.setString(3, University_name );
		  ps.setString(4,college_name );
		  ps.setInt(5,passed_out_year );
		  ps.setString(6,branch_name );
		  ps.setString(7,gap );
		  ps.setString(8,e_mail );
		  ps.executeUpdate();
		  conn.closeConnection();


		 
	}
	public void Display() throws SQLException, ClassNotFoundException
	{
		ConnectionManager conn=new ConnectionManager();
		Connection con=  conn.establishConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select *from requirements.Employee");
		String sql1="display from requirements.Employee(ps.setString,ps.setString,ps.setString,ps.setString,ps.setInt,  ps.setString,ps.setString,ps.setString)";
		while(rs.next())
		{
			String First_name = rs.getString("First_name");
			String Last_name = rs.getString("Last_name");
			String University_name= rs.getNString("University_name");
			String  College_name= rs.getNString("College_name");
			int  passed_out_year= rs.getInt("passed_out_year");
			String branch_name = rs.getString("branch_name");
			String gap= rs.getString("gap");
			String e_mail = rs.getString("e_mail");
			System.out.println("First_name:" + First_name+ "Last_name:" + Last_name +  "University_name:" + University_name + "College_name:" + College_name +   "passed_out_year:" + passed_out_year +"branch_name:" + branch_name+ "gap:" + gap+ "e_mail:" + e_mail);
			//conn.closeConnection();
		}conn.closeConnection();
		
		
	}
}
