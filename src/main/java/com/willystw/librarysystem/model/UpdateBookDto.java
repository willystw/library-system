package com.willystw.librarysystem.model;

import jakarta.persistence.Column;

public class UpdateBookDto {
private String title;

  private String author;

  private Integer edition;

  private String publisher;

  @Column(name = "available")
  private Boolean isAvailable;

  public UpdateBookDto() {
  }

  public UpdateBookDto(Boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getEdition() {
    return edition;
  }

  public void setEdition(Integer edition) {
    this.edition = edition;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Boolean getAvailable() {
    return isAvailable;
  }

  public void setAvailable(Boolean available) {
    isAvailable = available;
  }
}
