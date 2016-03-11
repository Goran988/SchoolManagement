package org.school.controller;

import java.util.List;

import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired
	private AdminInterface adminImpl;
	@Autowired
	private StudentInterface studentImpl;

	@RequestMapping("/admin")
	public String showAdmin(){
		List<Student> list=adminImpl.getAllPending();
		for(Student s:list){
			System.out.println(s);
		}
		return "admin";
	}
}
