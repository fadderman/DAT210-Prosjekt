package controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import language.Language;
import mail.SendMail;
import models.User;


public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mailTo = request.getParameter("mailTo");
		String mailTittle = request.getParameter("mailTitle");
		String mailMessage = request.getParameter("mailMessage");
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		String mailFrom = currentUser.getEmail();
		String mailFromMessage = "This message is sent from";
		mailMessage += " \n\n" + mailFromMessage;
		mailMessage += "\n" + mailFrom;
		mailTittle = "MentorFind: " + mailTittle;
		try {
			SendMail.Send(mailTo, mailTittle, mailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("active", "home");
		request.setAttribute("include", "home.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
