package org.school.dao.impl;

import java.util.Set;

import org.hibernate.Query;
import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Course;
import org.school.model.Grade;
import org.school.model.Student;

public class StudentImpl extends GenericDaoImpl<Student, Long> implements StudentInterface {

	public StudentImpl() {
		super(Student.class);
	}

	

	@Override
	public Set<Grade> checkGrades(Student student) {
		// TODO Auto-generated method stub
		return student.getGrades();
	}

	@Override
	public Student findByUsername(String username) {
		Query query=sessionFactory.getCurrentSession().createQuery("FROM users WHERE username=:username");
		query.setParameter("username", username);
		return (Student)query.uniqueResult();
	}



	@Override
	public void applyForCourse(Student student, Course course) {
	student.getClasses().add(course);
		
	}
	

}
