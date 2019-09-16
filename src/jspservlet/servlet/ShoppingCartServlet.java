package jspservlet.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.dao.impl.ShoppingcartDAOImpl;
import jspservlet.vo.TempProduct;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet (
		name = "shoppingCartServlet",
		urlPatterns = {"/shoppingcart"}
		)
public class ShoppingcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		if (email == null || "".equals(email)) {
			response.sendRedirect("login.jsp");
			return ;
		}
		String what = request.getParameter("what");
		if (what.equals("checkout")) {
			
		} else if (what.equals("display")) {
			Vector<TempProduct> products = (new ShoppingcartDAOImpl()).getProductsByEmail(email);
			session.setAttribute("products to display", products);
			response.sendRedirect("shoppingcart.jsp");
		} else if (what.equals("add")) {
			try {
				int result = (new ShoppingcartDAOImpl()).addProduct(email, request.getParameter("pro_id"), Integer.parseInt(request.getParameter("qty")));
				assert(result > 0);
				response.sendRedirect(request.getContextPath() + "/ShoppingcartServlet?what=display");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (what.equals("reduce")) {
			try {
				int result = (new ShoppingcartDAOImpl()).reduceProduct(email, request.getParameter("pro_id"));
				assert(result > 0);
				response.sendRedirect(request.getContextPath() + "/ShoppingcartServlet?what=display");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
