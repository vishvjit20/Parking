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
 * Servlet implementation class DisplayVehicleByRfid
 */
@WebServlet("/DisplayVehicleByRfid")
public class DisplayVehicleByRfid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayVehicleByRfid() {
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
		out.println("<script src='/Parking/asset/vehicle.js'></script>");
		out.println("<html><body background='/Parking/images/splatter.jpg'><center><br><br><br><br><br><br>");
		out.println("<table><caption><h3><u><i>Search Vehicle by Rfid...</i></u></h3></caption>");
		out.println("<tr><td>RFID No :</td>");
		out.println("<td><input type='text' id='rfid'></td><td><input type=button id='btn' value='Search'></td></td>");
		out.println("</table>");
		
		out.println("<div id='result'></div>");
		out.println("</html>");
	}

}
