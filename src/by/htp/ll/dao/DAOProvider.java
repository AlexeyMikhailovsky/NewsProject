package by.htp.ll.dao;

import by.htp.ll.dao.impl.SQLLibraryDAO;
import by.htp.ll.dao.impl.SQLUserDAO;

public final class DAOProvider {
	
	private static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new SQLUserDAO();
	private final LibraryDAO libraryDAO = new SQLLibraryDAO();

	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public LibraryDAO getLibraryDAO() {
		return libraryDAO;
	}
	
	
}
