package com.dzq.dao;


import java.util.*;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dzq.domian.User;
import com.dzq.util.XmlDaoUtils;

public class XmlUserDao {
	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @return 根据用户名找到的用户信息，如果没找到，返回null
	 */
public User findUserByUserName(String username){
	Document dom=XmlDaoUtils.getDom();
	Element root=dom.getRootElement();
	List<Element> list=root.selectNodes("//user[@username='"+username+"']");
	if(list.size()>0){
		Element userEle=list.get(0);
		User user=new User();
		user.setUsername(userEle.attributeValue("username"));
		user.setPassword(userEle.attributeValue("password"));
		user.setNickname(userEle.attributeValue("nickname"));
		user.setEmail(userEle.attributeValue("email"));
		return user;
	}else{
		return null;
	}
}
/**
 * 添加用户
 * @param user 要添加用户信息的bean
 */
public void addUser(User user){
	Document dom=XmlDaoUtils.getDom();
	Element root=dom.getRootElement();
	
	Element userEle=DocumentHelper.createElement("user");
	userEle.setAttributeValue("username", user.getUsername());
	userEle.setAttributeValue("password", user.getPassword());
	userEle.setAttributeValue("nickname", user.getNickname());
	userEle.setAttributeValue("email", user.getEmail());
	root.add(userEle);
	XmlDaoUtils.refXml();
}

/**
 * 根据用户名密码查找用户信息
 * @param username 用户名
 * @param password 密码
 * @return 找到的用户，找不到返回null 
 */
public User findUserByUNAndPWD(String username,String password){
	
	Document dom=XmlDaoUtils.getDom();
	Element root=dom.getRootElement();
	List<Element> list=root.selectNodes("//user[@username='"+username+"'and @password='"+password+"']");
	if(list.size()>0){
		Element userEle=list.get(0);
		User user=new User();
		user.setUsername(userEle.attributeValue("username"));
		user.setPassword(userEle.attributeValue("password"));
		user.setNickname(userEle.attributeValue("nickname"));
		user.setEmail(userEle.attributeValue("email"));
		return user;
	}else{
		return null;
	}
	
}
}
