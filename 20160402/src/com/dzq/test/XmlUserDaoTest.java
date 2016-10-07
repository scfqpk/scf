package com.dzq.test;

import org.junit.Test;

import com.dzq.dao.XmlUserDao;
import com.dzq.domian.User;

public class XmlUserDaoTest {
	@Test
public void testfindUserByUserName(){
	
	XmlUserDao dao=new XmlUserDao();
	User user=dao.findUserByUserName("admin");
	System.out.println(user.toString());
}
	@Test
	public void testfinduserByUNAndPWD(){
		XmlUserDao dao=new XmlUserDao();
		User user=dao.findUserByUNAndPWD("admin", "admin");
		System.out.println(user);
	}
	@Test
	public void testAddUser(){
		XmlUserDao dao=new XmlUserDao();
		User user=new User();
		user.setUsername("xiaoduc");
		user.setPassword("1234");
		user.setNickname("xiaoduc");
		user.setEmail("duxiao@qq.com");
		dao.addUser(user);
	}
}
