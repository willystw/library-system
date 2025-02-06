package com.willystw.librarysystem.repository;

import com.willystw.librarysystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Query(value = "SELECT * FROM books ORDER BY ID DESC", nativeQuery = true)
  Collection<Book> findAllBooks();

  @Query(value = "SELECT * FROM books b where b.id= :id", nativeQuery = true )
  Book findBookById(@Param("id") Long id);

}