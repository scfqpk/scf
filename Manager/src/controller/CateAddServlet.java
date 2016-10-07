package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import service.CateAddService;


@SuppressWarnings("serial")
public class CateAddServlet extends HttpServlet {
	private Category cate = new Category();
	private CateAddService cas = new CateAddService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取参数
		String cateName = request.getParameter("catename");
		//数据封装
		cate.setCatename(cateName);
		//2.调用service
		boolean result = cas.insertCat(cate);
		//3.返回的页面
		String test="";

		if(result){
			test="success";
		}else{	
			test="fail";
		}
		PrintWriter out=response.getWriter();
		out.print(test);
		out.flush();
		out.close();
		}
	}
	
