package com.example.school.domain.exceptions;

import com.example.school.domain.exceptions.DomainException;
import com.example.school.domain.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DomainException.class)
  public ResponseEntity<Object> handleDomainException(DomainException ex) {
    ErrorCode errorCode = ex.getCode();
    String message = ex.getMessage();

    // Você pode personalizar a estrutura da resposta se necessário
    return ResponseEntity
        .status(getHttpStatus(errorCode))
        .body(new ErrorResponse(message, errorCode));
  }

  private HttpStatus getHttpStatus(ErrorCode errorCode) {
    switch (errorCode) {
      case USER_NOT_FOUND:
        return HttpStatus.NOT_FOUND; //Codigo HTTP = 404
      case EMAIL_EXISTENT:
        return HttpStatus.CONFLICT; //Codigo HTTP = 409
      case INVALID_PARAMS:
        return HttpStatus.BAD_REQUEST; //Codigo HTTP = 400
      default:
        return HttpStatus.INTERNAL_SERVER_ERROR; // Para outros erros Codigo HTTP = 500
    }
  }

  // Classe interna para a resposta de erro
  public static class ErrorResponse {
    private final String message;
    private final ErrorCode errorCode;

    public ErrorResponse(String message, ErrorCode errorCode) {
      this.message = message;
      this.errorCode = errorCode;
    }

    public String getMessage() {
      return message;
    }

    public ErrorCode getErrorCode() {
      return errorCode;
    }
  }
}