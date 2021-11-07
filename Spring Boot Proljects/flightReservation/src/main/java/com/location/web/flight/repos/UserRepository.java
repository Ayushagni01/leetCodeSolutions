package com.location.web.flight.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.web.flight.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
