package com.reiswn.HelpDeskDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reiswn.HelpDeskDemo.models.Role;
import com.reiswn.HelpDeskDemo.services.RolesService;

@Controller
@RequestMapping("/roles")
@PreAuthorize("hasAuthority('ADMIN')")
public class RoleController {

	@Autowired

	private RolesService roleService;

	public RoleController(RolesService roleService) {
		this.roleService = roleService;
	}
	
	/* INDEX */
	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", this.roleService.findAll());
		return "roles/index";
	}

	/* CREATE */
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("role", new Role());
		return "roles/create";
	}

	/* SAVE */
	@PostMapping
	public String save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "roles/create";
		}

		Role roleCreated = this.roleService.create(role);
		System.out.println(roleCreated);

		return "redirect:/roles";
	}
	
	/* UPDATE */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("role") Role role,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "roles/edit";
		}

		this.roleService.update(id, role);

		return "redirect:/roles";
	}

	/* DELETE */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, Model model) {
		// Role role = this.roleService.findById(id);
		this.roleService.delete(id);

		return "redirect:/roles";
	}

}
