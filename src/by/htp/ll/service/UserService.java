package by.htp.ll.service;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;

public interface UserService {

	User authorization (String login, String passport) throws ServiceException;
	boolean registration (RegistrationInfo regInfo)throws ServiceException;
}
