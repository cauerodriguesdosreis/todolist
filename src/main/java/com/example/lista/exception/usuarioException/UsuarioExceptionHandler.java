package com.example.lista.exception.usuarioException;

import com.example.lista.dto.usuarioDTO.UsuarioErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class UsuarioExceptionHandler {

    @ExceptionHandler(CreateUsuarioException.class)
    public ResponseEntity<UsuarioErrorDTO>handlerCreatedUsuarioException (CreateUsuarioException e){
        return ResponseEntity.badRequest().body(new UsuarioErrorDTO(400, e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(EmptyUsuarioListException.class)
    public ResponseEntity<UsuarioErrorDTO>handlerEmptyUsuarioListException (EmptyUsuarioListException e){
        return ResponseEntity.badRequest().body(new UsuarioErrorDTO(400, e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<UsuarioErrorDTO>handlerUsuarioNotFoundException (UsuarioNotFoundException e){
        return ResponseEntity.badRequest().body(new UsuarioErrorDTO(404, e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UsuarioErrorDTO>handlerException (Exception e){
        return ResponseEntity.badRequest().body(new UsuarioErrorDTO(500, e.getMessage(), LocalDateTime.now()));
    }

}
