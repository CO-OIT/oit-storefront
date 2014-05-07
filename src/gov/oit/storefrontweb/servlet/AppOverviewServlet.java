package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.manager.DropDownInfo;
import gov.oit.storefrontweb.manager.ddAppPortfolio;
import gov.oit.storefrontweb.manager.ddFunctionalServiceGroup;
import gov.oit.storefrontweb.manager.ddHostOS;
import gov.oit.storefrontweb.manager.ddRemoteGateway;
import gov.oit.storefrontweb.manager.ddWebPlatform;
import gov.oit.storefrontweb.model.AppInfoDetail;
import gov.oit.storefrontweb.model.DropdownInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppOverviewServlet extends HttpServlet {
	
	static final long serialVersionUID = 9999991; 
	
	
    List<DropdownInfo> _ddFunctionalServiceGroup;
    List<DropdownInfo> _ddAgency;
    List<DropdownInfo> _ddServiceCategory;
    List<DropdownInfo> _ddAppPortfolio;
    List<DropdownInfo> _ddAppPriority;
    List<DropdownInfo> _ddAppArchitecture;
    List<DropdownInfo> _ddWebPlatform;
    List<DropdownInfo> _ddAppPlatform;
    List<DropdownInfo> _ddUserLANClass;
    List<DropdownInfo> _ddRemoteGateway;
    List<DropdownInfo> _ddServerPlatform;
    List<DropdownInfo> _ddHypervisor;
    List<DropdownInfo> _ddHostOS;
    List<DropdownInfo> _ddGuestOS;
	
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		PrintWriter toClient = resp.getWriter();
		String frmActionString = (String)req.getParameter("yucko");
		
	       //Open the file for writing the survey results.


    // Respond to client with a thank you
		toClient.println("<html>");
		toClient.println("<title>Thank you!</title>");
        toClient.println("Thank you for participating");
        toClient.println("you picked " + frmActionString);
        toClient.println("</html>");
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String id = req.getParameter("id");
		
		//Is this a new record?
        if (null == id || id.trim() == "") {
        	
        }
		
		//Is this be update, yo?
        else {
        	
        }
		
		
		//Create an instance of AppInfoDetail
		AppInfoDetail detail = new AppInfoDetail();
		
		//Call the list of application architecture types for dropdown
		//List<AppInfoDetail> appar  = detail.listForHeadingType("APPAR");
		
		//Return the list to the view
		//req.setAttribute("appar", appar);
		
		String id = request.getParameter("id");
		Note note = noteService.find(id);
		request.setAttribute("note", note);
		request.getRequestDispatcher("/WEB-INF/showdetails.jsp").forward(request, response);
		
		
	    req.getRequestDispatcher("RunBook.jsp").forward(req, resp);
	}
	
	
	
	private HttpServletResponse createNewAppOverview() {
		
	}
	
	private HttpServletResponse createEditForm() {
		
	}
	
	private void assignDropdownInfo() {
			  
//			  ddFunctionalServiceGroup
//			  ddAgency
//			  ddServiceCategory
//			  ddAppPortfolio
//			  ddAppPriority
//			  ddAppArchitecture
//			  ddWebPlatform
//			  ddAppPlatform
//			  ddUserLANClass
//			  ddRemoteGateway
//			  ddServerPlatform
//			  ddHypervisor
//			  ddHostOS
//			  ddGuestOS
		
       //Get all app info details as list
		
	  // Break list into subgroups
		
		for (Fakenbake item : baseList) {
			
			switch (item.get_cat()) {
			
			case "CAT1":
				_cat1.add(revisedEntry(item));
				break;
				
			case "CAT2":
				_cat2.add(revisedEntry(item));
				break;
				
			case "CAT3":
				_cat3.add(revisedEntry(item));
				break;
				
			case "CAT4":
				_cat4.add(revisedEntry(item));
				break;
				
			default:
				//Log error.
				break;			
			}
		}

	}
	
	import java.util.ArrayList;
	import java.util.List;


	public class ListParser {

		private List<Fakenbake> _cat1;
		private List<Fakenbake> _cat2;
		private List<Fakenbake> _cat3;
		private List<Fakenbake> _cat4;
	    private List<Integer> _inList;
		
		private void setup() {
			
			_inList = new ArrayList<Integer>();
			_inList.add(1);
			_inList.add(6);
			_inList.add(9);
			_inList.add(12);
			
			_cat1 = new ArrayList<Fakenbake>();
			_cat2 = new ArrayList<Fakenbake>();
			_cat3 = new ArrayList<Fakenbake>();
			_cat4 = new ArrayList<Fakenbake>();
			
			List<Fakenbake> baseList = makeList();
			
			for (Fakenbake item : baseList) {
				
				switch (item.get_cat()) {
				
				case "CAT1":
					_cat1.add(revisedEntry(item));
					break;
					
				case "CAT2":
					_cat2.add(revisedEntry(item));
					break;
					
				case "CAT3":
					_cat3.add(revisedEntry(item));
					break;
					
				case "CAT4":
					_cat4.add(revisedEntry(item));
					break;
					
				default:
					//Log error.
					break;			
				}
			}
		}
		
		private void printEm() {
			
			System.out.println("CAT1");
			
			for (Fakenbake item : _cat1) {
		       printFormat(item);		
			}
			
			System.out.println("CAT2");
			
			for (Fakenbake item : _cat2) {
			    printFormat(item);		
			}
			
			System.out.println("CAT3");
			
			for (Fakenbake item : _cat3) {
			    printFormat(item);		
			}
			
			System.out.println("CAT4");
			
			for (Fakenbake item : _cat4) {
			    printFormat(item);		
			}
		}
		
		private void printFormat(Fakenbake f) {
			System.out.println(String.format("%s: %s --> %s", f.get_key(), f.get_desc(), f.get_selected()));
		}
		
		private Fakenbake revisedEntry(Fakenbake baseEntry) {
			
			Fakenbake f = null;
			Boolean selected = _inList.contains(baseEntry.get_key()) ? true : false; 
			
			f = new Fakenbake(baseEntry.get_key(), baseEntry.get_desc(), baseEntry.get_cat(), selected);
			
			return f;
		}
		
		
		private List<Fakenbake> makeList() {
			
			List<Fakenbake> list = new ArrayList<Fakenbake>();
			
			list.add(new Fakenbake( 0, "CAT1-D1", "CAT1", false));
			list.add(new Fakenbake( 1, "CAT1-D2", "CAT1", false));
			list.add(new Fakenbake( 2, "CAT1-D3", "CAT1", false));
			list.add(new Fakenbake( 3, "CAT1-D4", "CAT1", false));
			list.add(new Fakenbake( 4, "CAT2-D1", "CAT2", false));
			list.add(new Fakenbake( 5, "CAT2-D2", "CAT2", false));
			list.add(new Fakenbake( 6, "CAT2-D3", "CAT2", false));
			list.add(new Fakenbake( 7, "CAT2-D4", "CAT2", false));
			list.add(new Fakenbake( 8, "CAT3-D1", "CAT3", false));
			list.add(new Fakenbake( 9, "CAT3-D2", "CAT3", false));
			list.add(new Fakenbake( 10, "CAT3-D3", "CAT3", false));
			list.add(new Fakenbake( 11, "CAT3-D4", "CAT3", false));
			list.add(new Fakenbake( 12, "CAT4-D1", "CAT4", false));
			list.add(new Fakenbake( 13, "CAT4-D2", "CAT4", false));
			list.add(new Fakenbake( 14, "CAT4-D3", "CAT4", false));
			list.add(new Fakenbake( 15, "CAT4-D4", "CAT4", false));
					
			return list;
		}
		
		public void run() {
			setup();
			printEm();
		}
		
	}

	
	
	
	
	
}
