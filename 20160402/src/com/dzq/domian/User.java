package com.dzq.domian;

import java.io.Serializable;

import com.dzq.exception.MsgException;

public class User implements Serializable{
private String username;
private String password;
private String password2;
private String nickname;
private String email;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPassword2() {
	return password2;
}
public void setPassword2(String password2) {
	this.password2 = password2;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public User(){
	
}
public User(String username, String password, String password2,
		String nickname, String email) {
	
	this.username = username;
	this.password = password;
	this.password2 = password2;
	this.nickname = nickname;
	this.email = email;
}
@Override
public String toString() {
	return username+":"+password;
}
public void checkValue() throws MsgException{
	if(username==null||"".equals(username)){
		throw new MsgException("用户名不能为空");
	}
	if(password==null||"".equals(password)){
		throw new MsgException("密码不能为空");
	}
	if(password2==null||"".equals(password2)){
		throw new MsgException("密码不能为空");
	}
	if(!password.equals(password2)){
		throw new MsgException("两次密码输入不一致");
	}
	if(nickname==null||"".equals(nickname)){
		throw new MsgException("昵称不能为空");
	}
	if(email==null||"".equals(email)){
		throw new MsgException("邮箱不能为空");
	}
}

}
