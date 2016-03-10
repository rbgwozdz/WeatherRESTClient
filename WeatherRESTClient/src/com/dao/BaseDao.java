package com.dao;

import java.util.List;

public interface BaseDao {
	//public List listAll(Class clazz);

	//public List listAllByName(Class clazz);

	//public Object find(Class clazz, Long id);

	//public Object find(Class clazz, String id);

	//public void save(Object obj);

	public Object create(Object obj);

	public void remove(Object obj);

	public void remove(Class clazz, Long id);

	//public void remove(Class clazz, String id);

	//public Long count(Class clazz);
}
