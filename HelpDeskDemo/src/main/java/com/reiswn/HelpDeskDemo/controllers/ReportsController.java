package com.reiswn.HelpDeskDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reiswn.HelpDeskDemo.services.TicketService;

@Controller
@RequestMapping("/reports")
public class ReportsController {

	@Autowired
	private TicketService ticketService;
	
	public ReportsController(TicketService ticketService) {
		this.ticketService = ticketService;
	}



	@GetMapping("/tickets")
	public String ticketReport(@RequestParam(required = false, value = "day") Integer day, Model model) {
		model.addAttribute("list", this.ticketService.reportTicketByDays(day));
		return "reports/ticket";
	}
}
