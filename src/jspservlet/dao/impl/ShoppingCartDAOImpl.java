package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import jspservlet.dao.ShoppingcartDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Product;
import jspservlet.vo.Shoppingcart;
import jspservlet.vo.TempProduct;;

public class ShoppingcartDAOImpl implements ShoppingcartDAO {

	@Override
	public Vector<TempProduct> getProductsByEmail(String email) {
		if (email == null || email.equals("")) {
			return null;
		}
		String sql = "select * from shoppingcart where email=?";
		Vector<TempProduct> products = new Vector<TempProduct>();
		PreparedStatement pstmt = null;
		DBConnect conn = null;
		try {
			conn = new DBConnect();
			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = (new ProductDAOImpl()).getProductById(rs.getString("pro_id"));
				if (product == null || product.getId() == null || "".equals(product.getId())) {
					break;
				}
				TempProduct tp = new TempProduct();
				tp.setProduct(product);
				tp.setQty(rs.getInt("qty"));
				products.add(tp);
			}
			rs.close();
			pstmt.close();
			return products;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		
		return null;
	}

	@Override
	public double totalPrice(String email) {
		if (email == null || email.equals("")) {
			return -1;
		}
		double ans = -1;
		String sql = "select * from shoppingcart where email=?";
		PreparedStatement pstmt = null;
		DBConnect conn = null;
		try {
			ans = 0;
			conn = new DBConnect();
			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String pro_id = rs.getString("pro_id");
				String sql1 = "select * from product where pro_id=?";
				PreparedStatement pstmt1 = null;
				pstmt1 = conn.getConnection().prepareStatement(sql1);
				pstmt1.setString(1, pro_id);
				ResultSet rs1 = pstmt1.executeQuery();
				if (rs1.next()) {
					ans += rs1.getDouble("pro_price") * rs.getInt("qty");
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		
		return ans;
	}

	@Override
	public int addProduct(String email, String pro_id, int qty) throws Exception {
		Product product = (new ProductDAOImpl()).getProductById(pro_id);
		if (product == null) {
			return 0;
		}
		boolean in = false;
		int cur_qty = 0;
		Vector<TempProduct> products = getProductsByEmail(email);
		for (TempProduct vproduct : products) {
			if (vproduct.getProduct().getId().equals(product.getId())) {
				in = true;
				String sql = "select qty from shoppingcart where email=?";
				PreparedStatement pstmt = null;
				DBConnect conn = null;
				cur_qty = vproduct.getQty();
				break;
			}
		}
		int result = 0;
		if (in) {
			String sql = "update shoppingcart set qty=? where email=? and pro_id=?";
			PreparedStatement pstmt = null;
			DBConnect conn = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setInt(1, cur_qty + qty);
				pstmt.setString(2, email);
				pstmt.setString(3, pro_id);
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		} else {
			String sql = "insert into shoppingcart(email, pro_id, status, qty) values(?,?,?,?)";
			PreparedStatement pstmt = null;
			DBConnect conn = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, product.getId());
				pstmt.setInt(3, 0);
				pstmt.setInt(4, qty);
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		}
		
		return result;
	}

	@Override
	public int addProduct(String email, Product product, int qty) {
		boolean in = false;
		int cur_qty = 0;
		Vector<TempProduct> products = getProductsByEmail(email);
		for (TempProduct vproduct : products) {
			if (vproduct.getProduct().getId().equals(product.getId())) {
				in = true;
				String sql = "select qty from shoppingcart where email=?";
				PreparedStatement pstmt = null;
				DBConnect conn = null;
				cur_qty = vproduct.getQty();
				break;
			}
		}
		int result = 0;
		if (in) {
			String sql = "update shoppingcart set qty=? where email=? and pro_id=?";
			PreparedStatement pstmt = null;
			DBConnect conn = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setInt(1, cur_qty + qty);
				pstmt.setString(2, email);
				pstmt.setString(3, product.getId());
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		} else {
			String sql = "insert into shoppingcart(email, pro_id, status, qty) values(?,?,?,?)";
			PreparedStatement pstmt = null;
			DBConnect conn = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, product.getId());
				pstmt.setInt(3, 0);
				pstmt.setInt(4, qty);
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		}
		
		return result;
	}

	@Override
	public int reduceProduct(String email, Product product) {
		boolean single = false;
		int result = 0;
		String sql = "select * from shoppingcart where email=? and pro_id=?";
		DBConnect conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect();
			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, product.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				single = rs.getInt("qty") == 1;
			}
			pstmt.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		
		if (single) {
			sql = "delete from shopping where email=? and pro_id=?";
			pstmt = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, product.getId());
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		} else {
			sql = "update shoppingcart where email=? and pro_id=?";
			pstmt = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, product.getId());
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		}
		
		return result;
	}

	@Override
	public int reduceProduct(String email, String pro_id) throws Exception {
		Product product = (new ProductDAOImpl()).getProductById(pro_id);
		if (product == null) {
			return 0;
		}
		int qty = 1;
		int result = 0;
		String sql = "select * from shoppingcart where email=? and pro_id=?";
		DBConnect conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect();
			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, product.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				qty = rs.getInt("qty");
			}
			pstmt.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}
		
		if (qty == 1) {
			sql = "delete from shoppingcart where email=? and pro_id=?";
			pstmt = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, product.getId());
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		} else {
			sql = "update shoppingcart set qty=? where email=? and pro_id=?";
			pstmt = null;
			try {
				conn = new DBConnect();
				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setInt(1, qty - 1);
				pstmt.setString(2, email);
				pstmt.setString(3, product.getId());
				result = pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) { 
				ex.printStackTrace();
			} finally {
				conn.close();
			}
		}
		
		return result;
	}


}
