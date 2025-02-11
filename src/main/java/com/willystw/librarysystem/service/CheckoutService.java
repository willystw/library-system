package com.willystw.librarysystem.service;

import com.willystw.librarysystem.config.CheckoutConfiguration;
import com.willystw.librarysystem.controller.exception.InvalidCheckoutException;
import com.willystw.librarysystem.model.Book;
import com.willystw.librarysystem.model.Checkout;
import com.willystw.librarysystem.model.UpdateBookDto;
import com.willystw.librarysystem.model.User;
import com.willystw.librarysystem.repository.CheckoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class CheckoutService {

  private final BookService bookService;
  private final UserService userService;

  private final CheckoutRepository checkoutRepository;
  private final CheckoutConfiguration checkoutConfiguration;

  public CheckoutService(BookService bookService,
                         UserService userService,
                         CheckoutRepository checkoutRepository,
                         CheckoutConfiguration checkoutConfiguration) {
    this.bookService = bookService;
    this.userService = userService;
    this.checkoutRepository = checkoutRepository;
    this.checkoutConfiguration = checkoutConfiguration;
  }

  @Transactional
  public Checkout borrowBook(Long bookId, Long userId) {
    Book book = bookService.getBookById(bookId);
    User user = userService.findById(userId);

    if(book != null && user != null && book.getAvailable() == Boolean.TRUE) {
      bookService.updateBook(bookId, new UpdateBookDto(
          Boolean.FALSE
      ));

      Checkout checkout = new Checkout();
      checkout.setUserId(userId);
      checkout.setBookId(bookId);
      checkout.setBorrowDate(LocalDateTime.now());
      checkout.setDeadline(checkoutConfiguration.getDeadline().intValue());
      checkout.setStatus(Checkout.Status.BORROW);

      return checkoutRepository.save(checkout);
    } else {
      throw new InvalidCheckoutException("[borrowBook] Book or user not found, or the book is already borrowed.");
    }
  }

  public Checkout getCheckoutData(Long checkoutId) {
    return checkoutRepository
        .findById(checkoutId)
        .orElseThrow(() -> new InvalidCheckoutException("[getCheckoutData] No checkout data found."));
  }

  public long lateReturnDate(Long bookId) {
    Checkout checkout = checkoutRepository.findBorrowedBookByBookId(bookId);
    if (checkout != null) {
      LocalDateTime borrowDate = checkout.getBorrowDate();
      //not late
      LocalDateTime deadline = borrowDate.plusDays(checkout.getDeadline());
      if (!LocalDateTime.now().isAfter(deadline)) {
        return 0L;
      } else {
        return ChronoUnit.DAYS.between(LocalDate.now(), deadline);
      }
    } else {
      throw new InvalidCheckoutException("[lateReturnDate] No checkout data found.");
    }
  }

  @Transactional
  public Checkout returnBook(Long bookId, Long userId) {
    Book book = bookService.getBookById(bookId);
    User user = userService.findById(userId);
    Checkout checkout = null;
    if(book != null) {
      checkout = checkoutRepository.findBorrowedBookByBookId(bookId);
    }

    if(user != null && checkout != null) {
      long lateDate = lateReturnDate(bookId);
      checkout.setTotalFine(lateDate * checkoutConfiguration.getDailyPenalty());
      if(lateDate > 0) {
        checkout.setStatus(Checkout.Status.RETURN_WITH_FINE);
      } else {
        checkout.setStatus(Checkout.Status.RETURN);
      }
      bookService.updateBook(bookId, new UpdateBookDto(
          Boolean.TRUE
      ));
      checkout.setReturnDate(LocalDateTime.now());
      return checkoutRepository.save(checkout);
    } else {
      throw new InvalidCheckoutException("[returnBook] Book not found, user not found, or checkout record not found.");
    }
  }
}
