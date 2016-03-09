package org.school.dao.impl;

import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.school.dao.generic.GenericDaoImpl;
import org.school.dao.interfaces.CourseInterface;
import org.school.model.Course;
import org.springframework.stereotype.Repository;
@Repository
public class CourseImpl extends GenericDaoImpl<Course, Long> implements CourseInterface {

	public CourseImpl() {
		super(Course.class);
	}

}
