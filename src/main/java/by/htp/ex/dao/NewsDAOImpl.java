package by.htp.ex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.ex.bean.News;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getNews() throws NewsDAOException {
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<News> theQuery = currentSession.createQuery("from News order by date desc");
			List<News> theNews = theQuery.getResultList();
			
			return theNews;
			
		} catch (Exception e) {
			throw new NewsDAOException(e);
		}
	}

	@Override
	public void saveNews(News theNews) throws NewsDAOException {
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theNews);

		} catch (Exception e) {
			throw new NewsDAOException(e);
		}
	}

	@Override
	public News getNews(int id) throws NewsDAOException {
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			News theNews = currentSession.get(News.class, id);

			return theNews;

		} catch (Exception e) {
			throw new NewsDAOException(e);
		}
	}

	@Override
	public void deleteNews(String[] idNews) throws NewsDAOException {
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();

			for (String id : idNews) {

				Query theQuery = currentSession.createQuery("delete from News where id=:id");
				theQuery.setParameter("id", Integer.parseInt(id));
				theQuery.executeUpdate();
			}
		} catch (Exception e) {
			throw new NewsDAOException(e);
		}

	}

	@Override
	public List<News> getLatestNews(int count) throws NewsDAOException {
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<News> theQuery = currentSession.createQuery("from News order by date desc");
			theQuery.setMaxResults(count);

			List<News> theNews = theQuery.getResultList();

			return theNews;
			
		} catch (Exception e) {
			throw new NewsDAOException(e);
		}
	}

}
