package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse res)throws IOException, ServletException{
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		UserDAO dao = new UserDAOImpl();
		if (!user.getPassword().equals(request.getParameter("password1"))) {
			request.getSession().setAttribute("prompt_title", "Registration failed");
			request.getSession().setAttribute("prompt", "Confirmed password doesn't match!");
			response.sendRedirect("./prompt.jsp");
			return ;
		}
		int flag = 0;
		try{
			flag = dao.register(user);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		if (flag == 0) {
			request.getSession().setAttribute("prompt_title", "Registration failed");
			request.getSession().setAttribute("prompt", "Email address has been used! Please type another one.");
			response.sendRedirect("./prompt.jsp");
		} else if (flag == -1) {
			request.getSession().setAttribute("prompt_title", "Registration failed");
			request.getSession().setAttribute("prompt", "Email cannot be empty!");
			response.sendRedirect("./prompt.jsp");
		} else if (flag == -2) {
			request.getSession().setAttribute("prompt_title", "Registration failed");
			request.getSession().setAttribute("prompt", "Password cannot be empty!");
			response.sendRedirect("./prompt.jsp");
		} else if (flag == -3) {
			request.getSession().setAttribute("prompt_title", "Registration failed");
			request.getSession().setAttribute("prompt", "Password should be longer than 6 characters and shorter than 12 characters.");
			response.sendRedirect("./prompt.jsp");
		} else if (flag == -4) {
			request.getSession().setAttribute("prompt_title", "Registration failed");
			request.getSession().setAttribute("prompt", "Firstname or lastname cannot be empty!");
			response.sendRedirect("./prompt.jsp");
		} else {
			request.getSession().setAttribute("prompt_title", "Registration succeed");
			request.getSession().setAttribute("prompt", "You have succefully created an account!");
			response.sendRedirect("./prompt.jsp");
		}
		
	}
}
