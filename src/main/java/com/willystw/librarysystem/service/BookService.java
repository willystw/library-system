package com.willystw.librarysystem.service;

import com.willystw.librarysystem.model.Book;
import com.willystw.librarysystem.model.CreateBookDto;
import com.willystw.librarysystem.model.UpdateBookDto;
import com.willystw.librarysystem.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAllBooks().stream().toList();
  }

  public Book getBookById(Long id) {
    return bookRepository.findBookById(id);
  }

  @Transactional
  public Book insertNewBook(CreateBookDto createBookDto) {
    Book book = new Book(
        null,
        createBookDto.getTitle(),
        createBookDto.getAuthor(),
        createBookDto.getEdition(),
        createBookDto.getPublisher(),
        Boolean.TRUE);

    return bookRepository.save(book);
  }

  @Transactional
  public Book updateBook(Long id, UpdateBookDto updateBookDto) {
    Book book = bookRepository.findBookById(id);
    if(book == null) {
      return null;
    }
    if(updateBookDto.getAuthor() != null) {
      book.setAuthor(updateBookDto.getAuthor());
    }
    if(updateBookDto.getEdition() != null) {
      book.setEdition(updateBookDto.getEdition());
    }
    if(updateBookDto.getPublisher() != null) {
      book.setPublisher(updateBookDto.getPublisher());
    }
    if(updateBookDto.getTitle() != null) {
      book.setTitle(updateBookDto.getTitle());
    }
    if(updateBookDto.getAvailable() != null) {
      book.setAvailable(updateBookDto.getAvailable());
    }

    return bookRepository.save(book);
  }
}
