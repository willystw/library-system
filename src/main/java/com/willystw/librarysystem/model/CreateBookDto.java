package com.willystw.librarysystem.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public class CreateBookDto {
  @NotEmpty
  private String title;

  private String author;

  private Integer edition;

  private String publisher;

  public CreateBookDto() {
  }

  public CreateBookDto(String title, String author, Integer edition, String publisher) {
    this.title = title;
    this.author = author;
    this.edition = edition;
    this.publisher = publisher;
  }

  public @NotEmpty String getTitle() {
    return title;
  }

  public void setTitle(@NotEmpty String title) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CreateBookDto that = (CreateBookDto) o;
    return Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(edition, that.edition) && Objects.equals(publisher, that.publisher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, edition, publisher);
  }

  @Override
  public String toString() {
    return "InsertNewBookDto{" +
        "title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", edition=" + edition +
        ", publisher='" + publisher + '\'' +
        '}';
  }
}
