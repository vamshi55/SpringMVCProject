package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface Employdao {
public Connection Createconnection();

public int saveEmployee(String eid,String name,String age,String salary,String designation) throws SQLException;

public ResultSet getEmployee(int eid) throws SQLException;
public ResultSet  getEmployee() throws SQLException;


}
