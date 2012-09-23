package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.discovery.Identifier;

import business.openid.UserLogin;

public class OpenIDLoginServlet extends HttpServlet{

	private UserLogin userLogin;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if ("true".equals(req.getParameter("is_return"))) {
			processReturn(req, resp);
		} else {
			String identifier = req.getParameter("openid_identifier");
			if (identifier != null) {
				userLogin.authRequest(identifier, req, resp);		//UserLogin here!!!
			} else {
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			userLogin = new UserLogin(getServletContext());
		} catch (ConsumerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.init();
	}

	private void processReturn(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Identifier identifier = userLogin.verifyResponse(req);		//userLogin here!!!

		if (identifier == null) {
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			req.setAttribute("identifier", identifier.getIdentifier());
			this.getServletContext().getRequestDispatcher("/return.jsp").forward(req, resp);
		}
	}

}
