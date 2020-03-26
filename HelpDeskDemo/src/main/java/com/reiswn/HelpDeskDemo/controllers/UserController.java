package com.reiswn.HelpDeskDemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reiswn.HelpDeskDemo.models.User;
import com.reiswn.HelpDeskDemo.models.Role;
import com.reiswn.HelpDeskDemo.services.RolesService;
import com.reiswn.HelpDeskDemo.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService rolesService;

	public UserController(UserService userService, RolesService rolesService) {
		this.rolesService = rolesService;
		this.userService = userService;
	}

	/* INDEX */
	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", this.userService.findAll());
		return "users/index";
	}

	/* CREATE */
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("user", new User());
		return "users/create";
	}

	/* SAVE */
	@PostMapping
	public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
	
		if (bindingResult.hasErrors()) {
			return "users/create";
		}

		User userCreated = this.userService.create(user);
		System.out.println(userCreated);

		return "redirect:/users";
	}
	
	/* EDIT */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		User user = this.userService.show(id);
		List<Role> roles = this.rolesService.findAll();
		
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		
		return "users/edit";
	}

	/* UPDATE */
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "users/edit";
		}

		this.userService.update(id, user);

		return "redirect:/users";
	}

	/* DELETE */
	@RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, Model model) {
		this.userService.delete(id);

		return "redirect:/users";
	}
}
