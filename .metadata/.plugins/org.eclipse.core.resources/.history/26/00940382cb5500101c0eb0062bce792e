package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");

		name.toUpperCase();

		String result = "Hey! v3" + name;

		model.addAttribute("message", result);

		return "helloworld";
	}

	@PostMapping("/processFormVersionThree")
	public String letsShoutDudeV2(@RequestParam("studentName") String name, Model model) {
		name.toUpperCase();

		String result = "Hey! v3 " + name;

		model.addAttribute("message", result);

		return "helloworld";
	}
}
