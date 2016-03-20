package org.school.controller;

import java.security.Principal;

import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Admin;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	@Autowired
	private AdminInterface adminImpl;
	@Autowired
	private StudentInterface studentImpl;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String returnRegister(Model model, Student student) {
		model.addAttribute("student", student);
		student.setAuthority("ROLE_STUDENT");
		student.setEnabled(false);
		studentImpl.save(student);
		return "home";
	}
}
