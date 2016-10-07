package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CateMgDao;
import entity.Category;
import entity.SpiltPage;
import service.CateAddService;


@SuppressWarnings("serial")
public class CateMgShowServlet extends HttpServlet {
	private CateAddService cas = new CateAddService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取数据
		String curpage=request.getParameter("curpage");
		int cur=1;
		try{
		cur=Integer.parseInt(curpage);
		}catch(NumberFormatException e){}
		SpiltPage sp=new SpiltPage();
		//2.调用service
		CateMgDao cmd=new CateMgDao();
		SpiltPage results = cmd.updateCat(cur);
		//3.返回界面
		request.setAttribute("page", results);
		
		request.getRequestDispatcher("/manager/cateMg/tab.jsp").forward(request, response);
	
	}
	
		

}
