package com.example.lista.exception.tarefaException;

import com.example.lista.dto.tarefaDTO.TarefaErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TarefaExceptionHandler {

    @ExceptionHandler(TarefaNotFoundException.class)
    public ResponseEntity<TarefaErrorDTO> handlerTarefaNotFoundException(TarefaNotFoundException e) {
        return ResponseEntity.status(404)
                .body(new TarefaErrorDTO(404, e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TarefaErrorDTO> handlerException(Exception e) {
        return ResponseEntity.status(500)
                .body(new TarefaErrorDTO(500, e.getMessage(), LocalDateTime.now()));
    }
}