package by.htp.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.ex.bean.News;
import by.htp.ex.dao.NewsDAO;
import by.htp.ex.dao.NewsDAOException;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	@Transactional
	public List<News> getNews() throws ServiceException {

		try {
			return newsDAO.getNews();
			
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public void saveNews(News theCustomer) throws ServiceException {

		try {
			newsDAO.saveNews(theCustomer);
			
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public News getNews(int id) throws ServiceException {

		try {
			return newsDAO.getNews(id);
			
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<News> getLatestNews(int count) throws ServiceException {

		try {
			return newsDAO.getLatestNews(count);
			
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public void deleteNews(String[] idNews) throws ServiceException {

		try {
			newsDAO.deleteNews(idNews);
			
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

}
