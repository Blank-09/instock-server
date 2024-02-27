package com.aspirecoders.instock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

  Optional<User> findByEmail(String email);

}
