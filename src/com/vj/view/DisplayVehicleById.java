package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vj.controller.VehiclesController;
import com.vj.model.Vehicles;

/**
 * Servlet implementation class DisplayVehicleById
 */
@WebServlet("/DisplayVehicleById")
public class DisplayVehicleById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayVehicleById() {
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
			String nv="Employee Id:"+ses.getValue("EMPLOYEEID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("EMPLOYEENAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img/src='/Parking/images/"+ses.getValue("PICTURE")+"' width=30 height=30>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='EmployeeLogOut'>Logout</a><hr color=red>";
		}catch(Exception e){
			response.sendRedirect("AdminLogin");
		}
		out.println("<html><body background='/Parking/images/splatter.jpg'>");
		Vehicles V = VehiclesController.dislayVehicleById(Integer.parseInt(request.getParameter("vid")));
		if(V!=null){
			out.println("<form action = 'FinalEditDeleteVehicles' method='post'>");
			out.println("<table><caption><b><i>[Edit/Delete] Vehicle Record</i></b></caption>");
			
			out.println("<tr><td><u><h3><i>Vehicle Id:</i></u></h3></td><br><br>");
		    out.println("<td><input type='text' name='vid' value='"+V.getVehicleid()+"'></td></tr>");
			
			out.println("<tr><td><b><i>Employee Id:</i></b></td>");
		    out.println("<td><input type='text' name='eid' value='"+V.getEmployeeid()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>RFID No.:</i></b></td>");
		    out.println("<td><input type='text' name='rfid' value='"+V.getRfid_no()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Registration No.:</i></b></td>");
		    out.println("<td><input type='text' name='reg' value='"+V.getReg_no()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Amount:</i></b></td>");
		    out.println("<td><input type='text' name='amt' value='30'></td></tr>");
		    
		    out.println("<tr><td><b><i>Time:</i></b></td>");
		    out.println("<td><select name='time'><option value='1 hr'>1 hr</option><option value='2 hr'>2 hr</option><option selected value='3 hr'>3 hr</option><option value='4 hr'>4 hr</option></select></td></tr>");
		    
		    out.println("<tr><td><b><i>Status:</i></b></td>");
		    out.println("<td><select name='status'><option selected value='IN'>IN</option><option value='OUT'>OUT</option></select>");
		    
		    out.println("<tr><td><b><i>Floor No:</i></b></td>");
		    out.println("<td><input type ='text' name='flno' value='"+V.getFloorno()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Mobile No :</i></b></td>");
		    out.println("<td><input type='text' name='mobno' value='"+V.getMobileno()+"'></td></tr>");
		    
		    out.println("</table><br><br>");
		    out.println("<input type='submit' value='Edit' name='btn'>  <input type='submit' value='Delete' name='btn'></form></table>");
		}else{
			out.println("Record not found .....");
		}
	}

}
