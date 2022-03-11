package com.demo.jdbc.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args)  {
		Connection conn=null;
		// load the driver
		
		try{Class.forName("org.mariadb.jdbc.Driver");
		//get the connection
		conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/sapientdb","root","akash@it");
	//query to insert data
	//PreparedStatement pst=conn.prepareStatement("insert into Customer(custId,custName,address,accountNo,balance) values (?,?,?,?,?)"); 
	//query to update
		PreparedStatement pst=conn.prepareStatement("update Customer set accountNo=? where custId=?");
		pst.setInt(4, 203);
		pst.setInt(1,101);
	//pst.setString(2, "Mukesh");
	//pst.setString(3, "GGN");
	
	//pst.setDouble(5, 760000);
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
