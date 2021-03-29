package by.htp.ll.dao.impl;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;
import by.htp.ll.dao.DAOException;
import by.htp.ll.dao.UserDAO;

public class SQLUserDAO implements UserDAO{

	@Override
	public User authorization(String login, String password) throws DAOException {
		
		System.out.println("USER AUTHORIZATION");
		return new User();
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}
