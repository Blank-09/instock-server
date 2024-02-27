package com.aspirecoders.instock.service;

import com.aspirecoders.instock.model.User;
import com.aspirecoders.instock.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  public Optional<User> getUserById(String id) {
    return userRepo.findById(id);
  }

  public User createUser(User user) {
    return userRepo.save(user);
  }

  public User updateUser(String id, User user) {
    Optional<User> existingUser = userRepo.findById(id);
    if (existingUser.isPresent()) {
      User updatedUser = existingUser.get();
      updatedUser.setFirstName(user.getFirstName());
      updatedUser.setLastName(user.getLastName());
      updatedUser.setEmail(user.getEmail());
      updatedUser.setPassword(user.getPassword());
      return userRepo.save(updatedUser);
    } else {
      throw new IllegalArgumentException("User not found with id: " + id);
    }
  }

  public void deleteUser(String id) {
    userRepo.deleteById(id);
  }

  public ResponseEntity<User> login(String email, String password) {
    Optional<User> user = userRepo.findByEmail(email);

    if (user.isPresent()) {
      User foundUser = user.get();
      boolean isEqual = foundUser.getPassword().equals(password);

      if (isEqual) {
        return ResponseEntity.ok(foundUser);
      } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  public ResponseEntity<User> register(User user) {
    Optional<User> existingUser = userRepo.findByEmail(user.getEmail());

    if (existingUser.isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    User newUser = userRepo.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
  }

}
