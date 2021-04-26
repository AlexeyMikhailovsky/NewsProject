package by.htp.ll.dao;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;

public interface UserDAO {

	User authorization (String login, String password)throws DAOException;
	void registration (User userInfo)throws DAOException;
	
}
