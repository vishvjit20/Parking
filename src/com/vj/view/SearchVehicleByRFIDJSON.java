package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.vj.controller.VehiclesController;
import com.vj.dao.DbHelper;

/**
 * Servlet implementation class SearchVehicleByRFIDJSON
 */
@WebServlet("/SearchVehicleByRFIDJSON")
public class SearchVehicleByRFIDJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleByRFIDJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try{
			ResultSet rs = VehiclesController.displayByRfid(request.getParameter("rfid"));
			if(!rs.isBeforeFirst()){
				JSONObject obj = new JSONObject();
				obj.put("Message", "Vehicle not exist");
				out.println(obj);
			}
			else{
				ArrayList<JSONObject> obj = DbHelper.JsonEngine(rs);
				out.println(obj);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
