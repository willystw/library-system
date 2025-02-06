package com.willystw.librarysystem.controller;

import com.willystw.librarysystem.model.BorrowBookDto;
import com.willystw.librarysystem.model.Checkout;
import com.willystw.librarysystem.model.ReturnBookDto;
import com.willystw.librarysystem.service.CheckoutService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checkout")
public class CheckoutController {

  private final CheckoutService checkoutService;

  public CheckoutController(CheckoutService checkoutService) {
    this.checkoutService = checkoutService;
  }

  @PostMapping("/borrowBook")
  public ResponseEntity<Checkout> borrowBook(@RequestBody BorrowBookDto borrowBookDto) throws BadRequestException {
    Checkout checkout = checkoutService
        .borrowBook(borrowBookDto.getBookId(), borrowBookDto.getUserId());

    return ResponseEntity.ok(checkout);
  }

  @GetMapping("/late/{id}")
  public ResponseEntity<Long> isLateReturn(@PathVariable("id") Long bookId) throws BadRequestException {
    Long lateReturnDay = checkoutService.lateReturnDate(bookId);
    return ResponseEntity.ok(lateReturnDay);
  }

  @PostMapping("/returnBook")
  public ResponseEntity<Checkout> returnBook(@RequestBody ReturnBookDto returnBookDto) throws BadRequestException {
    Checkout checkout = checkoutService.returnBook(returnBookDto.getBookId());

    return ResponseEntity.ok(checkout);
  }
}
