package jspservlet.dao.impl;

import java.sql.PreparedStatement;

import jspservlet.dao.OrderDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int addOrder(Order order) {
		if (order.getEmail() == null || order.getEmail().equals("")) {
			return 0;
		}
		String sql = "insert into order (email, pro_id, qty, price) value(?,?,?,?)";
		PreparedStatement pstmt = null;
		DBConnect conn = null;
		int result = 0;
		try {
			conn = new DBConnect();
			pstmt.getConnection().prepareStatement(sql);
			pstmt.setString(1, order.getEmail());
			pstmt.setString(2, order.getPro_id());
			pstmt.setInt(3, order.getQty());
			pstmt.setDouble(4, order.getPrice());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		
		return result;
	}

}
