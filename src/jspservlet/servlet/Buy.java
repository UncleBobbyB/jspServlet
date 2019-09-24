package jspservlet.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservlet.dao.ProductDAO;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.db.DBConnect;
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
			DBConnect conn = null;
			String sql = "insert into `order` (email, pro_id, qty, price) value(?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, product.getId());
				pstmt.setInt(3, 1);
				pstmt.setDouble(4, product.getPrice() * 0.7);
				int ok = pstmt.executeUpdate();
				assert (ok > 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				request.getSession().setAttribute("prompt_title", "Purchase Succeed");
				request.getSession().setAttribute("prompt", "You have succeccfully made your purchase.");
				response.sendRedirect("./prompt.jsp");
				conn.close();
			}
		}
	}

}
