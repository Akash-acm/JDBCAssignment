package com.demo.jdbc.dao;

public class MainApp {

	public static void main(String[] args) {
		EmpDao dao = new EmpDaoJdbcImpl();

	//	Emp emp = dao.findEmpById(105);
	//	System.out.println(emp);
		
		//String response=dao.save(new Emp(106, "Rajesh", "Pune", 65000));
		//System.out.println(response);
		for(Emp e:dao.listAll()) {
			System.out.println(e);
		}
	}

}