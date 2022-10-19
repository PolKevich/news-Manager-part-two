package by.htp.ex.dao;

import java.util.List;

import by.htp.ex.bean.News;

public interface NewsDAO {

	public List<News> getNews() throws NewsDAOException;

	public List<News> getLatestNews(int count) throws NewsDAOException;

	public void saveNews(News theCustomer) throws NewsDAOException;

	public News getNews(int id) throws NewsDAOException;

	public void deleteNews(String[] idNews) throws NewsDAOException;

}
