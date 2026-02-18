package com.example.lista.exception.usuarioException;

public class CreateUsuarioException extends RuntimeException {

    public CreateUsuarioException() {
        super("Esse e-mail já foi utilizado!");
    }
}
