package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsMgDao;

import entity.Article;

public class NewsModifyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsModifyServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取数据
		String id = request.getParameter("id");
		//字符串转化成数值
		int articleID = Integer.parseInt(id);
		String title = request.getParameter("title");
		String keywords = request.getParameter("keywords");
		String writer = request.getParameter("writer");
       //2.javabean封装
		Article art=new Article();
		art.setArticleID(articleID);
		art.setTitle(title);
		art.setKeywords(keywords);
		art.setWriter(writer);
		//3.调用service
	    NewsMgDao nmd=new NewsMgDao();
	    boolean result=nmd.updatenews(art);
	    if(result){
	    	request.setAttribute("info", "修改成功");
	        request.getRequestDispatcher("/manager/new.jsp").forward(request, response);
	    }else{
		 request.setAttribute("info", "修改失败");
	 }
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
