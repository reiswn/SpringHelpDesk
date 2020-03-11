package com.reiswn.HelpDeskDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reiswn.HelpDeskDemo.models.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

}
