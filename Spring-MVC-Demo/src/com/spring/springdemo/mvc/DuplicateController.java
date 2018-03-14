package com.spring.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DuplicateController {
	
	// trying to break the code by adding a duplicate route
	@RequestMapping("/processForm")
	public String displayForm() {
		return "silly";
	}
	
}
