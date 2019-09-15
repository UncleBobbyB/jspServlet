package jspservlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservlet.action.Action;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet (
		name = "shoppingCartServlet",
		urlPatterns = {"/shoppingcart"}
		)
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
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
		String product_ids = String.valueOf(request.getSession().getAttribute("product_id"));
		String action = String.valueOf(request.getSession().getAttribute("action"));
		Action targetAction = null;
		String path = null;
		try {
			if (product_ids == null || product_ids.equals("")) {
				path = "login.jsp";
			} else {
				if (action.equals("deletebus")) {
					targetAction = new DeleteShoppingCartAction();
				}
			}
		}
	}

}
