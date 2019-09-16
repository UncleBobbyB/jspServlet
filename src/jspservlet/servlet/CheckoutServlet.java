package jspservlet.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.OrderDAO;
import jspservlet.dao.ShoppingcartDAO;
import jspservlet.dao.impl.OrderDAOImpl;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.dao.impl.ShoppingcartDAOImpl;
import jspservlet.vo.TempProduct;
import jspservlet.vo.Order;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		assert (email != null && !email.equals(""));
		ShoppingcartDAO dao = new ShoppingcartDAOImpl();
		Vector<TempProduct> products = dao.getProductsByEmail(email);
		OrderDAO order_dao = new OrderDAOImpl();
		for (TempProduct product : products) {
			Order order = new Order();
			order.setEmail(email);
			order.setPrice(dao.totalPrice(email));
			order.setPro_id(product.getProduct().getId());
			order.setQty(product.getQty());
			assert (order_dao.addOrder(order) > 0);
		}
		dao.clearCart(email);
		
		response.sendRedirect("shop1.jsp");
	}

}
