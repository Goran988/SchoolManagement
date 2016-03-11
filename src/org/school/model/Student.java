package org.school.model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.school.commons.BaseEntity;

@Entity
public class Student extends BaseEntity {

	@ManyToMany(cascade = CascadeType.ALL)
	Set<Course> classes = new HashSet<>();
	@ManyToMany
	Set<Course> appliedForClasses = new HashSet<>();
	@OneToMany
	Set<Grade> grades = new TreeSet<>();

	public Set<Course> getClasses() {
		return classes;
	}

	public void setClasses(Set<Course> classes) {
		this.classes = classes;
	}

	public Set<Course> getAppliedForClasses() {
		return appliedForClasses;
	}

	public void setAppliedForClasses(Set<Course> appliedForClasses) {
		this.appliedForClasses = appliedForClasses;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

}
