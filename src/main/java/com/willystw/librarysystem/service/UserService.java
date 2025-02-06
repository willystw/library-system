package com.willystw.librarysystem.service;

import com.willystw.librarysystem.model.CreateUserDto;
import com.willystw.librarysystem.model.UpdateUserDto;
import com.willystw.librarysystem.model.User;
import com.willystw.librarysystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User createNewUser(CreateUserDto createUserDto) {
    User user = new User(
        null,
        createUserDto.getName(),
        createUserDto.getAddress(),
        LocalDateTime.now(),
        true,
        createUserDto.getEmailAddress()
    );

    return userRepository.save(user);
  }

  public User findById(Long id) {
    return userRepository.findUserById(id);
  }

  @Transactional
  public User updateUser(Long id, UpdateUserDto updateUserDto) {
    User user = userRepository.findUserById(id);
    if(user == null) {
      return null;
    }

    if(updateUserDto.getAddress() != null) {
      user.setAddress(updateUserDto.getAddress());
    }

    if(updateUserDto.getName() != null) {
      user.setName(updateUserDto.getName());
    }

    if(updateUserDto.getEmailAddress() != null) {
      user.setEmailAddress(updateUserDto.getEmailAddress());
    }

    if(updateUserDto.getActive() != null) {
      user.setActive(updateUserDto.getActive());
    }

    return userRepository.save(user);
  }
}
