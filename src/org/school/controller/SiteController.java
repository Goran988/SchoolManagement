package org.school.controller;

import org.school.dao.interfaces.AdminInterface;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/")
	public String getHome() {
		return "home";
	}

	@RequestMapping("/test1")
	public String returnTestOne() {
//		Admin fucker=new Admin();
//		fucker.setFirstName("Pajdo");
//		fucker.setLastName("Pajdic");
//		fucker.setUsername("goran");
//		fucker.setPassword("goran");
//		fucker.setEnabled(true);
//		fucker.setAuthority("ROLE_ADMIN");
//		adminImpl.save(fucker);
		return "test1";
	}

	@RequestMapping("/test2")
	public String returnTestTwo() {
		return "test2";
	}
	@RequestMapping("/registrationForm")
	public String returnRegForm(@ModelAttribute("student") Student student){
		return "registerStudent";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String returnRegister(  BindingResult br, Model model){
		model.addAttribute("student",new Student());
		return "home";
	}
	

}
