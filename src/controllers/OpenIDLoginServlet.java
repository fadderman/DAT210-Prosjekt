package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenIDLoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if ("true".equals(req.getParameter("is_return"))) {
			processReturn(req, resp);
		} else {
			String identifier = req.getParameter("openid_identifier");
			if (identifier != null) {
				this.authRequest(identifier, req, resp);		//UserLogin here!!!
			} else {
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}
	}

	private void processReturn(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//			Identifier identifier = this.verifyResponse(req);		//userLogin here!!!
		//			
		//			LOG.debug("identifier: " + identifier);
		//			
		//			if (identifier == null) {
		//			this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		//			} else {
		//			req.setAttribute("identifier", identifier.getIdentifier());
		//			this.getServletContext().getRequestDispatcher("/return.jsp").forward(req, resp);
		//			}
	}

}
