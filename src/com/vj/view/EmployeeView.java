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
 * Servlet implementation class EmployeeView
 */
@WebServlet("/EmployeeView")
public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeView() {
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
			String nv="Admin Id:"+ses.getValue("ADMINID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("ADMINNAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"<img/src='/Parking/images/"+ses.getValue("APICTURE")+"' width=30 height=30>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='AdminLogOut'>Logout</a><hr color=red>";
		}catch(Exception e){
			response.sendRedirect("AdminLogin");
		}
		out.println("<script src='/Parking/asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='/Parking/asset/statecity.js'></script>");
		out.println("<html>");
		out.println("<form action='EmployeeSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<center><table><br><br><br>");
	    out.println("<caption><h3><u><i>Employee Register</i></u></h3></caption><br><br>");
	    
	   /* out.println("<tr><td><b><i>Employee Id:</i></b></td>");
	    out.println("<td><input type='text' name='eid'></td></tr>");
	    */
	    out.println("<tr><td><b><i>Name:</i></b></td>");
	    out.println("<td><input type='text' name='en'></td></tr>");
	    
	    out.println("<tr><td><b><i>Gender:</i></b></td>");
	    out.println("<td><input type='radio' name='eg' value='Male'>Male<input type='radio' name='eg' value='Female'>Female</td></tr>");
	    
	    out.println("<tr><td><b><i>Birth Date:</i></b></td>");
	    out.println("<td><input type='date' name='edob'></td></tr>");
	   
	    out.println("<tr><td><b><i>Address:</i></b></td>");
	    out.println("<td><textarea rows='3' cols='30' name='eadd'></textarea></td></tr>");
	   
	    out.println("<tr><td><b><i>State:</i></b></td>");
	    out.println("<td><select name='estate' id='estate'></select></td></tr>");
	    
	    out.println("<tr><td><b><i>City:</i></b></td>");
	    out.println("<td><select id='ecity' name='ecity'><option>-Select-</option></select></td></tr>");
	   
	   
	    out.println("<tr><td><b><i>Designation:</i></b></td>");
	    out.println("<td><input type='text' name='edes'></td></tr>");
	    
	    out.println("<tr><td><b><i>Salary:</i></b></td>");
	    out.println("<td><input type='number' name='esal'></td></tr>");
	   
	    out.println("<tr><td><b><i>Email:</i></b></td>");
	    out.println("<td><input type='email' name='email'></td></tr>");
	   
	    out.println("<tr><td><b><i>Mobile:</i></b></td>");
	    out.println("<td><input type='text' name='emobile'></td></tr>");
	   
	    out.println("<tr><td><b><i>Picture:</i></b></td>");
	    out.println("<td><input type='file' name='epic'></td></tr>");
	    
	    out.println("<tr><td><b><i>Password:</i></b></td>");
	    out.println("<td><input type='password' name='epwd'></td></tr>");
	   
	    out.println("</table><br><br>");
	    out.println("<input type='submit'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='Reset'></form></table>");
	    
	    out.flush();
	}

}
