package com.reiswn.HelpDeskDemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.reiswn.HelpDeskDemo.models.Ticket;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

	@Query(value = "select ticket.* from tickets as ticket where ticket.created >= date(now()) - interval (:day) day", nativeQuery = true)
	public List<Ticket> findAllTicketsByDay(@Param("day") Integer day);
	
}
