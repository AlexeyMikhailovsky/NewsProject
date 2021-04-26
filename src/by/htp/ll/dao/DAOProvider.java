package by.htp.ll.dao;

import by.htp.ll.dao.impl.SQLNewsDAO;
import by.htp.ll.dao.impl.SQLUserDAO;

public final class DAOProvider {
	
	private static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new SQLUserDAO();
	private final NewsDAO newsDAO = new SQLNewsDAO();

	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
	
	
}
