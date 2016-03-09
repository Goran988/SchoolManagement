package org.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Grade {
	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	private Student student;

	@OneToOne
	private Course subject;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getSubject() {
		return subject;
	}

	public void setSubject(Course subject) {
		this.subject = subject;
	}
	
	

}
