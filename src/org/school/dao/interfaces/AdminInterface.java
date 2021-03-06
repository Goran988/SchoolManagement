package org.school.dao.interfaces;

import java.util.List;

import org.school.dao.generic.GenericDao;
import org.school.model.Admin;
import org.school.model.Course;
import org.school.model.Professor;
import org.school.model.Student;

public interface AdminInterface extends GenericDao<Admin, Long> {
	Admin getAdminByUsername(String username);

	void addNewCourse(Course course);

	void deleteCourse(Course course);

	void assignCourse(Professor professor, Course course);

	void addNewProfessor(Professor professor);

	List<Student> getAllPending();

	void approveStudent(Student students, String decision);

	void removePending(Student student);
}
