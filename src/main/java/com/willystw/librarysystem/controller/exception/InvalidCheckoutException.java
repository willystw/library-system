package com.willystw.librarysystem.controller.exception;

public class InvalidCheckoutException extends RuntimeException {
  public InvalidCheckoutException(String message) {
    super(message);
  }
}
