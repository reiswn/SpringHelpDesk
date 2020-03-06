package com.reiswn.HelpDeskDemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column()
	@NotEmpty(message = "Can not be empty")
	private String roleName;
	
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public Role(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	
}
