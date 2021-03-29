package by.htp.ll.service;

import by.htp.ll.bean.Book;

public interface LibraryService {

	Book find (String title)throws ServiceException;
}
