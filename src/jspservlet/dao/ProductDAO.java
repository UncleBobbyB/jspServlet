package jspservlet.dao;

import java.util.ArrayList;

import jspservlet.vo.Product;

public interface ProductDAO {
	public ArrayList<Product> getPro(ArrayList<Product> proList) throws Exception;
	public  ArrayList<Product> quePro(String str) throws Exception;
	public Product getProductById(String id) throws Exception;
}
