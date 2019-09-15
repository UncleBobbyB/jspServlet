package jspservlet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.ProductDAO;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.vo.Product;

/**
 * Servlet implementation class SerarchServlet
 */
public class SerarchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = (String)req.getParameter("search");
		System.out.println(query);
		ArrayList<Product> proList = new ArrayList<Product>();
		ProductDAO pdao = new ProductDAOImpl();
		try{
			int i=0;
			proList=pdao.quePro(query);
			HttpSession session = req.getSession();
			session.setAttribute("pro",proList);
//			for (Product pro : proList){
//				session.setAttribute(""+i+"pro_id", proList.get(i).getId());
//				session.setAttribute(""+i+"pro_name", proList.get(i).getName());
//				session.setAttribute(""+i+"pro_image", proList.get(i).getImage());
//				session.setAttribute(""+i+"pro_price", proList.get(i).getPrice());
//				i++;
//			}
		}catch(Exception e){
			System.out.println(e.getMessage()+"searchservlet");
		}
		res.sendRedirect("./search.jsp");
	}

}
