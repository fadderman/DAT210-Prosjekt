package language;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateNewLanguageServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Language lang = new Language();
		String language = request.getParameter("language");
		lang.setLanguage(language);
		System.out.println("servlet before cookie: " + language);
		
		HttpSession session = request.getSession();
        session.setAttribute("lang", lang);
        
		Cookie chosenLanguageCookie = new Cookie("chosenLanguage", language);
		chosenLanguageCookie.setMaxAge(60*60*24*365*2); //set its age to 2 years
		chosenLanguageCookie.setPath("/"); //allow the entire application to access it
		response.addCookie(chosenLanguageCookie);

	
//		System.out.println("servlet after cookie: " + language);
		
		String url = (String) session.getAttribute("CurrentPage");
		if (url.equals(null)) {
			url = "/login.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}