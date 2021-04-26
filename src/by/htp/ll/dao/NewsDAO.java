package by.htp.ll.dao;

import java.util.List;
import by.htp.ll.bean.News;

public interface NewsDAO {

	List<News> all() throws DAOException;
	
	News takeOne(int id) throws DAOException;
	
	void updateNews(int id, String title, String brief, String content) throws DAOException;
	
	void deleteNews(int id) throws DAOException;
}
