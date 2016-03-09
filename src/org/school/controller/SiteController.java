package org.school.controller;

import org.school.dao.interfaces.AdminInterface;
import org.school.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

}
