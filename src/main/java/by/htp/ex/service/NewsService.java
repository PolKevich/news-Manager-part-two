package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface NewsService {

	public List<News> getNews() throws ServiceException;
	
	public List<News> getLatestNews(int count)throws ServiceException;

	public void saveNews(News theCustomer) throws ServiceException;

	public News getNews(int id)throws ServiceException;

	public void deleteNews(String[] idNews)throws ServiceException;
	
}
