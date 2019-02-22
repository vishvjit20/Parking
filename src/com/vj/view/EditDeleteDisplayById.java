package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.controller.EmployeesController;
import com.vj.model.Employees;

/**
 * Servlet implementation class EditDeleteDisplayById
 */
@WebServlet("/EditDeleteDisplayById")
public class EditDeleteDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeleteDisplayById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html>");
		Employees E = EmployeesController.displayById(Integer.parseInt(request.getParameter("eid")));
		if(E!=null){
			out.println("<script src='/Parking/asset/jquery-2.2.1.min.js'></script>");
			out.println("<script src='/Parking/asset/statecity.js'></script>");
			out.println("<html>");
			out.println("<form action='FinalEditDeleteEmployee' method='post' enctype='multipart/form-data'>");
			out.println("<table><tr><td><table>");
		    out.println("<caption><b><i>Employee Register</i></b></caption>");
		    
		    out.println("<tr><td><b><i>Employee Id:</i></b></td>");
		    out.println("<td><input type='text' name='eid' value="+E.getEmployeeid()+"></td></tr>");
		    
		    out.println("<tr><td><b><i>Name:</i></b></td>");
		    out.println("<td><input type='text' name='en' value='"+E.getEmployeename()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Gender:</i></b></td>");
		    if(E.getGender().equals("Male"))
		    out.println("<td><input type='radio' name='eg' value='Male' checked>Male<input type='radio' name='eg' value='Female'>Female</td></tr>");
		    else out.println("<td><input type='radio' name='eg' value='Male'>Male<input type='radio' name='eg' value='Female' checked>Female</td></tr>");
		    
		    out.println("<tr><td><b><i>Birth Date:</i></b></td>");
		    out.println("<td><input type='date' name='edob' value='"+E.getDob()+"'></td></tr>");
		   
		    out.println("<tr><td><b><i>Address:</i></b></td>");
		    out.println("<td><textarea rows='3' cols='30' name='eadd'>"+E.getAddress()+"</textarea></td></tr>");
		   
		    String st[] = E.getState().split(",");
		    out.println("<input type='hidden' name='stateid' value='"+st[0]+"'>");
		    out.println("<tr><td><b><i>State:</i></b></td>");
		    out.println("<td><select name='estate' id='estate'></select>"+st[1]+"</td></tr>");
		    
		    String ct[] = E.getCity().split(",");
		    out.println("<input type='hidden' name='cityid' value='"+ct[0]+"'>");
		    out.println("<tr><td><b><i>City:</i></b></td>");
		    out.println("<td><select id='ecity' name='ecity'><option>-Select-</option></select>"+ct[1]+"</td></tr>");
		   
		   
		    out.println("<tr><td><b><i>Designation:</i></b></td>");
		    out.println("<td><input type='text' name='edes' value='"+E.getDesignation()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Salary:</i></b></td>");
		    out.println("<td><input type='number' name='esal' value='"+E.getSalary()+"'></td></tr>");
		   
		    out.println("<tr><td><b><i>Email:</i></b></td>");
		    out.println("<td><input type='email' name='email' value='"+E.getEmail()+"'></td></tr>");
		   
		    out.println("<tr><td><b><i>Mobile:</i></b></td>");
		    out.println("<td><input type='text' name='emobile' value='"+E.getMobileno()+"'></td></tr>");
		   
		    out.println("<tr><td><b><i>Password:</i></b></td>");
		    out.println("<td><input type='password' name='epwd' value='"+E.getPassword()+"'></td></tr>");
		   
		    out.println("</table></td>");
            out.println("<td><valign=top><img src='/Parking/images/"+E.getPicture()+"' width=300 height=300 ><br><br>Update Picture:<br><input type=file name=epic> &nbsp;&nbsp;&nbsp;<input type=submit name='btn' value='Edit Picture'></td></table>");
            out.println("<input type='submit' value='Edit' name='btn'>  <input type='Submit' value='Delete' name='btn'></form>");

		}else{
			out.println("Record not found.....");
		}
		out.println("</html>");
	}

}
