package com.reiswn.HelpDeskDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reiswn.HelpDeskDemo.models.Role;
import com.reiswn.HelpDeskDemo.repositories.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository repository;
	
	public RolesServiceImpl(RolesRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role create(Role role) {
		role.setName(role.getName().toUpperCase());
		Role roleCreated = this.repository.save(role);
		return roleCreated;
	}

	
	
}
