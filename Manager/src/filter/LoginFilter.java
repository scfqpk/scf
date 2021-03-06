package filter;


import java.io.IOException;
import Const.Const;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		String uName = (String)request.getSession().getAttribute(Const.USER_SESSION);
		if(uName != null){
			arg2.doFilter(arg0, arg1);
		}else{
			request.getRequestDispatcher("/Login.jsp").forward(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
