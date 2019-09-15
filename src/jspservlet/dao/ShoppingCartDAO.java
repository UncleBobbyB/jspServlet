package jspservlet.dao;

import java.util.Vector;

import jspservlet.vo.ShoppingCart;

public interface ShoppingCartDAO {

	public Vector<ShoppingCart> getProductsByUserId(String user_id, int status) throws Exception;
	public Vector<ShoppingCart> getAllProducts(String user_id) throws Exception;
	
}
