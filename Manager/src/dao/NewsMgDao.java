package dao;

import java.util.List;
import java.util.Map;

import Const.Const;

import entity.Article;
import entity.SpiltPage;
import service.Inews;
import util.JDBCUtil;

public class NewsMgDao implements Inews{


	public SpiltPage ls(int cur,String words) {
		String sql="select * from article ";
		if(words!=null){
			sql+=" WHERE CONCAT(articleID,title,keywords,createtime,writer) like '%"+words+"%'";
		}
		List<Map<String,Object>> result=JDBCUtil.doQuery(sql);
		Const cs=new Const();
		SpiltPage sp=new SpiltPage();
		sp.setCurpage(cur);
		sp.setCursize(cs.PAGE);
		sp.setMaxpage(99999);
		int count=result.size();
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

	public boolean deletenews(int id) {
		String sql="delete from article where articleID='"+id+"'";
		return JDBCUtil.doUpdate(sql);
	}

	public boolean deleteAllnews(String ids) {
	String sql="delete from article where articleID in ("+ids+")";
		return JDBCUtil.doUpdate(sql);
	}

	public boolean updatenews(Article art) {
		String sql="update article set title='"+art.getTitle()+"',keywords='"+art.getKeywords()+"',writer='"+art.getWriter()+"' where articleID='"+art.getArticleID()+"'";
		return JDBCUtil.doUpdate(sql);
	}

	
}
