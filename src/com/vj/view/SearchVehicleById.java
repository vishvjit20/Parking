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
 * Servlet implementation class SearchVehicleById
 */
@WebServlet("/SearchVehicleById")
public class SearchVehicleById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleById() {
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
		out.println("<html><body background='/Parking/images/splatter.jpg'>");
		out.println("<form action='DisplayVehicleById'>");
		out.println("<center><br><br><br><br><br><table><caption><h3><u><i>Search Vehicle By ID </i></u></h3></caption><br><br>");
		out.println("<tr><td><b><i>Vehicle Id :</i></b></td><td><input type='text' name=vid size=30></td><td><input type=submit></td></tr>");
		out.println("</table></center></form></html>");
	}

}
