package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connectionutil {
	
	public static Connection getconnection() {
		
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");   // load the class
			String url="jdbc:oracle:thin:@localhost:1521:XE";    // get the connection
			connection = DriverManager.getConnection(url,"hr","hr");
			System.out.println(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
}
	
	public static void close(Connection conn, PreparedStatement stmt,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}