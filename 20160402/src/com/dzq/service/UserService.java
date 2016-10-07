package com.dzq.service;

import com.dzq.dao.XmlUserDao;
import com.dzq.domian.User;
import com.dzq.exception.MsgException;

public class UserService {
    private  XmlUserDao dao=new XmlUserDao();
	/**
	 * 添加用户
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException{
		if(dao.findUserByUserName(user.getUsername())!=null){
			throw new MsgException("用户名已经存在");
		}
		dao.addUser(user);
	}
	/**
	 * 检查用户名是否正确
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUserByUNAndPWD(username, password);
		
	}
}
