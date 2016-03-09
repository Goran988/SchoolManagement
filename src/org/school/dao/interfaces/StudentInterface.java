package org.school.dao.interfaces;

import java.util.Set;

import org.school.dao.generic.GenericDao;
import org.school.model.Course;
import org.school.model.Grade;
import org.school.model.Student;

public interface StudentInterface extends GenericDao<Student, Long> {
	void applyForCourse(Student student, Course course);

	Set<Grade> checkGrades(Student student);

	Student findByUsername(String username);
}
