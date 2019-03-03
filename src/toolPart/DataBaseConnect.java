package toolPart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnect 
{
	Connection con;
	 public DataBaseConnect() 
	{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scorectrl";
		String user = "root";
		String password = "8591352000";
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con.isClosed())
				System.out.println("数据库连接失败!");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public Connection getConnection()
	{
		return con;
	}
}
