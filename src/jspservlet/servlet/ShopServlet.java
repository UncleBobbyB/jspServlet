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
 * Servlet implementation class ShopServlet
 */
public class ShopServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Product> proList = new ArrayList<Product>();
		ProductDAO pdao = new ProductDAOImpl();
		try{
			int i=0;
			proList=pdao.getPro(proList);
			HttpSession session = req.getSession();
			for (Product pro : proList){
				session.setAttribute("pro_id"+i, proList.get(i).getId());
				session.setAttribute("pro_name"+i, proList.get(i).getName());
				session.setAttribute("pro_image"+i, proList.get(i).getImage());
				session.setAttribute("pro_price"+i, proList.get(i).getPrice());
				i++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		res.sendRedirect("./shop1.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
