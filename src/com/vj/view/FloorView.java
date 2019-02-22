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
 * Servlet implementation class FloorView
 */
@WebServlet("/FloorView")
public class FloorView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorView() {
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
		out.println("<html>");
		out.println("<form action='FloorSubmit' method='post'><center><br>");
		out.println("<table><br><br><br><br><br><br><br><br><br><caption><h3><u><i>Floor Entry</h3></u></i></caption><br><br>");
		out.println("<tr><th>Floor name :</th><td><input type='text' name='flname'></td>");
		out.println("<tr><th>Total Spaces :</th><td><input type='text' name='space'></td></tr></table>");
		out.println("<br><br><input type=submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='reset'>");
	}

}
