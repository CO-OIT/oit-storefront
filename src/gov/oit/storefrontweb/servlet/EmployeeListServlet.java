package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.manager.EmployeeManager;
import gov.oit.storefrontweb.model.Employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeListServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Create an instance of Employee Manager
		EmployeeManager mgr = new EmployeeManager();
		
		//Call the List Employee method from Employee Manager
		List<Employee> results = mgr.retrieveEmployeeList();
		
		//Return the list to the view
		req.setAttribute("employee", results);
	    req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
		
	}
	
	

}
