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
 * Servlet implementation class FinalEditDeleteVehicles
 */
@WebServlet("/FinalEditDeleteVehicles")
public class FinalEditDeleteVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteVehicles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String btn = request.getParameter("btn");
		int vid = Integer.parseInt(request.getParameter("vid"));
		if(btn.equals("Delete")){
			boolean st = VehiclesController.deleteRecord(vid);
			response.sendRedirect("DisplayAllVehicles");
		}
		else if(btn.equals("Edit")){
			Vehicles V = new Vehicles();
			V.setVehicleid(Integer.parseInt(request.getParameter("vid")));
			V.setEmployeeid(request.getParameter("eid"));
			V.setRfid_no(request.getParameter("rfid"));
			V.setReg_no(request.getParameter("reg"));
			V.setAmount(request.getParameter("amt"));
			V.setTime(request.getParameter("time"));
			V.setStatus(request.getParameter("status"));
			V.setFloorno(request.getParameter("flno"));
			V.setMobileno(request.getParameter("mobno"));
		
			boolean st = VehiclesController.editRecord(V);
			response.sendRedirect("DisplayAllVehicles");
		}
	}

}
