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


@WebServlet("/employeedetailsform")
public class Employedetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Employedetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("employeedetailsform.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int eid  =Integer.parseInt( request.getParameter("eid"));
		
		Employdao edao = new Employimpl();
		
		try {
			ResultSet rs = edao.getEmployee(eid);
			if(rs.wasNull()) {
				request.setAttribute("notsuccess", true);
				RequestDispatcher rd = request.getRequestDispatcher("employeedetailsform.jsp");
				rd.forward(request, response);
			}else if(rs.next()){
				String name = rs.getString("name");
				request.setAttribute("name", name);
				int age =rs.getInt("age");
				request.setAttribute("age", age);
				double salary=rs.getDouble("salary");
				request.setAttribute("salary",salary);
				String designation=rs.getString("designation");
				request.setAttribute("designation",designation);
				RequestDispatcher rd = request.getRequestDispatcher("employeedetails.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	}

