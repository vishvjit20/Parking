package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vj.controller.VehiclesController;

/**
 * Servlet implementation class DisplayAllVehicles
 */
@WebServlet("/DisplayAllVehicles")
public class DisplayAllVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllVehicles() {
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
			response.sendRedirect("EmployeeHome");
		}
		try{
	    ResultSet rs = VehiclesController.displayAllVehicles();
	    if(rs.next()){
		out.println("<html><body background='/Parking/images/white.jpg'><center><table border = 1 width=50% bgcolor='white'><br>");
		out.println("<caption><h3><u><i>Display All Vehicles</i></u></h3></caption><br><br><br>");
		out.println("<tr><th>Employee id </th><th>Rfid no /<br>Registration no</th><th>Entry date /<br>Entry time</th><th>Amount</th><th>Time</th><th>Status</th><th>Floor</th><th>Mobile no</th><th>Update</th></tr>");
	    do{
	    	out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"<br>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(11)+"</td><td><a href = DisplayVehicleById?vid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
	    }while(rs.next());}
		}catch(Exception e){
    	}
	}
}