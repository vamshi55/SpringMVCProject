package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class Employimpl implements Employdao{

	@Override
	public Connection Createconnection() {
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pwd="postgres";
		
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(url, user, pwd);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public int saveEmployee(String eid, String name, String age, String salary, String designation)
			throws SQLException {
		Connection con=Createconnection();
		String sql="insert into employee (eid,name,age,salary,designation) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, eid);
		ps.setString(2, name);
		ps.setString(3, age);
		ps.setString(4, salary);
		ps.setString(5, designation);
		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public ResultSet getEmployee(int eid) throws SQLException {
Connection con = Createconnection();
		
		String sql = "select name,age,salary,designation from employee where eid =" + "'" +eid+ "'";
		
		Statement stm = con.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		return result;
	}

	@Override
	public ResultSet getEmployee() throws SQLException {
		Connection con = Createconnection();
		String sql = "select * from employee";
		
		Statement stm = con.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		return result;
	}

	
	
}
