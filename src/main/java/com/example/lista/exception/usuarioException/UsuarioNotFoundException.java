package com.example.lista.exception.usuarioException;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException() {
        super("Este id não existe, ou não foi encontrado!");
    }
}
