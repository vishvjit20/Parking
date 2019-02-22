package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.controller.FloorController;
import com.vj.model.Floors;

/**
 * Servlet implementation class FloorSubmit
 */
@WebServlet("/FloorSubmit")
public class FloorSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Floors F = new Floors();
		F.setFloorname(request.getParameter("flname"));
		F.setTotalspace(request.getParameter("space"));
		boolean st = FloorController.addNewFloor(F);
		out.println("<html>");
		if(st){
			out.println("Record Submitted.....");
		}
		else out.println("Failed to submit record.....");
		out.println("</html>");
		out.flush();
	}

}
