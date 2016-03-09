package org.school.dao.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	@Autowired
	public SessionFactory sessionFactory;

	private Class<T> persistantClass;

	public Class<T> getPersistantClass() {
		return persistantClass;
	}
	

	public GenericDaoImpl(Class<T> persistantClass) {
		this.persistantClass = persistantClass;
	}


	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T save(T entity) {
		getSession().save(entity);
		return entity;

	}

	@Override
	public T get(ID id) {
		return getSession().get(getPersistantClass(), id);
	}

	@Override
	public T update(T entity) {
		getSession().update(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);

	}

	@Override
	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public List<T> getAll() {
		Query query = getSession().createQuery("FROM :persistantClass");
		query.setParameter("persistantClass", getPersistantClass());
		return query.list();
	}

}
