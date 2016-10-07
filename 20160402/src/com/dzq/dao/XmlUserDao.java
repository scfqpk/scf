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
	 * �����û��������û�
	 * @param username �û���
	 * @return �����û����ҵ����û���Ϣ�����û�ҵ�������null
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
 * ����û�
 * @param user Ҫ����û���Ϣ��bean
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
 * �����û�����������û���Ϣ
 * @param username �û���
 * @param password ����
 * @return �ҵ����û����Ҳ�������null 
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
