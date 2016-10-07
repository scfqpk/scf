package service;

import java.util.List;
import java.util.Map;
import dao.NewsAddDao;
import entity.Article;


public class NewsAddService {
	private NewsAddDao nad = new NewsAddDao();
	public List<Map<String,Object>> queryNews(Article arti){
		return nad.queryNews(arti);
	}
	
	public boolean insertNew(Article arti){
		return nad.insertNew(arti);
	}
}
