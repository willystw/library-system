package com.willystw.librarysystem.repository;

import com.willystw.librarysystem.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

  @Query(
      value = "SELECT * FROM checkout WHERE book_id=:bookId AND status='BORROW'",
      nativeQuery = true
  )
  Checkout findBorrowedBookByBookId(@Param("bookId") Long bookId);
}
