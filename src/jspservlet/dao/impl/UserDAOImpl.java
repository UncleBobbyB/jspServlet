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

	@Override
	public int register(User user) {
		if (user.getEmail() == null || "".equals(user.getEmail())) {
			return -1;
		}
		if (user.getPassword() == null || user.getPassword().equals("")) {
			return -2;
		}
		if (user.getPassword().length() < 6 || user.getPassword().length() >= 12) {
			return -3;
		}
		for (String name : new String[] {user.getFirstname(), user.getLastname()}) {
			if (name == null || "".equals(name)) {
				return -4;
			}
		}
		DBConnect conn = null;
		String sql = "insert into userinfo (firstname, lastname, email, password) value(?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = new DBConnect();
			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
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
