package com.reiswn.HelpDeskDemo.services;

import java.util.List;

import com.reiswn.HelpDeskDemo.models.Role;

public interface RolesService {

	
	public List<Role> findAll();
	public Role create(Role role);
	
}