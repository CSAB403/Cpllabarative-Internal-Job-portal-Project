package ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	Connection con = null;

	
	public Connection establishConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println(Class.forName(null));

		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/requirements","root","root");
		System.out.println(con);
		if(con!=null)
		{
			System.out.println("connection created");
		}
		else
		{
			System.out.println("connection not created");
		}
		return con;
	}

	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		con.close();
	}

}
