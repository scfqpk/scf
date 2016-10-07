package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Login;

import service.LoginService;





@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	private LoginService ls = new LoginService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//1.获取界面的数据
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		Login lg=new Login();
		lg.setUsername(userName);
		lg.setPassword(passWord);
	
		//2.调用service层进行数据处理
		boolean result=ls.isExist(lg);
			if(result){
				request.getSession().setAttribute("username",userName);
				response.sendRedirect(request.getContextPath()+"/manager/cateMg/cateMg.jsp");
			}else{		
				request.setAttribute("info", "您的用户名和密码错误！");
				//请求转发
				request.getRequestDispatcher("/Login.jsp").forward(request,response);
			}

	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

