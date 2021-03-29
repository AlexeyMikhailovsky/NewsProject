package by.htp.ll.service;

import by.htp.ll.service.impl.LibraryServiceImpl;
import by.htp.ll.service.impl.UserServiceImpl;

public final class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private final UserService userService = new UserServiceImpl();
	private final LibraryService libraryService = new LibraryServiceImpl();
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}
	
}
