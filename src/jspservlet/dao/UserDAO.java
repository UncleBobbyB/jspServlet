package jspservlet.dao;

import jspservlet.vo.User;

public interface UserDAO {
	public int queryByUsername(User user)throws Exception;
	public int registerByUsername(User user) throws Exception ;
	public void register(User user) throws Exception;
}
