package org.school.controller;

import java.util.List;
import java.util.Map;

import org.school.dao.interfaces.AdminInterface;
import org.school.dao.interfaces.StudentInterface;
import org.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminController {

	@Autowired
	private AdminInterface adminImpl;
	@Autowired
	private StudentInterface studentImpl;

	@RequestMapping("/admin")
	public String showAdmin() {

		return "admin";
	}

	@RequestMapping("/pending")
	public String showPending(Model model) {
		List<Student> pendingStudents = adminImpl.getAllPending();
		model.addAttribute("students", pendingStudents);
		return "admin/decidePending";
	}

	@ResponseBody
	@RequestMapping(value = "/aproveDecline", method = RequestMethod.POST)
	public String aproveDeclinePending(@RequestBody Map<String, Object> data) {
		String value = (String) data.get("value");
		String decision = value.substring(0, 6);
		String username = value.substring(7);
		Student student = studentImpl.findByUsername(username);
		if (student != null) {
			adminImpl.approveStudent(student, decision);

			return "";
		}
		return "";
	}
}
