package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.manager.AppInfoCategoryManager;
import gov.oit.storefrontweb.model.AppInfoCategory;
import gov.oit.storefrontweb.model.AppInfoDetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;

public class AppInfoCategoryServlet extends HttpServlet {

	static final long serialVersionUID = 9999981;
	static final String EDIT_FORM = "appInfoCategoryEdit.jsp";

	// Member variables

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// Post contents of the request
		String key = req.getAttribute("txtKey").toString();
		String shortDescription = req.getAttribute("txtShortDescription")
				.toString();
		String longDescription = req.getAttribute("txtLongDescription")
				.toString();
		String blnreq = req.getAttribute("cbActive").toString();

		// Temp value
		Boolean active = true;

		// Create new appInfoCategory from form data
		AppInfoCategory appInfoCategory = new AppInfoCategory(key,
				shortDescription, longDescription, active);

		// Create AppInfoCategoryManager to work with appInfoCategory
		AppInfoCategoryManager appInfoCategoryManager = new AppInfoCategoryManager();

		// Save it!
		appInfoCategoryManager.save(appInfoCategory);

		req = this.getBlankRequest(req);
		req.setAttribute("message", "Whoo-hoo!  Saved!");

		req.getRequestDispatcher(EDIT_FORM).forward(req, resp);

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		String key = req.getParameter("key");
		System.out.println(key);
		
		if (null == key || key.trim() == "") {
			//req = this.getBlankRequest(req);
		   	req.setAttribute("message", "New Record");
			req.setAttribute("key", "");
			req.setAttribute("longDescription", "");
			req.setAttribute("shortDescription", "");
			req.setAttribute("active", false);
		}
//
//		else {
//			try {
//				req = this.getPopulatedRequest(req, key);
//			} catch (EntityNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		// Get response object
		req.getRequestDispatcher(EDIT_FORM).forward(req, resp);
	}

	private HttpServletRequest getPopulatedRequest(HttpServletRequest req,
			String key) throws EntityNotFoundException {

		AppInfoCategoryManager manager = new AppInfoCategoryManager();
		AppInfoCategory appInfoCategory = manager.getAppInfoCategory(key);

		
		req.setAttribute("key", appInfoCategory.get_key());
		req.setAttribute("longDescription",
				appInfoCategory.get_longDescription());
		req.setAttribute("shortDescription",
				appInfoCategory.get_shortDescription());
		req.setAttribute("active", appInfoCategory.get_active());

		return req;
	}

	private HttpServletRequest getBlankRequest(HttpServletRequest req) {
		req.setAttribute("key", "");
		req.setAttribute("longDescription", "");
		req.setAttribute("shortDescription", "");
		req.setAttribute("active", false);

		return req;
	}

}
