package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

import entity.Category;

public class CateAddDao {
public boolean isEmpty(String str){
	return str==null||"".equals(str.trim());
	
  }
public List<Map<String,Object>> queryCate(Category cate){
	//1.sql算法
	String sql= "select cateID,catename,catedesp from category where 1=1 ";
	//2.用JDBC连接 处理数据
	return JDBCUtil.doQuery(sql);
}

public boolean insertCate(Category cate){
	String name=cate.getCatename();
	if(isEmpty(name)){
		return false;
	}else{
		//查询数据库有无这个栏目
		String sql="select * from category where catename='"+cate.getCatename()+"'";
		List<Map<String,Object>> result=JDBCUtil.doQuery(sql);
		if(result!=null&&result.size()>=1){
			return false;
		}else{
			String sql1="insert into category (catename) values('"+cate.getCatename()+"')";
		    return JDBCUtil.doUpdate(sql1);
		}
	}
}
}
