package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.manager.EmployeeManager;
import gov.oit.storefrontweb.model.AppInfoDetail;
import gov.oit.storefrontweb.model.Employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunbookServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Create an instance of AppInfoDetail
		AppInfoDetail detail = new AppInfoDetail();
		
		//Call the list of application architecture types for dropdown
		List<AppInfoDetail> appar  = detail.listForHeadingType("APPAR");
		
		//Return the list to the view
		req.setAttribute("appar", appar);
	    req.getRequestDispatcher("RunBook.jsp").forward(req, resp);
	}
	
	
	
	
	
}
