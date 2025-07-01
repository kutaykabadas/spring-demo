package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("theDate", java.time.LocalDateTime.now());

		return "helloworld";
	}
	
}
