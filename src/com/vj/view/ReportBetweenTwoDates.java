package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReportBetweenTwoDates
 */
@WebServlet("/ReportBetweenTwoDates")
public class ReportBetweenTwoDates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportBetweenTwoDates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		try{
			String nv="Employee Id:"+ses.getValue("EMPLOYEEID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("EMPLOYEENAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"<img/src='/Parking/images/"+ses.getValue("PICTURE")+"' width=30 height=30>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='EmployeeLogOut'>Logout</a><hr color=red>";
		}catch(Exception e){
			response.sendRedirect("EmployeeLogin");
		}
		out.println("<script src='/Parking/asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='/Parking/asset/vehicleReport.js'></script>");
		out.println("<html>");
		out.println("<table><caption><h3><u>Search Vehicle Between Two Dates</u></h3></caption><br><br><br>");
		out.println("<tr><td>Date From :</td><td><input type='date' id='datefrom'></td>");
		out.println("<td>Date To :</td><td><input type='date' id='dateto'></td>");
		out.println("<td><input type='button' id=btn value='Search'></td></tr></table>");
		out.println("<div id='result'></div>");
		out.println("</html>");
	}

}
