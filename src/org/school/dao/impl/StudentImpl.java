package org.school.dao.impl;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Course;
import org.school.model.Grade;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
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
		return super.get(id);
	}

	@Override
	public Student update(Student entity) {
		return super.update(entity);
	}

	@Override
	public void delete(Student entity) {
		super.delete(entity);
	}

	@Override
	public Student saveOrUpdate(Student entity) {
		return super.saveOrUpdate(entity);
	}

	@Override
	public Set<Grade> checkGrades(Student student) {
		return student.getGrades();
	}

	@Override
	public Student findByUsername(String username) {
		Criteria crit = getSession().createCriteria(Student.class);
		crit.add(Restrictions.eq("username", username));
		return (Student) crit.uniqueResult();
	}


	@Override
	public void applyForCourse(Student student, Course course) {
		student.getClasses().add(course);

	}

	

}
