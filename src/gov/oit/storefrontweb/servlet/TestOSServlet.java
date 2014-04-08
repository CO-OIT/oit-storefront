package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.model.OperatingSystem;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestOSServlet extends HttpServlet {
	
	private OperatingSystem m_os1;
	private OperatingSystem m_os2;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
				
		Setup();
		
		try {
         m_os1.Save();
         m_os2.Save();
		
		resp.getWriter().println("Test Operating Systems Added!");
		}
		
		catch (Exception e) {
			resp.getWriter().println(e.getMessage());
		}
	}
	
	private void Setup()
	{
		m_os1 = new OperatingSystem("WIN07");
		m_os1.setOSName("Windows 7 Professional");
		m_os1.setVersion("SP2");
	
		m_os2 = new OperatingSystem("RHEL6");
		m_os2.setOSName("Red Hat Enterprise Linux 6");
		m_os2.setVersion("---");
					
	}

	

}
