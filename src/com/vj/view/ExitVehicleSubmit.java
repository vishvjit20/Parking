package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vj.controller.ExitVehiclesController;
import com.vj.controller.VehiclesController;
import com.vj.model.ExitVehicles;

/**
 * Servlet implementation class ExitVehicleSubmit
 */
@WebServlet("/ExitVehicleSubmit")
public class ExitVehicleSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitVehicleSubmit() {
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
		HttpSession ses = request.getSession();
		try{
			ExitVehicles V = new ExitVehicles();
			V.setEmployeeid(Integer.parseInt(ses.getValue("EMPLOYEEID").toString()));
			V.setVehicleid(Integer.parseInt(request.getParameter("vid")));
			V.setExitdate(request.getParameter("exitdate"));
			V.setExittime(request.getParameter("exittime"));
			boolean st = ExitVehiclesController.addNewRecord(V);
			if(st){
				st = VehiclesController.updateStatus(V.getVehicleid());
				response.sendRedirect("DisplayVehicleByRfid");
			}
			else{
				out.println("Failed to submit record...");
			}
		}catch(Exception e){
			response.sendRedirect("EmployeeLogin");
		}
	}

}
