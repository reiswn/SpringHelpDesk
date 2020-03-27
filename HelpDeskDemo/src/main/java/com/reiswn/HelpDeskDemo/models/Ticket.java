package com.reiswn.HelpDeskDemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
    @NotEmpty(message = "Can not be empty")    	
	private String name;
	
	@Column
    @NotEmpty(message = "Can not be empty")    	
	private String description;
	
	@Column  	
	private Date created;
	
	@Column
	private Date closed;
	
	@Column
	private Boolean finished = false;
	
	@ManyToOne 
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User userOpen;
	
	@ManyToOne
	@JoinColumn(name = "technician_id")
	@JsonBackReference
	private User technician;

	@PrePersist
	public void prePersist() {
		this.setCreated(new Date());
	}
	
	public Ticket() {
		
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the closed
	 */
	public Date getClosed() {
		return closed;
	}

	/**
	 * @param closed the closed to set
	 */
	public void setClosed(Date closed) {
		this.closed = closed;
	}

	/**
	 * @return the finished
	 */
	public Boolean getFinished() {
		return finished;
	}

	/**
	 * @param finished the finished to set
	 */
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	/**
	 * @return the userOpen
	 */
	public User getUserOpen() {
		return userOpen;
	}

	/**
	 * @param userOpen the userOpen to set
	 */
	public void setUserOpen(User userOpen) {
		this.userOpen = userOpen;
	}

	/**
	 * @return the technician
	 */
	public User getTechnician() {
		return technician;
	}

	/**
	 * @param technician the technician to set
	 */
	public void setTechnician(User technician) {
		this.technician = technician;
	}
	
	
	
}
