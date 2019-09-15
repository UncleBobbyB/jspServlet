/**
 * 
 */
package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;



/**
 * @author lenovo
 *
 */
public class UserDAOImpl implements UserDAO {

	/* (non-Javadoc)
	 * @see jspservlet.dao.UserDAO#queryByUsername(jspservlet.vo.User)
	 */
	@Override
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getEmail() == null || user.getEmail() == "" || user.getPassword() == null || user.getPassword() == "") {
			return 0;
		}
		int flag = 0;
		String sql = "select * from userinfo where  email=?";
		PreparedStatement pstmt = null;
		DBConnect dbc =null;
		try{
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,user.getEmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(user.getPassword())){
					flag = 1;
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
				}
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			dbc.close();
		}
		//����û�������û�����tom��������123����ô��flag=1.
//		if(user.getUsername().equals("tom")&&user.getPassward().equals("123")){
//			flag =1 ;
//		}
		return flag;
	}
	public int registerByUsername(User user) throws Exception {
		int flag = 0;
		String sql = "select * from userinfo where email = ?";
		PreparedStatement pstmt = null;
		DBConnect dbc =null;
		try{
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				flag =0;
			}else{
				flag =1;
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			dbc.close();
		}
		return flag;
	}
	public void register(User user) throws Exception{
		String sql = "insert userinfo values (?,?,?,?)";
		PreparedStatement pstmt = null;
		DBConnect dbc =null;
		try{
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.execute();
			pstmt.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}finally {
			dbc.close();
		}
	}
}
