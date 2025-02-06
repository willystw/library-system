package com.willystw.librarysystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

public class UpdateUserDto {
  private String name;

  private String address;

  @Email
  @JsonProperty("email")
  private String emailAddress;

  private Boolean active;

  public UpdateUserDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
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

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
