package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Article;
import service.NewsAddService;

@SuppressWarnings("serial")
public class NewsAddServlet extends HttpServlet {
	private NewsAddService nas = new NewsAddService();
	private Article article = new Article();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String keywords = request.getParameter("keywords");
		String val = request.getParameter("dropdown");
		int ID = Integer.parseInt(val);
		
		String content = request.getParameter("content");
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//封装数据
		article.setTitle(title);
		article.setWriter(writer);
		article.setKeywords(keywords);
		article.setCateID(ID);
		article.setContent(content);
		article.setCreatetime(time);
		//返回界面
		boolean result = nas.insertNew(article);
		String test = "";
		if(result){
			request.setAttribute("infonewsAdd","文章添加成功!");

		}else{
			request.setAttribute("infonewsAdd", "文章添加失败!");

		}
		request.getRequestDispatcher("/CateMgShowServlet2").forward(request, response);

	}
}