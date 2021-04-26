package by.htp.ll.service;

import java.util.List;
import by.htp.ll.bean.News;

public interface NewsService {
	List<News> takeAll() throws ServiceException;
	News takeOne(int id) throws ServiceException;
	void updateNews(int id, String title, String brief, String content) throws ServiceException;
	void deleteNews(int id) throws ServiceException;
}
