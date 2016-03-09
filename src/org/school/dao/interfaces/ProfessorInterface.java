package org.school.dao.interfaces;

import org.school.dao.generic.GenericDao;
import org.school.model.Professor;
import org.school.model.Student;

public interface ProfessorInterface extends GenericDao<Professor, Long> {

	public void assignGrade(Student student,int grade);

	public void markAbsence(Student student);

}
