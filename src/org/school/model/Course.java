package org.school.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private long id;

	String className;
	@ManyToMany
	Set<Student> students = new HashSet<>();
	@OneToOne
	Professor professor;
	@ManyToMany
	Set<Student> appliedStudents = new HashSet<>();

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Student> getAppliedStudents() {
		return appliedStudents;
	}

	public void setAppliedStudents(Set<Student> appliedStudents) {
		this.appliedStudents = appliedStudents;
	}

}
