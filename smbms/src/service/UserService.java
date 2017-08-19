package service;

import tool.ResultData;
import entity.User;

public interface UserService {
	User getUserById(Long id);
	
	ResultData isLogin(String usercode,String userpassword);
	
	ResultData getUsers();
	
	ResultData addUser(User u);
	
	ResultData delUser(Long id);
	
	ResultData updateUser(User u);
}
