package com.willystw.librarysystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnBookDto {
  @JsonProperty("book_id")
  private Long bookId;

  @JsonProperty("user_id")
  private Long userId;

  public ReturnBookDto() {
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
