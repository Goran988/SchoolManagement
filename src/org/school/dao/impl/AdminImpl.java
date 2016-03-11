package org.school.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.CourseInterface;
import org.school.dao.interfaces.ProfessorInterface;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Admin;
import org.school.model.Course;
import org.school.model.Professor;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AdminImpl extends GenericDaoImpl<Admin, Long> implements AdminInterface {
	@Autowired
	private CourseInterface courseInterface;
	@Autowired
	private ProfessorInterface professorInterface;
	@Autowired
	StudentInterface studentInterface;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AdminImpl() {
		super(Admin.class);
	}

	public Admin getUserByUsername(String username) {
		Criteria criteria = getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.eq("username", username));
		Admin admin = (Admin) criteria.uniqueResult();
		return admin;

	}

	@Override
	public Admin save(Admin entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		super.save(entity);
		return entity;
	}

	@Override
	public Admin get(Long id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public Admin update(Admin entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}


	@Override
	public void addNewCourse(Course course) {
		courseInterface.save(course);

	}

	@Override
	public void deleteCourse(Course course) {
		courseInterface.delete(course);

	}

	@Override
	public void assignCourse(Professor professor, Course course) {
		professor.setTeachingClass(course);

	}

	@Override
	public void addNewProfessor(Professor professor) {
		professorInterface.save(professor);

	}

	@Override
	public void approveStudent(Student student) {
		student.setEnabled(true);
		studentInterface.update(student);
	}

	@Override
	public List<Student> getAllPending() {
		Criteria criteria = getSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("enabled", false));
		return criteria.list();
	}

}
