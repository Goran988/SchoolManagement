package org.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import org.school.commons.BaseEntity;

@Entity
public class Professor extends BaseEntity {

	
	@OneToOne(mappedBy="professor")
	private Course teachingClass;

	public Course getTeachingClass() {
		return teachingClass;
	}
	public void setTeachingClass(Course teachingClass) {
		this.teachingClass = teachingClass;
	}
	
	

}
