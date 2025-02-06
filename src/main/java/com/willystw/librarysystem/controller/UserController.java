package com.willystw.librarysystem.controller;

import com.willystw.librarysystem.model.CreateUserDto;
import com.willystw.librarysystem.model.UpdateUserDto;
import com.willystw.librarysystem.model.User;
import com.willystw.librarysystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<User> find(@PathVariable Long id) {
    User user = userService.findById(id);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(user);
  }

  @PostMapping("/create")
  public ResponseEntity<User> create(@RequestBody CreateUserDto user) {
    User newBook = userService.createNewUser(user);
    return ResponseEntity.ok(newBook);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserDto dto) {
    User user = userService.updateUser(id, dto);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(user);
  }


}
