package com.reiswn.HelpDeskDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reiswn.HelpDeskDemo.models.Role;

@Controller
@RequestMapping("/roles")
public class RoleController {

	
	@GetMapping
	public String index(Model model) {
		return "roles/index";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("role", new Role());
		return "roless/create";
	}
	
//	@GetMapping("/{id}")
//	public String edit(@PathVariable("id") Long id, Model model) {
//		return "roles/edit";
//	}
	
	@PostMapping
	public String save(Model model) {
		return null;
	}
	
	
	@DeleteMapping
	public String delete(Model model) {
		return null;
	}
	
	
}
