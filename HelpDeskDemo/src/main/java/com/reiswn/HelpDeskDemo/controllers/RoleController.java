package com.reiswn.HelpDeskDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reiswn.HelpDeskDemo.models.Role;
import com.reiswn.HelpDeskDemo.services.RolesService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	
	private RolesService roleService;
	
	public RoleController(RolesService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", this.roleService.findAll());
		return "roles/index";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("role", new Role());
		return "roles/create";
	}
	
//	@GetMapping("/{id}")
//	public String edit(@PathVariable("id") Long id, Model model) {
//		return "roles/edit";
//	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "roles/create";
		}
		
		Role roleCreated = this.roleService.create(role);
		System.out.println(roleCreated);
		
		return "redirect:/roles";
	}
	
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		//Role role = this.roleService.findById(id);
		this.roleService.delete(id);
		
		return "redirect:/roles";
	}
	
	
}
