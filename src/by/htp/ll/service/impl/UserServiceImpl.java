package by.htp.ll.service.impl;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;
import by.htp.ll.dao.DAOException;
import by.htp.ll.dao.DAOProvider;
import by.htp.ll.dao.UserDAO;
import by.htp.ll.dao.impl.SQLUserDAO;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User authorization(String login, String password) throws ServiceException {
		//validation
		//if(login == null || "".equals(login)) {
		//	throw new ServiceException("wrong login or password");
		//}
		
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		
		User user = null;
		try {
			user = userDAO.authorization(login, password);
		}catch(DAOException e) {
			throw new ServiceException("error", e);
		}
		return user;
	}

	@Override
	public void registration(User userInfo) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		
		try {
			
			userDAO.registration(userInfo);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
		
	}

}
