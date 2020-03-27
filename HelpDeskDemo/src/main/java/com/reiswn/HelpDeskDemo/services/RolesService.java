package com.reiswn.HelpDeskDemo.services;

import java.util.List;

import com.reiswn.HelpDeskDemo.models.Role;
import com.reiswn.HelpDeskDemo.models.User;

public interface RolesService {

	
	public List<Role> findAll();
	public Role create(Role role);
	Boolean delete(Long id);
	public Role findByName(String name);
	public Role show(Long id);
	public Boolean update(Long id, Role role);
}