package com.reiswn.HelpDeskDemo.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Can not be empty")
	private String email;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private String name;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private String lastName;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	@Length(min = 5, message = "You need to provide a password that contains at least 5 characters")
	private String password;
	
	@Column
	private Boolean active = true;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@Column
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userOpen")
	private Set<Ticket> tickets;
	
	@Column
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "technician")
	private Set<Ticket> ticketsTechnician;
	
	@Column
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userInteraction")
	private Set<Interaction> interactions;
	
	public User() {}
	
	public User(String email, String name, String lastName, String password, Boolean active) {
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
	}
	
	public User(Long id, String email, String name, String lastName, String password, Boolean active) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
