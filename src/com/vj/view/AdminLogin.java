package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body background='/Parking/images/white.jpg'><form action=CheckAdminLogin method='post'><center>");
		out.println("<table><br><br><br><br><br><br><br><br><br><br><br><caption><b><i>Admin Login</i></b></caption>");
		out.println("<tr><td><b><i>Admin Id :</td><td><input type='text' name='id'></td></tr>");
		out.println("<tr><td><b><i>Password :</i></b></td><td><input type='password' name='password'</td></tr>");
		out.println("</table><br><br>");
		out.println("<input type=submit value='Login'></html>");
		out.flush();
	}

}
