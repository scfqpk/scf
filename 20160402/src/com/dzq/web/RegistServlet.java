package com.dzq.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dzq.domian.User;
import com.dzq.exception.MsgException;
import com.dzq.service.UserService;


@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService service=new UserService();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//1��������֤��
		String valistr=request.getParameter("valistr");
		String valistr2=(String) request.getSession().getAttribute("valistr");
		if(valistr==null||valistr2==null||!valistr.equals(valistr2)){
			request.setAttribute("msg", "��֤�벻��ȷ");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//2.��װ���ݣ�У������
		User user=new User();
		BeanUtils.populate(user, request.getParameterMap());
		user.checkValue();
		service.registUser(user);
		request.getSession().setAttribute("user", user);
		response.getWriter().write("��ϲ��ע��ɹ���3��ص���ҳ");
		response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		}catch(MsgException e){
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		//3.����service��������û�
		
		//4.��ʾע��ɹ���3����ת��ҳ
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
