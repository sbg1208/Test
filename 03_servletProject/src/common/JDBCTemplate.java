package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemplate {
private static Connection conn;
	
	public static Connection getConnection()
	{
		conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
			conn.setAutoCommit(false);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn)
	{
		try
		{
			if(!conn.isClosed()&&conn!=null)
			{
					conn.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt)
	{
		try
		{
			if(!stmt.isClosed()&&stmt!=null)
			{
					stmt.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs)
	{
		try
		{
			if(!rs.isClosed()&&rs!=null)
			{
					rs.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn)
	{
		try
		{
			if(!conn.isClosed()&&conn!=null)
			{
					conn.commit();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn)
	{
		try
		{
			if(!conn.isClosed()&&conn!=null)
			{
					conn.rollback();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
