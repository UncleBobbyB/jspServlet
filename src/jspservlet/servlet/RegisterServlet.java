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
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		User user = new User();
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setFirstname(req.getParameter("firstname"));
		user.setLastname(req.getParameter("lastname"));
		UserDAO dao = new UserDAOImpl();
		int flag =0;
		try{
			flag = dao.registerByUsername(user);
		}catch (Exception e) {
			e.getMessage();
		}
		if(flag == 1){
			try{ 
				if(req.getParameter("firstname").equals("")){
					req.setAttribute("str4", "Firstname can not be empty");
					req.getRequestDispatcher("./register.jsp").forward(req, res);
				}else if(req.getParameter("lastname").equals("")){
					req.setAttribute("str5", "Lastname can not be empty");
					req.getRequestDispatcher("./register.jsp").forward(req, res);
				}else if(req.getParameter("email").equals("")){
					req.setAttribute("str3", "Email can not be empty");
					req.getRequestDispatcher("./register.jsp").forward(req, res);
				}else if(req.getParameter("password").equals("")){
					req.setAttribute("str6", "Password can not be empty");
					req.getRequestDispatcher("./register.jsp").forward(req, res);
				}else if(!req.getParameter("password").equals(req.getParameter("password1"))){
					req.setAttribute("str2", "Two different passwords");
					req.getRequestDispatcher("./register.jsp").forward(req, res);
				}
				
				else{
					dao.register(user);
				}
			}catch(Exception e){
				e.getMessage();
			}
		
			HttpSession session = req.getSession();
			session.setAttribute("firstname",user.getFirstname());
			session.setAttribute("lastname",user.getLastname());
			session.setAttribute("email",user.getEmail());
			res.sendRedirect("./index1.jsp");
		}else{
			req.setAttribute("str1", "Email has been registered");
			req.getRequestDispatcher("./register.jsp").forward(req, res);
		}
	}
}
