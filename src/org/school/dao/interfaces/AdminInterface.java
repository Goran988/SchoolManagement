package org.school.dao.interfaces;

import org.school.dao.generic.GenericDao;
import org.school.model.Admin;
import org.school.model.Course;
import org.school.model.Professor;

public interface AdminInterface extends GenericDao<Admin, Long> {
	Admin getUserByUsername(String username);
	void addNewCourse(Course course);
	void deleteInterface(Course course);
	void assignCourse(Professor professor, Course course);
}
