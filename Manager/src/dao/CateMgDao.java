package dao;

import java.util.List;
import java.util.Map;

import Const.Const;

import util.JDBCUtil;
import entity.Category;
import entity.SpiltPage;

public class CateMgDao {
 public boolean deleteCat(Category cate){
	 String articlesql="delete from category where cateID="+cate.getCateID();
	 JDBCUtil.doUpdate(articlesql);
	 String cateSql="delete from category where cateID = "+cate.getCateID();
		return JDBCUtil.doUpdate(cateSql);
	}
	public boolean deleteAllCat(String ids){
		String articleAllSql="delete form category where cateID in("+ids+")";
		JDBCUtil.doUpdate(articleAllSql);
		String cateAllSql="delete from category where cateID in ("+ids+")";
		return JDBCUtil.doUpdate(cateAllSql);
	
 }
	public SpiltPage updateCat(int cur){
		String sql="select * from category";
		List<Map<String,Object>> ls=JDBCUtil.doQuery(sql);
		Const cs=new Const();
		SpiltPage sp=new SpiltPage();
		//获取当前页
		sp.setCurpage(cur);
		//设置每页最大条数
		sp.setCursize(cs.PAGE);
		sp.setMaxpage(99999);
		int count=ls.size();
		sp.setCountpage(count);
		int maxpage=(sp.getCountpage()%sp.getCursize()==0)?(sp.getCountpage()/sp.getCursize()):(sp.getCountpage()/sp.getCursize()+1);
		sp.setMaxpage(maxpage);
		int curpage=sp.getCurpage();
		sp.setCurpage(curpage);
		if(curpage>maxpage){
			curpage=maxpage;
		}
		int start = (sp.getCurpage()-1)*sp.getCursize();
		String catesql=sql+" limit "+start+","+sp.getCursize();
		List<Map<String,Object>> curdata=JDBCUtil.doQuery(catesql);
		sp.setLs(curdata);
		return sp;
	}
	
	public boolean modifycate(Category cate){
		String sql="update category set catename='"+cate.getCatename()+"' where cateID='"+cate.getCateID()+"'";
		return JDBCUtil.doUpdate(sql);
	}
}
