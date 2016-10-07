package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Category;
import service.CateMgService;

@SuppressWarnings("serial")
public class CateMgDeleteServlet extends HttpServlet {
	public static final String EDIT = "edit";
	public static final String DELETE = "delete";
	private CateMgService cms = new CateMgService();
	private Category category = new Category();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		//封装
		int Id = Integer.parseInt(id);
		category.setCateID(Id);
		
			boolean result = cms.deleteCat(category);
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



