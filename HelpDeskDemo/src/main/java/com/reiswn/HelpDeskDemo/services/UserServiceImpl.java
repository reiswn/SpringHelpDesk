package com.reiswn.HelpDeskDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reiswn.HelpDeskDemo.models.User;
import com.reiswn.HelpDeskDemo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repository = repository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User create(User user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		return this.repository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		User user = findById(id);

		if (user != null) {
			this.repository.delete(user);
			return true;
		}

		return false;
	}

	@Override
	public Boolean update(Long id, User user) {
		User userExists = findById(id);

		if (userExists != null) {
			//pattern builder could be used
			userExists.setId(user.getId());
			userExists.setName(user.getName());
			userExists.setLastName(user.getLastName());
			userExists.setEmail(user.getEmail());
			userExists.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			userExists.setActive(user.getActive());
			
			this.repository.save(userExists);
			
			return true;
		}

		return false;
	}
	
	@Override
	public User show(Long id) {
		return this.repository.findById(id).orElse(null);
	}
	
	private User findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}
	
}