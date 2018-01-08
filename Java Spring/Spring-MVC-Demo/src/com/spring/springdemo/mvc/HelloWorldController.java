package com.spring.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.net.httpserver.HttpServer;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// another method of retrieving data from a form
	@RequestMapping("/processFormV2")
	public String shoutTheName(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "HELLO! " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormV3")
	public String processFormV3(@RequestParam("studentName") String theName, Model model) {
		
		// @RequestParam already assign the parameter to theName
//		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "HEY UR NAME IS: " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
