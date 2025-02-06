package com.willystw.librarysystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Table
@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String name;

  private String address;

  @Column(name = "join_date")
  private LocalDateTime joinDate;

  @Column(name = "active")
  private boolean isActive;

  @Column(name = "email_address")
  @Email
  private String emailAddress;

  @JsonIgnore
  @OneToMany(mappedBy = "user",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private Set<Checkout> checkouts;

  public User() {
  }

  public User(Long id, String name, String address, LocalDateTime joinDate, boolean isActive, String emailAddress) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.joinDate = joinDate;
    this.isActive = isActive;
    this.emailAddress = emailAddress;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public LocalDateTime getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(LocalDateTime joinDate) {
    this.joinDate = joinDate;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public @Email String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(@Email String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Set<Checkout> getCheckouts() {
    return checkouts;
  }

  public void setCheckouts(Set<Checkout> checkouts) {
    this.checkouts = checkouts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return isActive == user.isActive && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(address, user.address) && Objects.equals(joinDate, user.joinDate) && Objects.equals(emailAddress, user.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, joinDate, isActive, emailAddress);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", joinDate=" + joinDate +
        ", isActive=" + isActive +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
