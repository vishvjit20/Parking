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

import com.vj.controller.FloorController;
import com.vj.dao.DbHelper;

/**
 * Servlet implementation class FetchAllFloorsJSON
 */
@WebServlet("/FetchAllFloorsJSON")
public class FetchAllFloorsJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAllFloorsJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ResultSet rs = FloorController.fetchAllFloors();
		ArrayList<JSONObject> obj = DbHelper.JsonEngine(rs);
		out.println(obj);
	}

}
