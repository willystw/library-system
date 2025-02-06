package com.willystw.librarysystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class CreateUserDto {
  @NotEmpty
  private String name;

  private String address;

  @Email
  @JsonProperty("email")
  private String emailAddress;

  public CreateUserDto() {
  }

  public @NotEmpty String getName() {
    return name;
  }

  public void setName(@NotEmpty String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public @Email String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(@Email String emailAddress) {
    this.emailAddress = emailAddress;
  }
}
