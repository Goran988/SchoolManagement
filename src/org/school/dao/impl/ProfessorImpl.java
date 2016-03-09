package org.school.dao.impl;

import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.ProfessorInterface;
import org.school.model.Professor;
import org.school.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorImpl extends GenericDaoImpl<Professor, Long> implements ProfessorInterface {

	public ProfessorImpl() {
		super(Professor.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assignGrade(Student student, int grade) {
		

	}

	@Override
	public void markAbsence(Student student) {
		// TODO Auto-generated method stub
		
	}
	
	

}
