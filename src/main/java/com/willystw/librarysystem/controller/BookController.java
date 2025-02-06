package com.willystw.librarysystem.controller;

import com.willystw.librarysystem.model.Book;
import com.willystw.librarysystem.model.CreateBookDto;
import com.willystw.librarysystem.model.UpdateBookDto;
import com.willystw.librarysystem.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/findAll")
  public ResponseEntity<List<Book>> findAll() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Book> find(@PathVariable Long id) {
    Book book = bookService.getBookById(id);
    if(book == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(book);
  }

  @PostMapping("/create")
  public ResponseEntity<Book> create(@RequestBody CreateBookDto book) {
    Book newBook = bookService.insertNewBook(book);
    return ResponseEntity.ok(newBook);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody UpdateBookDto dto) {
    Book book = bookService.updateBook(id, dto);
    if(book == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(book);
  }

}
