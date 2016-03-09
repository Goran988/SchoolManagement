package org.school.model;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

public class Absence {
	@GeneratedValue
	private long id;
	
	@OneToOne
	private Student student;
	@OneToOne
	private Course classAbsent;
	private int numberOfAbsences;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getClassAbsent() {
		return classAbsent;
	}

	public void setClassAbsent(Course classAbsent) {
		this.classAbsent = classAbsent;
	}

	public int getNumberOfAbsences() {
		return numberOfAbsences;
	}

	public void setNumberOfAbsences(int numberOfAbsences) {
		this.numberOfAbsences = numberOfAbsences;
	}

	public void addAbsence() {
		numberOfAbsences++;
	}
}
