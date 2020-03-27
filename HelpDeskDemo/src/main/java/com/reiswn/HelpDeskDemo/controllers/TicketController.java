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

import com.reiswn.HelpDeskDemo.models.Ticket;
import com.reiswn.HelpDeskDemo.services.RolesService;
import com.reiswn.HelpDeskDemo.services.TicketService;
import com.reiswn.HelpDeskDemo.services.UserService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService roleService;
	
	public TicketController(TicketService ticketService, UserService userService) {
		this.ticketService = ticketService;
		this.userService = userService;
	}
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", this.ticketService.findAll());
	//	model.addAttribute("userLoggedIn", this.userService.findCurrentUser());
		return "ticket/index";
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Ticket ticket = this.ticketService.show(id);
		//List<Interaction> interactions = ticket.getInteractions();
		
		model.addAttribute("ticket", ticket);
		//model.addAttribute("interaction", new Interaction());
		//model.addAttribute("interactions", interactions);
		//model.addAttribute("userLoggedIn", this.userService.findCurrentUser());		
		
		return "ticket/show";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		//Ticket ticket = this.ticketService.show(id);
		//List<Interaction> interactions = ticket.getInteractions();
		
		model = this.ticketService.findAllTechinician(model);
		model.addAttribute("ticket", this.ticketService.show(id));
		//model.addAttribute("interactions_count", interactions.size());		
		//model.addAttribute("userLoggedIn", this.userService.findCurrentUser());		
		
		return "ticket/edit";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model = this.ticketService.findAllTechinician(model);
		model.addAttribute("ticket", new Ticket());
		return "ticket/create";
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "ticket/create";
		}
		
		this.ticketService.create(ticket);
		
		return "redirect:/tickets";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "ticket/edit";
		}
		
		this.ticketService.update(id, ticket);
		
		return "redirect:/tickets";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, Model model) {
		this.ticketService.delete(id);
		
		return "redirect:/tickets";
	}
}
