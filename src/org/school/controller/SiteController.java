package org.school.controller;

import java.security.Principal;

import org.school.commons.BaseEntity;
import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Admin;
import org.school.model.Professor;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SiteController {
	@Autowired
	private AdminInterface adminImpl;
	@Autowired
	private StudentInterface studentImpl;

	@RequestMapping({ "/", "home" })
	public String getHome() {
//		  Admin testAdmin=new Admin();
//		  testAdmin.setFirstName("Pajdo");
//		  testAdmin.setLastName("Pajdic");
//		  testAdmin.setUsername("goran");
//		  testAdmin.setPassword("goran");
//		  testAdmin.setEnabled(true);
//		  testAdmin.setAuthority("ROLE_ADMIN");
//		  adminImpl.save(testAdmin);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String authority = ((UserDetails) principal).getAuthorities().toArray()[0].toString();
			if (authority.equals("ROLE_STUDENT")) {
				return "student";
			} else if (authority.equals("ROLE_PROFESSOR")) {
				return "professor";
			} else if (authority.equals("ROLE_ADMIN")) {
				return "redirect:admin";
			}
		}

		return "home";

	}

	// @RequestMapping("/home")
	// public String returnTestOne(Principal principal) {
	// System.out.println(principal.getName());
	//
	// return "test1";
	// }

	@RequestMapping("/test2")
	public String returnTestTwo() {
		// Student student = new Student();
		// student.setFirstName("Student");
		// student.setLastName("StudentPrezime");
		// student.setUsername("student");
		// student.setPassword("student");
		// student.setAuthority("ROLE_STUDENT");
		// student.setEnabled(true);
		// studentImpl.save(student);
		return "test2";
	}

	@RequestMapping("/registrationForm")
	public String returnRegForm(@ModelAttribute("student") Student student) {
		return "registerStudent";
	}

}
