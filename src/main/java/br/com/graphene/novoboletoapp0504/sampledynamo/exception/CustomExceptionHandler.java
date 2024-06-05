package br.com.graphene.novoboletoapp0504.sampledynamo.exception;

import com.amazonaws.services.kms.model.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.graphene.novoboletoapp0504.sampledynamo.dto.ErrorResponseMessage;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ResponseStatus(NOT_FOUND)
  @ExceptionHandler()
  public ErrorResponseMessage handleNotFoundException(
      NotFoundException exception
  ) {
    return new ErrorResponseMessage(
        NOT_FOUND.value(),
        exception.getMessage()
    );
  }
}
