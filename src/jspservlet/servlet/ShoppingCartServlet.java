package jspservlet.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.ShoppingcartDAO;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.dao.impl.ShoppingcartDAOImpl;
import jspservlet.db.DBConnect;
import jspservlet.vo.Order;
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
		if (what.equals("display")) {
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
		} else if (what.equals("delete")) {
			try {
				int result = (new ShoppingcartDAOImpl()).deleteProduct(email, request.getParameter("pro_id"));
				assert(result > 0);
				response.sendRedirect(request.getContextPath() + "/ShoppingcartServlet?what=display");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (what.equals("checkout")) {
			ShoppingcartDAO dao = new ShoppingcartDAOImpl();
			Vector<TempProduct> products = (dao).getProductsByEmail(email);
			String sql = "insert into `order` (email, pro_id, qty, price) value(?,?,?,?)";
			PreparedStatement pstmt = null;
			DBConnect conn = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				for (TempProduct product : products) {
					pstmt.setString(2, product.getProduct().getId());
					pstmt.setInt(3, product.getQty());
					pstmt.setDouble(4, product.getProduct().getPrice() * 0.7);
					int ok = pstmt.executeUpdate();
					assert (ok > 0);
					dao.clearCart(email);
				}
				pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				conn.close();
				request.getSession().setAttribute("prompt_title", "Purchase Succeful");
				request.getSession().setAttribute("prompt", "You have succefully made your purchase.");
				response.sendRedirect("./prompt.jsp");
			}
		}
	}

}
