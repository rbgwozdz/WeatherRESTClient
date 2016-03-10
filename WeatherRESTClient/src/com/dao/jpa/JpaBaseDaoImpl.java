package com.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.BaseDao;

@Repository
public class JpaBaseDaoImpl implements BaseDao
{

	@Autowired
	private SessionFactory sessionFactory;

	protected static final Log LOG = LogFactory.getLog(JpaBaseDaoImpl.class);

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz)
	{
		return (List<T>) getSessionFactory().openSession().createQuery("from " + clazz.getSimpleName());
	}

/*	public List listAll(Class clazz)
	{
		return getJpaTemplate().find("from " + clazz.getSimpleName());
	}

	@SuppressWarnings("unchecked")
	public Object find(Class clazz, Long id)
	{
		return getJpaTemplate().find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public Object find(Class clazz, String id)
	{
		return getJpaTemplate().find(clazz, id);
	}

	public void save(Object obj)
	{
		LOG.info("merge: " + obj.getClass().getSimpleName());
		getJpaTemplate().merge(obj);
	}
*/
	public Object create(Object obj)
	{
		LOG.info("persist: " + obj.getClass().getSimpleName());
		getSessionFactory().openSession().save(obj);
		return obj;
	}

	public void remove(Object obj)
	{
		getSessionFactory().openSession().delete(obj);
	}
	
	@SuppressWarnings("unchecked")
	public void remove(Class clazz, Long id)
	{
		getSessionFactory().openSession().delete(clazz.getSimpleName(), id);
	}

	@SuppressWarnings("unchecked")
	public void remove(Class clazz, String id)
	{
		getSessionFactory().openSession().delete(clazz.getSimpleName(), id);
	}

/*	public Long count(final Class clazz)
	{
		return (Long) getJpaTemplate().execute(new JpaCallback()
		{
			public Object doInJpa(EntityManager entityManager) throws PersistenceException
			{
				return entityManager.createQuery("SELECT COUNT(o) FROM " + clazz.getSimpleName() + " o").getSingleResult();
			}
		});
	}

	public List listAllByName(Class clazz)
	{
		return getJpaTemplate().find("from " + clazz.getSimpleName() + " a ORDER BY a.name ASC");
	}
*/	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
