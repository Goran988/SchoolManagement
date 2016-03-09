package org.school.dao.generic;

import java.io.Serializable;
import java.util.List;

import org.school.model.Course;
import org.school.model.Student;

public interface GenericDao<T, ID extends Serializable> {

	T save(T entity);

	T get(ID id);

	T update(T entity);

	void delete(T entity);

	T saveOrUpdate(T entity);

	List<T> getAll();

}
