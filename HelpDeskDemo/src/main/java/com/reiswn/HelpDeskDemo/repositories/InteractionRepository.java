package com.reiswn.HelpDeskDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reiswn.HelpDeskDemo.models.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction, Long>{

}
