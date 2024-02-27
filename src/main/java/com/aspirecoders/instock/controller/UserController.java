package com.aspirecoders.instock.controller;

import com.aspirecoders.instock.model.User;
import com.aspirecoders.instock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody User user) {
    return userService.login(user.getEmail(), user.getPassword());
  }

  @PostMapping("/register")
  public ResponseEntity<User> postMethodName(@RequestBody User user) {
    return userService.register(user);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable String id) {
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable String id, @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable String id) {
    userService.deleteUser(id);
  }

}
