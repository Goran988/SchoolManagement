package org.school.dao.interfaces;

import java.util.Set;

import org.school.dao.generic.GenericDao;
import org.school.model.Admin;
import org.school.model.Course;
import org.school.model.Professor;
import org.school.model.Student;

public interface AdminInterface extends GenericDao<Admin, Long> {
	Admin getUserByUsername(String username);
	void addNewCourse(Course course);
	void deleteInterface(Course course);
	void assignCourse(Professor professor, Course course);
	void addNewProfessor(Professor professor);
	void approveStudent(Student students);
}
