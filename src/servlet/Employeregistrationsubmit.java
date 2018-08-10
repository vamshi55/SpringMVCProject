package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Employdao;
import dao.Employimpl;


@WebServlet("/register")
public class Employeregistrationsubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Employeregistrationsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String eid = request.getParameter("eid");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String designation = request.getParameter("designation");
		Employdao edao=new Employimpl();
	
		int savedao = 0 ;
		try {
			 savedao = edao.saveEmployee(eid, name, age, salary, designation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
	if(savedao == 1) {
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("notsuccess", true);
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);			
			}
	}
	}


