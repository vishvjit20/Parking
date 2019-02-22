package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.controller.VehiclesController;
import com.vj.model.Vehicles;

/**
 * Servlet implementation class VehicleSubmit
 */
@WebServlet("/VehicleSubmit")
public class VehicleSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Vehicles v = new Vehicles();
		v.setEmployeeid(request.getParameter("eid"));
		v.setRfid_no(request.getParameter("rfid"));
		v.setReg_no(request.getParameter("reg"));
		v.setEntrydate(request.getParameter("cdate"));
		v.setEntrytime(request.getParameter("ctime"));
		v.setAmount(request.getParameter("amt"));
		v.setTime(request.getParameter("time"));
		v.setStatus(request.getParameter("status"));
		v.setFloorno(request.getParameter("flno"));
		v.setMobileno(request.getParameter("mobno"));
		
		boolean st = VehiclesController.addNewVehicles(v);
		out.println("<html>");
		if(st){
			out.println("Vehicle data submitted.....");
		}
		else out.println("Failed to submit vehicle data.....");
		out.println("</html>");
		out.flush();
	}

}
