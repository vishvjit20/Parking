package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.controller.EmployeesController;
import com.vj.model.Employees;

/** 
 * Servlet implementation class EmployeeLogin
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><form action='CheckEmployeesLogin' method='post'><center>");
		out.println("<body background='/Parking/images/white.jpg'>");
		
		out.println("<table><br><br><br><br><br><br><br><br><br><br><br><br><caption><b><i>Employee Login</i></b></caption>");
		out.println("<tr><td><b><i>Employee id :</i></b></td><td><input type='text' name='eid'</td></tr>");
		out.println("<tr><td><b><i>Password :</i></b></td><td><input type='password' name='password'></td></tr>");
		out.println("</table><br><br>");
		out.println("<input type=submit value='Login' name='btn'>&nbsp;<input type=submit value='Login with OTP' name='btn'>");
		out.println("</html>");
		out.flush();
	}

}
