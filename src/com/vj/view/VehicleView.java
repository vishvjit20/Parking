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

/**
 * Servlet implementation class VehicleView
 */
@WebServlet("/VehicleView")
public class VehicleView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleView() {
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
		out.println("<script src='/Parking/asset/floor.js'></script>");
		out.println("<html>");
	    
		/**String rfid_no = VehiclesController.ReadRFID();
		if(rfid_no.length() == 12) out.println("<meta http-equiv=\"refresh\" content=\"-10\">");
		else out.println("<meta http-equiv=\"refresh\" content=\"10\">");*/
		
		out.println("<body background='/Parking/images/splatter.jpg'><form action='VehicleSubmit' method='post'><center><br><br><br><br><br>");
		out.println("<table><caption><h3><u><i>Vehicle Registration</i></u></h3></caption><br><br>");
		
		out.println("<tr><td><b><i>Employee Id:</i></b></td>");
	    out.println("<td><input type='text' name='eid' value="+ses.getValue("EMPLOYEEID")+"></td></tr>");
	    
	    out.println("<tr><td><b><i>RFID No.:</i></b></td>");
	    out.println("<td><input type='text' name='rfid'></td></tr>");
	    
	    out.println("<tr><td><b><i>Registration No.:</i></b></td>");
	    out.println("<td><input type='text' name='reg'></td></tr>");
	    
	    out.println("<tr><td><b><i>Mobile No.:</i></b></td>");
	    out.println("<td><input type='text' name='mobno'></td></tr>");
	    Calendar C=Calendar.getInstance();
	    String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
	    String ct=C.get(Calendar.HOUR)+":"+(C.get(Calendar.MINUTE))+":"+C.get(Calendar.SECOND)+" "+C.get(Calendar.AM_PM);
	    out.println("<tr><td><b><i>Current date:</i></b></td>");
	    out.println("<td><input type='text' name='cdate' value="+cd+"></td></tr>");
	    
	    out.println("<tr><td><b><i>Current time:</i></b></td>");
	    out.println("<td><input type='text' name='ctime' value="+ct+"></td></tr>");
	    
	    out.println("<tr><td><b><i>Amount:</i></b></td>");
	    out.println("<td><input type='text' name='amt' value='30'></td></tr>");
	    
	    out.println("<tr><td><b><i>Time:</i></b></td>");
	    out.println("<td><select name='time'><option value='1 hr'>1 hr</option><option value='2 hr'>2 hr</option><option selected value='3 hr'>3 hr</option><option value='4 hr'>4 hr</option></select></td></tr>");
	    
	    out.println("<tr><td><b><i>Status:</i></b></td>");
	    out.println("<td><select name='status'><option selected value='IN'>IN</option><option value='OUT'>OUT</option></select>");
	    
	    out.println("<tr><td valign='top'><b><i>Floor No:</i></b></td>");
	    out.println("<td><select name='flno' id='flno'></select><br><div id='fdiv'></div></td></tr>");
	    
	    out.println("</table><br><br>");
	    out.println("<input type='submit'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='Reset'></form></table>");
	    out.flush();
        
	}
}
