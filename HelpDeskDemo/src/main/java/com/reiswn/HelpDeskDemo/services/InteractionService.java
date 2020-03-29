package com.reiswn.HelpDeskDemo.services;

import com.reiswn.HelpDeskDemo.models.Interaction;

public interface InteractionService {

	public Interaction create(Interaction interaction, Long ticketId);
	public Boolean delete(Long id, Long ticketId);
	
}
