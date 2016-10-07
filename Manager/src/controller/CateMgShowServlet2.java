package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import service.CateAddService;

@SuppressWarnings("serial")
public class CateMgShowServlet2 extends HttpServlet {
	private CateAddService cas = new CateAddService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取数据
		Category category = null;
		//2.调用service
		List<Map<String,Object>> results = cas.queryCats(category);
		//3.返回界面
		request.setAttribute("cates", results);
		
		request.getRequestDispatcher("/manager/newsAdd/tab.jsp").forward(request, response);
	}
		
	}
