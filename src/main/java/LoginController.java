

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	Model model;
	
	@Override
		public void init() {
			model = new Model();
		}
	
	@Override
		public void service(HttpServletRequest req, HttpServletResponse res) {
			// TODO Auto-generated method stub
		try {
			String id = req.getParameter("kid");
			String password = req.getParameter("pass");
			boolean exist = model.performLogin(id,password);
			
			if(exist) {
				res.sendRedirect("/SignUpLogIn/welcome.html");
			}
			else {
				res.sendRedirect("/SignUpLogIn/Invalid.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Override
	public void destroy() {
		
	}
}
