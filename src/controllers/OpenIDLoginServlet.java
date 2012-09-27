package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openid4java.OpenIDException;
import org.openid4java.association.AssociationSessionType;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.InMemoryConsumerAssociationStore;
import org.openid4java.consumer.InMemoryNonceVerifier;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;

import business.openid.UserLogin;

public class OpenIDLoginServlet extends HttpServlet{

//	private UserLogin userLogin;
	
	
	private ConsumerManager manager;
	private ServletContext context;
	
//	private String returnToUrl =  "http://www.MentorFind/login";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if ("true".equals(req.getParameter("is_return"))) {
			processReturn(req, resp);
		} else {
			String identifier = req.getParameter("openid_identifier");
			if (identifier != null) {
				authRequest(identifier, req, resp);		//UserLogin here!!!
			} else {
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}
	}

	//	@Override
	//	public void init(ServletConfig config) throws ServletException {
	//		try {
	//			userLogin = new UserLogin(getServletContext());
	//		} catch (ConsumerException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		super.init(config);
	//	}

	@Override
	public void init() throws ServletException {
		
		super.init();
		System.out.println("starting servlet!!!!!!!");
//		userLogin = new UserLogin();
		manager = new ConsumerManager();
		manager.setAssociations(new InMemoryConsumerAssociationStore());

		manager.setNonceVerifier(new InMemoryNonceVerifier(5000));

		manager.setMinAssocSessEnc(AssociationSessionType.DH_SHA256);
//		context = getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	private void processReturn(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("processing return!");
		Identifier identifier = verifyResponse(req);		//userLogin here!!!

		if (identifier == null) {
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);		//User not logged in
		} else {
			req.setAttribute("identifier", identifier.getIdentifier());
			System.out.println("User logged in, identifier: " + identifier.getIdentifier());
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);	//User Logged in, check if already member
		}
	}
	
	
	public String authRequest(String userSuppliedString,
			HttpServletRequest httpReq,
			HttpServletResponse httpResp)
					throws IOException, ServletException
					{
		try
		{
			// configure the return_to URL where your application will receive
			// the authentication responses from the OpenID provider
			// Look up!
			
			//userSuppliedString seems to be the URL to the OpenID provider...
			
			String returnToUrl = httpReq.getRequestURL().toString() + "?is_return=true";

			// --- Forward proxy setup (only if needed) ---
			// ProxyProperties proxyProps = new ProxyProperties();
			// proxyProps.setProxyName("proxy.example.com");
			// proxyProps.setProxyPort(8080);
			// HttpClientFactory.setProxyProperties(proxyProps);

			// perform discovery on the user-supplied identifier
			List discoveries = manager.discover(userSuppliedString);

			// attempt to associate with the OpenID provider
			// and retrieve one service endpoint for authentication
			DiscoveryInformation discovered = manager.associate(discoveries);

			// store the discovery information in the user's session
			httpReq.getSession().setAttribute("openid-disc", discovered);

			// obtain a AuthRequest message to be sent to the OpenID provider
			AuthRequest authReq = manager.authenticate(discovered, returnToUrl);

			
			
			// Attribute Exchange example: fetching the 'email' attribute
			FetchRequest fetch = FetchRequest.createFetchRequest();
			if(userSuppliedString.startsWith("https://www.google.com")){
				fetch.addAttribute("email",
						// attribute alias
						"http://schema.openid.net/contact/email",   // type URI
						true);                                      // required
				
				fetch.addAttribute("firstname", "http://schema.openid.net/namePerson/first", true);
				fetch.addAttribute("lastname", "http://schema.openid.net/namePerson/last", true);
			}else if (userSuppliedString.startsWith("https://me.yahoo.com")){
				fetch.addAttribute("email", "http://axschema.org/contact/email", true);
				fetch.addAttribute("fullname", "http://axschema.org/namePerson", true);
			}
			
			
			
			
			// attach the extension to the authentication request
			authReq.addExtension(fetch);
			authReq.getOPEndpoint();

//			if (! discovered.isVersion2() )			//check this!!!!
//			{
				// Option 1: GET HTTP-redirect to the OpenID Provider endpoint
				// The only method supported in OpenID 1.x
				// redirect-URL usually limited ~2048 bytes
				httpResp.sendRedirect(authReq.getDestinationUrl(true));
//				return null;
//			}
//			else
//			{
//				// Option 2: HTML FORM Redirection (Allows payloads >2048 bytes)
//				
//				RequestDispatcher dispatcher =
//						getServletContext().getRequestDispatcher("/formRedirection.jsp");
//				httpReq.setAttribute("parameterMap", authReq.getParameterMap());
//				httpReq.setAttribute("destinationUrl", authReq.getDestinationUrl(false));
////				httpReq.setAttribute("authReq", authReq);
//				try {
//					dispatcher.forward(httpReq, httpResp);
//				} catch (ServletException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		catch (OpenIDException e)
		{
			throw new ServletException(e);
		}

		return null;
					}

	// --- processing the authentication response ---
	public Identifier verifyResponse(HttpServletRequest httpReq)
	{
		try
		{
			// extract the parameters from the authentication response
			// (which comes in as a HTTP request from the OpenID provider)
			ParameterList response =
					new ParameterList(httpReq.getParameterMap());

			// retrieve the previously stored discovery information
			DiscoveryInformation discovered = (DiscoveryInformation)
					httpReq.getSession().getAttribute("openid-disc");

			// extract the receiving URL from the HTTP request
			StringBuffer receivingURL = httpReq.getRequestURL();
			String queryString = httpReq.getQueryString();
			if (queryString != null && queryString.length() > 0)
				receivingURL.append("?").append(httpReq.getQueryString());

			// verify the response; ConsumerManager needs to be the same
			// (static) instance used to place the authentication request
			VerificationResult verification = manager.verify(
					receivingURL.toString(),
					response, discovered);

			// examine the verification result and extract the verified identifier
			Identifier verified = verification.getVerifiedId();
			if (verified != null)
			{
				AuthSuccess authSuccess =
						(AuthSuccess) verification.getAuthResponse();

				if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX))
				{
					FetchResponse fetchResp = (FetchResponse) authSuccess
							.getExtension(AxMessage.OPENID_NS_AX);

					List emails = fetchResp.getAttributeValues("email");
					String email = (String) emails.get(0);
					System.out.println(email);
					String firstname = fetchResp.getAttributeValue("firstname");
					String lastname = fetchResp.getAttributeValue("lastname");
					System.out.println(firstname + " " + lastname);
					
					String fullname = fetchResp.getAttributeValue("fullname");
					System.out.println(fullname);
					
				}

				return verified;  // success
			}
		}
		catch (OpenIDException e)
		{
			// present error to the user
		}

		return null;
	}

}
