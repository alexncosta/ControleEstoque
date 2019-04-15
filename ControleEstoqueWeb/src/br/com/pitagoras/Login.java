package br.com.pitagoras;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import br.com.pitagoras.dao.*;

public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean access = false;
		
		LoginDao dao = new LoginDao();
		access = dao.efetuarLogin(request.getParameter("login"), request.getParameter("senha"));
		
		if (access == true)
			response.sendRedirect("index");
	}

}
