package org.school.dao.impl;

import java.util.List;

import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.CourseInterface;
import org.school.model.Admin;
import org.school.model.Course;
import org.school.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AdminImpl extends GenericDaoImpl<Admin, Long> implements AdminInterface {
	@Autowired
	private CourseInterface courseInterface;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AdminImpl() {
		super(Admin.class);
	}

	@Override
	public Admin getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public void addNewCourse(Course course) {
		courseInterface.save(course);
		
	}

	@Override
	public void deleteInterface(Course course) {
		courseInterface.delete(course);
		
	}

	@Override
	public void assignCourse(Professor professor, Course course) {
		professor.setTeachingClass(course);
		
	}


	
}
