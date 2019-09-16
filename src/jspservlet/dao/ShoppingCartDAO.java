package jspservlet.dao;

import java.util.Vector;

import jspservlet.vo.Product;
import jspservlet.vo.Shoppingcart;
import jspservlet.vo.TempProduct;

public interface ShoppingcartDAO {

	Vector<TempProduct> getProductsByEmail(String email);
	double totalPrice(String email);
	int addProduct(String email, String pro_id, int qty) throws Exception;
	int addProduct(String email, Product product, int qty);
	int reduceProduct(String email, Product product);
	int reduceProduct(String email, String pro_id) throws Exception;
	int clearCart(String email);
}
