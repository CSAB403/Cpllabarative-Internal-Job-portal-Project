package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import Model.Requirements;

public class RequirementsDAO {
	public boolean validate(Requirements requirements) throws SQLException, ClassNotFoundException
	
	{
		int n = requirements.getN();
		ConnectionManager conn = new ConnectionManager();
		Connection con = conn.establishConnection();
	//	Connection con = conn.establishConnection();
    	System.out.println(conn);
    	Statement st = con.createStatement();
    	System.out.println(st);
    	ResultSet rs =st.executeQuery("select number_of_postings from requirements.requirementsEmp");
    	while(rs.next())
    	{
    		//if((n>=400)&& (n<=500))
    		if(n==(rs.getInt("number_of_postings"))&& (n<=(rs.getInt("number_of_postings"))))
    		{
				 
    			System.out.println("number of job requirements Approved");
				 conn.closeConnection();

    			return true;
    		}
    		else
    		{
    			System.out.println("Please enter the exact  required project members");
    		}
    	}
		 conn.closeConnection();

		return false;
		
	}

}
