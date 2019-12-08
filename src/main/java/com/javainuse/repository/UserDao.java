package com.javainuse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.DAOUser;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	 DAOUser findDAOUserById(Long id);
	DAOUser findByUsername(String username);
	DAOUser findByEmail(String email);
}
