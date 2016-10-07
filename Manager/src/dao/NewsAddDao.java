package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

import entity.Article;
import entity.Category;

public class NewsAddDao {
	public static boolean isEmpTy(String string) {
		return string == null || "".equals(string.trim());
	}

	public List<Map<String, Object>> queryNews(Article arti) {
		// 1.sql算法
		String sql = "select articleID,title,content,descp,image,createtime,recmd,keywords,cateID,writer from article where 1=1 ";
		return JDBCUtil.doQuery(sql);
	}

	public boolean insertNew(Article arti) {
		String title = arti.getTitle();
		String writer = arti.getWriter();
		String keywords = arti.getKeywords();
		String content = arti.getContent();
		String createtime=arti.getCreatetime();
		if (isEmpTy(title) || isEmpTy(writer) || isEmpTy(keywords)
				|| isEmpTy(content)||isEmpTy(createtime)) {
			return false;
		} else {
			String sql = "select * from article where title='"
					+ arti.getTitle() + "'";
			List<Map<String, Object>> result = JDBCUtil.doQuery(sql);
			if (result != null && result.size() >= 1) {
				return false;
			} else {
				String sql1 = "insert into article(title,writer,keywords,cateID,content,createtime) values('"
						+ arti.getTitle()
						+ "','"
						+ arti.getWriter()
						+ "','"
						+ arti.getKeywords()
						+ "','"
						+ arti.getCateID()
						+ "','"
						+ arti.getContent() + "','"+arti.getCreatetime()+"')";
				return JDBCUtil.doUpdate(sql1);
			}
		}
	}
}