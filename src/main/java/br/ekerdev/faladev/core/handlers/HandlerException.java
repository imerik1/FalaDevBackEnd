package br.ekerdev.faladev.core.handlers;

import br.ekerdev.faladev.shared.dtos.ErrorMessageDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorMessageDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorMessageDto errors = new ErrorMessageDto();
        errors.setStatus(HttpStatus.BAD_REQUEST);
        errors.setMessage(ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
