package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.manager.AgencyManager;
import gov.oit.storefrontweb.model.Agency;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestAgencyServlet extends HttpServlet {
	
	private Agency m_agency1;
	private Agency m_agency2;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		AgencyManager mgr = new AgencyManager();
		
		Setup();
		
		try {
		mgr.addAgency(m_agency1);
		mgr.addAgency(m_agency2);
		
		resp.getWriter().println("Test Agencies Added!");
		}
		
		catch (Exception e) {
			resp.getWriter().println(e.getMessage());
		}
	}
	
	private void Setup()
	{
		m_agency1 = new Agency("FAA");
        m_agency1.setAgencyName("Public Health and Environment");

		m_agency2 = new Agency("GFB");
        m_agency2.setAgencyName("CU Boulder");		
	}

	

}
