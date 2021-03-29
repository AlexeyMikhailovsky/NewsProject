package by.htp.ll.dao;

import by.htp.ll.bean.Book;

public interface LibraryDAO {

	Book find (String author)throws DAOException;
	boolean save (Book newBook)throws DAOException;
}
