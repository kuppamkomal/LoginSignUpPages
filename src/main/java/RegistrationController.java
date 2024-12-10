

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {
	
	Model model;
	@Override
	public void init() {
		model = new Model();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String psd = req.getParameter("pass");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		int ph = Integer.parseInt(req.getParameter("phone"));
		boolean rs = model.performSignup(id,psd,name,email,gender,ph);
		try {
		if(rs) {
			res.sendRedirect("/SignUpLogIn/Login.html");
		}
		else {
			res.sendRedirect("/SignUpLogIn/userexist.html");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
