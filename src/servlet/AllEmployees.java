package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Employdao;
import dao.Employimpl;


@WebServlet("/allemployee")
public class AllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("employeerecord.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid = request.getParameter("eid");
		
		
		Employdao edao = new Employimpl();
		
		List l=null;
		
		try {
			ResultSet rs = edao.getEmployee();
			l=new ArrayList();
			while(rs.next()) {
				Employee e=new Employee();
		    	String id=rs.getString("id");
		    	e.setId(id);
		    	String name = rs.getString("name");
		    	e.setName(name);
		    	String age = rs.getString("age");
		    	e.setAge(age);
		    	String salary = rs.getString("salary");
		    	e.setSalary(salary);
		    	String designation = rs.getString("designation");
		    	e.setDesignation(designation);
			}	}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
	}
		request.setAttribute("list", l);
		RequestDispatcher rd=request.getRequestDispatcher("allemployeedetails.jsp");
		rd.forward(request, response);
}}
