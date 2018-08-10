package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Employdao;
import dao.Employimpl;

@WebServlet("/employeerecord")
public class Employerecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Employerecord() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("employeerecord.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employdao edao = new Employimpl();
		
		try {
			ResultSet rs = edao.getEmployee();
			if(rs.wasNull()) {
				request.setAttribute("notsuccess", true);
				RequestDispatcher rd = request.getRequestDispatcher("employeerecord.jsp");
				rd.forward(request, response);
			}else if(rs.next()){
				String eid = rs.getString("eid");
				request.setAttribute("eid", eid);
				String name = rs.getString("name");
				request.setAttribute("name", name);
				String age = rs.getString("age");
				request.setAttribute("age", age);
				String salary = rs.getString("salary");
				request.setAttribute("salary", salary);
				String designation = rs.getString("designation");
				request.setAttribute("designation", designation);
				
				RequestDispatcher rd = request.getRequestDispatcher("employeerec.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}
}

