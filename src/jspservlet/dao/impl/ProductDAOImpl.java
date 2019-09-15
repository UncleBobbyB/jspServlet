package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jspservlet.dao.ProductDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Product;

public class ProductDAOImpl implements ProductDAO{
	public  ArrayList<Product> getPro(ArrayList<Product> proList) throws Exception{
		String sql = "select * from product";
		PreparedStatement pstmt = null;
		DBConnect dbc =null;
		try{
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Product pro = new Product();
				pro.setId(rs.getString("pro_id"));
				pro.setName(rs.getString("pro_name"));
				pro.setImage(rs.getString("pro_image"));
				pro.setPrice(rs.getDouble("pro_price"));
				proList.add(pro);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			dbc.close();
		}
		return proList;
	}
	public  ArrayList<Product> quePro(String str) throws Exception{
		String sql = "select * from product where pro_name like \"%\"?\"%\"";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		DBConnect dbc =null;
		ArrayList<Product> proList = new ArrayList<Product>();
		try{
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, str);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Product pro = new Product();
				pro.setId(rs.getString("pro_id"));
				pro.setName(rs.getString("pro_name"));
				pro.setImage(rs.getString("pro_image"));
				pro.setPrice(rs.getDouble("pro_price"));
				proList.add(pro);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage()+"SQL excep");
		}finally{
			dbc.close();
		}
		return proList;
	}
	@Override
	public Product getProductById(String id) throws Exception {
		String sql = "select * from product where pro_id=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,  id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("pro_id"));
				product.setName(rs.getString("pro_name"));
				product.setImage(rs.getString("pro_image"));
				product.setPrice(rs.getDouble("pro_price"));
				return product;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			dbc.close();
		}
		
		return null;
	}
}
