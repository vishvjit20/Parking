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

import com.vj.controller.EmployeesController;

/**
 * Servlet implementation class DisplayAllEmployees
 */
@WebServlet("/DisplayAllEmployees")
public class DisplayAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmployees() {
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
		try{
			out.println("<html>");
			ResultSet rs = EmployeesController.displayAll();
			if(rs.next()){
				out.println("<center><table border=1 width=80%><br>");
				out.println("<caption><h3><u><i>List of Employees</i></u></b></caption><br><br>");
				out.println("<tr><th>Employee</th><th>Gender/<br>Birth Date</th><th>Address</th><th>Designation</th><th>Salary</th><th>Contact/<br>Info</th><th>Update</th></tr>");
				do{
					out.println("<tr><td>"+rs.getString(2)+"<br><img src='/Parking/images/"+rs.getString(12)+"' width=25 height=25<br>"+rs.getString(1)+"</td><td>"+rs.getString(3)+"<br>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(13)+","+rs.getString(14)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td><td><a href=EditDeleteDisplayById?eid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
				}while(rs.next());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
