package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {

	public static void main(String[] args)  {
		Connection conn=null;
		// load the driver
		
		try{Class.forName("org.mariadb.jdbc.Driver");
		//get the connection
		conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/sapientdb","root","akash@it");
	//query to create data
	PreparedStatement pst=conn.prepareStatement("update employee set salary=? where empno=?"); 
	pst.setDouble(1,90000);
	pst.setInt(2, 103);
	
	int count=pst.executeUpdate();
			System.out.println("Rows updated : "+count);
		//	pst.executeQuery("select * from employee");
	}catch(ClassNotFoundException e) {
		System.out.println("Driver not found...");
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}}
