package jspservlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservlet.dao.ProductDAO;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.vo.Product;

/**
 * Servlet implementation class Buy
 */
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
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
		ProductDAO dao = new ProductDAOImpl();
		Product product = null;
		String email = (String)request.getSession().getAttribute("email");
		if (email == null || "".equals(email)) {
			response.sendRedirect("./login.jsp");
			return ;
		}
		try {
			product = dao.getProductById(request.getParameter("pro_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (product == null) {
			response.sendRedirect("shop1.jsp");
		} else {
			request.getSession().setAttribute("product_to_buy", product);
			response.sendRedirect("checkout.jsp");
		}
	}

}
