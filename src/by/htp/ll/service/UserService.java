package by.htp.ll.service;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;

public interface UserService {

	User authorization (String login, String password) throws ServiceException;
	void registration (User userInfo)throws ServiceException;
	
}
