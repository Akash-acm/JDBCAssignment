package com.demo.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoJdbcImpl implements EmpDao {

	
	@Override
	public Emp findEmpById(int empId) {
		Emp emp = new Emp();
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from employee where empno=?");
			pst.setInt(1, empId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				emp.setEmpId(rs.getInt("EMPNO"));
				emp.setEmpName(rs.getString("NAME"));
				emp.setCity(rs.getString("ADDRESS"));
				emp.setSalary(rs.getDouble("SALARY"));

			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found..");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public String save(Emp e) {
		String message = "";
		Connection conn = null;

		try {
			conn = getConnection();

			PreparedStatement pst = conn
					.prepareStatement("insert into employee(empno,name,address,salary) values(?,?,?,?)");
			pst.setInt(1, e.getEmpId());
			pst.setString(2, e.getEmpName());
			pst.setString(3, e.getCity());
			pst.setDouble(4, e.getSalary());

			int count = pst.executeUpdate();

			message = "Emp saved successfully";

		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found..");
		} catch (SQLException ex) {
			ex.printStackTrace();
			message = "Emp could not be saved..";
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String update(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> listAll() {
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from employee");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpId(rs.getInt("EMPNO"));
				emp.setEmpName(rs.getString("NAME"));
				emp.setCity(rs.getString("ADDRESS"));
				emp.setSalary(rs.getDouble("SALARY"));
				empList.add(emp);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found..");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empList;
	}

	//
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sapientdb", "root", "akash@it");
		return conn;
	}

}