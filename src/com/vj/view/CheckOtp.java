package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vj.controller.EmployeesController;
import com.vj.model.Employees;

/**
 * Servlet implementation class CheckOtp
 */
@WebServlet("/CheckOtp")
public class CheckOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOtp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String otp = request.getParameter("otp");
		String uotp = request.getParameter("uotp");
		System.out.println(otp+""+uotp);
		if(otp.equals(uotp)){
			Employees E = EmployeesController.displayById(Integer.parseInt(request.getParameter("id")));
			HttpSession ses = request.getSession();
			ses.putValue("EMPLOYEEID", E.getEmployeeid());
			ses.putValue("EMPLOYEENAME", E.getEmployeename());
			ses.putValue("EMPLOYEEPICTURE", E.getPicture());
			ses.putValue("LTIME", new Date());
			response.sendRedirect("EmployeeHome");
		}
		else{
			out.println("<html>Invalid Otp</html>");
		}
		
	}

}
