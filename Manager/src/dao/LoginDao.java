package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import entity.Login;

public class LoginDao {
public boolean isExist(Login lg){
	String sql = "select * from login where username = '"+lg.getUsername()
			+"'and password ='"+lg.getPassword()+"'";
	List<Map<String,Object>> ls=JDBCUtil.doQuery(sql);
	System.out.println(ls);
	if(ls!=null&&ls.size()==1){
		return true;
	}else{
		return false;
	}
}
}
