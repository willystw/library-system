package com.willystw.librarysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "checkout")
@Entity
public class Checkout {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
  private User user;

  @Column(name = "user_id")
  private Long userId;

  @ManyToOne(targetEntity = Book.class)
  @JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
  private Book book;

  @Column(name = "book_id")
  private Long bookId;

  @Column(name = "borrow_date")
  private LocalDateTime borrowDate;

  private int deadline;

  @Column(name = "return_date")
  private LocalDateTime returnDate;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "total_fine")
  private Long totalFine;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public LocalDateTime getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(LocalDateTime borrowDate) {
    this.borrowDate = borrowDate;
  }

  public int getDeadline() {
    return deadline;
  }

  public void setDeadline(int deadline) {
    this.deadline = deadline;
  }

  public LocalDateTime getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDateTime returnDate) {
    this.returnDate = returnDate;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Long getTotalFine() {
    return totalFine;
  }

  public void setTotalFine(Long totalFine) {
    this.totalFine = totalFine;
  }

  public enum Status {
    BORROW,
    RETURN,
    RETURN_WITH_FINE
  }
}
