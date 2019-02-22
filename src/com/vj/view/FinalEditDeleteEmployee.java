package com.vj.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.vj.controller.EmployeesController;
import com.vj.model.Employees;

/**
 * Servlet implementation class FinalEditDeleteEmployee
 */
@WebServlet("/FinalEditDeleteEmployee")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize = 1024*1024*50)
public class FinalEditDeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteEmployee() {
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
		int eid = Integer.parseInt(request.getParameter("eid"));
		if(btn.equals("Delete")){
			boolean st = EmployeesController.deleteRecord(eid);
			response.sendRedirect("DisplayAllEmployees");
		}
		else if(btn.equals("Edit")){
			Employees E = new Employees();
			E.setEmployeeid(Integer.parseInt(request.getParameter("eid")));
			E.setEmployeename(request.getParameter("en"));
			E.setGender(request.getParameter("eg"));
			E.setDob(request.getParameter("edob"));
			E.setAddress(request.getParameter("eadd"));
			
			if(request.getParameter("estate").equals("-Select-") && request.getParameter("ecity").equals("-Select-")){
				E.setState(request.getParameter("stateid"));
				E.setCity(request.getParameter("cityid"));
			}
			else{
				E.setState(request.getParameter("estate"));
				E.setCity(request.getParameter("ecity"));
			}
			E.setDesignation(request.getParameter("edes"));
			E.setSalary(request.getParameter("esal"));
			E.setEmail(request.getParameter("email"));
			E.setMobileno(request.getParameter("emobile"));
			E.setPassword(request.getParameter("epwd"));
			boolean st = EmployeesController.editRecord(E);
			response.sendRedirect("DisplayAllEmployees");
		}
		else if(btn.equals("Edit Picture")){
			Part P = request.getPart("epic");
			FileUpload f = new FileUpload(P,"E:/Parking/WebContent/images");
			boolean st = EmployeesController.editPicture(eid, f.filename);
			response.sendRedirect("DisplayAllEmployees");
		}
	}

}
