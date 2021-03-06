package com.dao.jpa;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CloudsDao;

@Repository
public class JpaCloudsDaoImpl extends JpaBaseDaoImpl implements CloudsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public int getCloudsCount(){
		String hql = "SELECT COUNT(*) FROM CloudsDTO";
		Query query =  getSessionFactory().openSession().createQuery(hql);	
		return ((Long) query.uniqueResult()).intValue();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
