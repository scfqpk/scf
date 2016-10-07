package service;

import dao.LoginDao;
import entity.Login;

public class LoginService {
private LoginDao ld=new LoginDao();
public boolean isExist(Login lg){
	return ld.isExist(lg);
}
}
