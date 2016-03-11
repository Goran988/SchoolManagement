package org.school.dao.impl;

import java.util.Set;

import org.hibernate.Query;
import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Course;
import org.school.model.Grade;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class StudentImpl extends GenericDaoImpl<Student, Long> implements StudentInterface {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public StudentImpl() {
		super(Student.class);
	}

	@Override
	public Student save(Student entity) {
		entity.setAuthority("ROLE_STUDENT");
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return super.save(entity);
	}

	@Override
	public Student get(Long id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public Student update(Student entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public Student saveOrUpdate(Student entity) {
		// TODO Auto-generated method stub
		return super.saveOrUpdate(entity);
	}

	@Override
	public Set<Grade> checkGrades(Student student) {
		// TODO Auto-generated method stub
		return student.getGrades();
	}

	@Override
	public Student findByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM users WHERE username=:username");
		query.setParameter("username", username);
		return (Student) query.uniqueResult();
	}

	@Override
	public void applyForCourse(Student student, Course course) {
		student.getClasses().add(course);

	}

}
