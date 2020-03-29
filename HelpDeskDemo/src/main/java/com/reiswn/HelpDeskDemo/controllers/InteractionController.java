package com.reiswn.HelpDeskDemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reiswn.HelpDeskDemo.models.Interaction;
import com.reiswn.HelpDeskDemo.services.InteractionService;

@Controller
@RequestMapping("/tickets/{ticketId}/interactions")
public class InteractionController {

	@Autowired
	private InteractionService interactionService;
	
	public InteractionController(InteractionService interactionService) {
		this.interactionService = interactionService;
	}
	
	@PostMapping
	public String save(@PathVariable("ticketId") Long ticketId, @Valid @ModelAttribute("interaction") Interaction interaction, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "ticket/show";
		}
		
		this.interactionService.create(interaction, ticketId);
		
		return "redirect:/tickets/" + ticketId;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("ticketId") Long ticketId, @PathVariable("id") Long id, Model model) {
		this.interactionService.delete(id, ticketId);
		
		return "redirect:/tickets/" + ticketId;
	}
	
}
