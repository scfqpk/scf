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
public class CateMgDeleteAllServlet extends HttpServlet {
	private CateMgService cms = new CateMgService();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Ids = request.getParameter("ids");
		boolean result = cms.deleteAllCat(Ids);
		String test  = "";
		if(result){
			test= "success";
			
		}else{
			test= "fail";
		}
		PrintWriter out = response.getWriter();
		out.print(test);
		out.flush();
		out.close();
	}
}