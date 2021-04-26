package by.htp.ll.service.impl;

import java.util.List;

import by.htp.ll.bean.News;
import by.htp.ll.dao.DAOException;
import by.htp.ll.dao.DAOProvider;
import by.htp.ll.dao.NewsDAO;
import by.htp.ll.service.NewsService;
import by.htp.ll.service.ServiceException;

public class NewsServiceImpl implements NewsService{

	@Override
	public List<News> takeAll() throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		List<News> news;
		try {
			news = newsDAO.all();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return news;
	}

	@Override
	public News takeOne(int id) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		News oneNews = null;
		
		try {
			oneNews = newsDAO.takeOne(id);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return oneNews;
	}

	@Override
	public void updateNews(int id, String title, String brief, String content) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		News oneNews = null;
		
		try {
			newsDAO.updateNews(id, title, brief, content);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void deleteNews(int id) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		try {
			newsDAO.deleteNews(id);
			
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

}
