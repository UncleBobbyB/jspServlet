package jspservlet.dao;

import jspservlet.vo.User;

public interface UserDAO {
	public int queryByUsername(User user)throws Exception;
	public int register(User user);
}
